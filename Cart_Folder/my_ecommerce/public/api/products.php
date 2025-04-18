<?php
// Set response type to JSON
header('Content-Type: application/json');

// Include the database connection
require_once __DIR__ . '/../../includes/db_connect.php';

try {
    // Fetch all products with key details for display
    $stmt = $pdo->query("
        SELECT 
            product_num, 
            title, 
            artist, 
            price, 
            image_url, 
            stock_quantity 
        FROM products
    ");

    $products = $stmt->fetchAll(PDO::FETCH_ASSOC);

    // Return the product list as a success response
    echo json_encode([
        'success' => true,
        'data' => $products
    ]);

} catch (PDOException $e) {
    // Return a 500 error and the exception message if the query fails
    http_response_code(500);
    echo json_encode([
        'success' => false,
        'error' => 'Database error: ' . $e->getMessage()
    ]);
}
?>
