<?php
// Start session to track the user's shopping cart
session_start();

// Set response format to JSON
header('Content-Type: application/json');

// Include database connection
require_once __DIR__ . '/../../includes/db_connect.php';

// Allow only POST requests for adding items to the cart
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    http_response_code(405); // Method Not Allowed
    die(json_encode(['success' => false, 'error' => 'Only POST allowed']));
}

// Get input data from the request body
$input = json_decode(file_get_contents('php://input'), true);
$productId = $input['product_id'] ?? null;     // Product to add
$quantity = $input['quantity'] ?? 1;           // Quantity to add (default is 1)

// Validate the product ID
if (!$productId || !is_numeric($productId)) {
    http_response_code(400); // Bad Request
    die(json_encode(['success' => false, 'error' => 'Invalid product']));
}

// Initialize the cart if it doesn't exist yet
if (!isset($_SESSION['cart'])) {
    $_SESSION['cart'] = [];
}

// Check if the product exists in the database
$stmt = $pdo->prepare("SELECT product_num FROM products WHERE product_num = ?");
$stmt->execute([$productId]);
if (!$stmt->fetch()) {
    http_response_code(404); // Not Found
    die(json_encode(['success' => false, 'error' => 'Product not found']));
}

// Add or update the product quantity in the cart
$_SESSION['cart'][$productId] = ($_SESSION['cart'][$productId] ?? 0) + $quantity;

// Return success response with updated cart count
$cartCount = array_sum($_SESSION['cart']);
echo json_encode([
    'success' => true,
    'cart_count' => $cartCount,
    'cart' => $_SESSION['cart']
]);
?>