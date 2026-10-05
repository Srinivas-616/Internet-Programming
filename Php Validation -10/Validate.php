<?php
	$errors = array();
	$name = $_POST['name'];
	$email = $_POST['email'];
    	$pass = $_POST['pass'];
    	$card = $_POST['card'];
    	$phone = $_POST['phone'];
    	if(!preg_match("/^[A-Za-z]+$/",$name)){
       		$errors[] = "Invalid Name Format";
    	}
    	if(!preg_match("/^[A-Za-z0-9]+@[A-Za-z0-9]+\.[A-Za-z]{2,}$/",$email)){
        	$errors[] = "Invalid Email Format";
    	}
   	if(!preg_match("/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9]{8,16}$/",$pass)){
 	   	$errors[] = "Invalid Password Format";
    	}
    	if(!preg_match("/^[0-9]{16}$/",$card)){
       		$errors[] = "Invalid Credit Card Format";
    	}

    	if(!preg_match("/^[0-9]{10}$/",$phone)){
        	$errors[] = "Invalid Phone Number Format";
    	}
	if(count($errors)>0){
		echo "<h2> Validation Errors</h2>";
		foreach($errors as $error){
			echo "<p>$error</p>";
		}
		echo "<br>";
	}else{
		echo "<h2>Registration Successful!</h2>";
		echo "<p><b>Name :</b>".htmlspecialchars($name)."</p>";
		echo "<p><b>Email :</b>".htmlspecialchars($email)."</p>";
		echo "<p><b>Password :</b>".htmlspecialchars($pass)."</p>";
		echo "<p><b>Credit card number:</b>".htmlspecialchars($card)."</p>";
		echo "<p><b>Phone :</b>".htmlspecialchars($phone)."</p>";
	}
?>