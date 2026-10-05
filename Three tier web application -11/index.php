<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
            $conn=new mysqli("localhost","root","test@123","mysql");
            if($conn->connect_error){
                die("Connection Failed");
            }
            $name=$_POST['name'];
            $email=$_POST['email'];
            $phone=$_POST['phone'];
            $lat=$_POST['lat'];
            $lon=$_POST['lon'];
            $sql="INSERT INTO custdetails (name, mail, phone, latitude, longitude) VALUES ('$name','$email','$phone','$lat','$lon')";
            if($conn->query($sql)===TRUE){
                echo "<h2>Ordered Successfully !</h2>";
            }
            echo "<h1>Order Details</h1>";
            $sql="SELECT * FROM custdetails";
            $result=$conn->query($sql);
            echo "<table border=1>";
            echo "<tr><th>Name</th><th>Email</th><th>Phone</th><th>Latitude</th><th>Longitude</th></tr>";
            while($row=$result->fetch_assoc()){
                echo "<tr><td>".$row['name']."</td><td>".$row['mail']."</td><td>".$row['phone']."</td><td>".$row['latitude']."</td><td>".$row['longitude']."</td></tr>";
            }
            echo "</table>";
            $conn->close();
        ?>
    </body>
</html>
