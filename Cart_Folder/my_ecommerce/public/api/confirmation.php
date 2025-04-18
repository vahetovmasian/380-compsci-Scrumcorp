<?php
// Set the response type to JSON
header('Content-Type: application/json');

// Include the database connection
require_once __DIR__ . '/../../includes/db_connect.php';

// Get the order ID from the query parameter
$orderId = $_GET['order_id'] ?? null;

// Check if order ID is provided
if (!$orderId) {
    echo json_encode(['success' => false, 'error' => 'Order ID missing']);
    exit;
}

// Retrieve order details including items and associated product info
$stmt = $pdo->prepare("
    SELECT 
        o.order_id, 
        o.total, 
        o.created_at, 
        oi.quantity, 
        p.title, 
        p.price
    FROM orders o
    JOIN order_items oi ON o.order_id = oi.order_id
    JOIN products p ON oi.product_num = p.product_num
    WHERE o.order_id = ?
");
$stmt->execute([$orderId]);
$orderDetails = $stmt->fetchAll();

// Return the order information as a JSON response
echo json_encode(['success' => true, 'data' => $orderDetails]);
?>


