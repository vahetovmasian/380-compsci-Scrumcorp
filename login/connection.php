<?php

$dbhost = "localhost:3307";
$dbuser= "root";
$dbpass = '';
$dbname = "login_sample_db";

$con = mysqli_connect($dbhost, $dbuser, $dbpass, $dbname);

if (!$con) {
    die("Failed to connect: " . mysqli_connect_error());
}