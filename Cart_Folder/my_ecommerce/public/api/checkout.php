<?php
// Set response type to JSON
header('Content-Type: application/json');

// Start session to access user and cart data
session_start();

// Include database connection
require_once __DIR__ . '/../../includes/db_connect.php';

// Check if user is authenticated
if (!isset($_SESSION['user_id'])) {
    http_response_code(401); // Unauthorized
    die(json_encode(['success' => false, 'error' => 'Not authenticated']));
}

try {
    // Begin database transaction
    $pdo->beginTransaction();

    // Retrieve user ID from session
    $userId = $_SESSION['user_id'];

    $total = 0;                 // Total order amount
    $cartItems = [];            // Store valid cart items

    // Loop through each cart item to calculate total and validate stock
    foreach ($_SESSION['cart'] as $productId => $quantity) {
        $stmt = $pdo->prepare("
            SELECT price, stock_quantity 
            FROM products 
            WHERE product_num = ?
        ");
        $stmt->execute([$productId]);
        $product = $stmt->fetch();

        if (!$product) throw new Exception("Product $productId not found");
        if ($product['stock_quantity'] < $quantity) {
            throw new Exception("Insufficient stock for product $productId");
        }

        // Add product's subtotal to total
        $subtotal = $product['price'] * $quantity;
        $total += $subtotal;

        // Store item for later order insertion
        $cartItems[$productId] = $quantity;
    }

    // Create a new order in the orders table
    $stmt = $pdo->prepare("
        INSERT INTO orders (user_id, total, status, created_at)
        VALUES (?, ?, 'pending', NOW())
    ");
    $stmt->execute([$userId, $total]);
    $orderId = $pdo->lastInsertId(); // Get the newly created order ID

    // Add each item in the cart to the order_items table
    foreach ($cartItems as $productId => $quantity) {
        $stmt = $pdo->prepare("
            INSERT INTO order_items (order_id, product_num, quantity, price)
            SELECT ?, ?, ?, price FROM products WHERE product_num = ?
        ");
        $stmt->execute([$orderId, $productId, $quantity, $productId]);
    }

    // Commit the transaction
    $pdo->commit();

    // Clear the cart from session
    unset($_SESSION['cart']);

    // Respond with order success details
    echo json_encode([
        'success' => true,
        'order_id' => $orderId,
        'total' => $total
    ]);

} catch (Exception $e) {
    // Rollback if anything goes wrong
    $pdo->rollBack();
    http_response_code(400); // Bad Request
    echo json_encode(['success' => false, 'error' => $e->getMessage()]);
}
?>
