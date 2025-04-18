<?php
// Database Configuration Constants
const DB_HOST = 'localhost';         // Database host
const DB_NAME = 'checkout_db';       // Database name
const DB_USER = 'root';              // Database username
const DB_PASS = '';                  // Database password
const DB_CHARSET = 'utf8mb4';        // Character set for encoding

// Configure Secure Session Parameters
session_set_cookie_params([
    'lifetime' => 86400,             // Session lifetime: 1 day
    'path' => '/',
    'domain' => $_SERVER['HTTP_HOST'],
    'secure' => false,               // Set to true when using HTTPS in production
    'httponly' => true,              // Prevent JavaScript access to session cookie
    'samesite' => 'Lax'              // Restrict cross-site sending of cookies
]);
session_start();                     // Start the session

// Establish Database Connection using PDO
try {
    $pdo = new PDO(
        "mysql:host=" . DB_HOST . ";dbname=" . DB_NAME . ";charset=" . DB_CHARSET,
        DB_USER,
        DB_PASS,
        [
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,        // Throw exceptions on errors
            PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,   // Return results as associative arrays
            PDO::ATTR_EMULATE_PREPARES => false                 // Use native prepared statements
        ]
    );
} catch (PDOException $e) {
    // Log error and show generic message if connection fails
    error_log("Database Error: " . $e->getMessage());
    die("Database connection error");
}

// Set Basic Security Headers
header('X-Content-Type-Options: nosniff');  // Prevent MIME-type sniffing
header('X-Frame-Options: DENY');            // Prevent clickjacking
?>
