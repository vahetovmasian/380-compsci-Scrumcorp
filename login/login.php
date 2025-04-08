<?php
session_start();

include("connection.php");
include("functions.php");

$error = "";

if ($_SERVER['REQUEST_METHOD'] == "POST") {
    $user_name = $_POST['user_name'];
    $password = $_POST['password'];

    if (!empty($user_name) && !empty($password) && !is_numeric($user_name)) {
        $query = "SELECT * FROM users WHERE user_name = '$user_name' LIMIT 1";
        $result = mysqli_query($con, $query);

        if ($result && mysqli_num_rows($result) > 0) {
            $user_data = mysqli_fetch_assoc($result);

            if (password_verify($password, $user_data['password'])) {
                $_SESSION['user_id'] = $user_data['user_id'];
                header("Location: index.php");
                die;
            }
        }

        $error = "Wrong username or password!";
    } else {
        $error = "Please enter some valid information!";
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style type="text/css">
        #text {
            height: 25px;
            border-radius: 5px;
            padding: 4px;
            border: solid thin #aaa;
        }

        #button {
            padding: 10px;
            width: 100px;
            color: white;
            background-color: lightblue;
            border: none;
        }

        #box {
            background-color: grey;
            margin: auto;
            width: 300px;
            padding: 20px;
        }
    </style>
</head>
<body>

    <div id="box">
        <form method="post">
            <div style="font-size: 20px; margin: 10px; color: white;">Login</div>

            <?php if (!empty($error)): ?>
                <p style="color: red;"><?php echo $error; ?></p>
            <?php endif; ?>

            <input id="text" type="text" name="user_name" placeholder="Username"><br><br>
            <input id="text" type="password" name="password" placeholder="Password"><br><br>

            <input id="button" type="submit" value="Login"><br><br>

            <a href="signup.php">Create Account</a>
        </form>
    </div>

</body>
</html>
