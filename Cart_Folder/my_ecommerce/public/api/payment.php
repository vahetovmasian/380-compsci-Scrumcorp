<?php
// Set response type to JSON
header('Content-Type: application/json');

// Include database connection
require_once __DIR__ . '/../../includes/db_connect.php';

// Decode the incoming JSON payload
$input = json_decode(file_get_contents('php://input'), true);

// Extract relevant fields from input
$orderId = $input['order_id'] ?? null;
$paymentMethod = $input['payment_method'] ?? 'credit_card'; // Default method
$paymentAmount = $input['payment_amount'] ?? null;

// Validate required fields
if (!$orderId || !$paymentAmount) {
    echo json_encode(['success' => false, 'error' => 'Missing order ID or payment amount']);
    exit;
}

try {
    // Insert new payment record into payments table
    $stmt = $pdo->prepare("
        INSERT INTO payments (order_id, payment_method, payment_status, payment_amount, payment_date)
        VALUES (?, ?, 'completed', ?, NOW())
    ");
    $stmt->execute([$orderId, $paymentMethod, $paymentAmount]);

    // Update the corresponding order's status to "paid"
    $stmt = $pdo->prepare("UPDATE orders SET status = 'paid' WHERE order_id = ?");
    $stmt->execute([$orderId]);

    // Return success and new payment ID
    echo json_encode(['success' => true, 'payment_id' => $pdo->lastInsertId()]);
} catch (PDOException $e) {
    // Handle database error
    echo json_encode(['success' => false, 'error' => $e->getMessage()]);
}
?>
