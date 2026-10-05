<%-- 
    Document   : newjsp
    Created on : 29 Sep, 2026, 10:09:21 AM
    Author     : 24uad115
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
        function loadOrders() {

            var xhttp = new XMLHttpRequest();

            xhttp.onreadystatechange = function () {

                if (this.readyState == 4 && this.status == 200) {

                    var xml = this.responseXML;

                    var orders = xml.getElementsByTagName("order");

                    var output = "<h2>Order Details</h2>";

                    output += "<table border='1' cellpadding='10'>";
                    
                    output += "<tr>";
                    output += "<th>ID</th>";
                    output += "<th>Customer</th>";
                    output += "<th>Product</th>";
                    output += "<th>Quantity</th>";
                    output += "<th>Price</th>";
                    output += "</tr>";

                    for (var i = 0; i < orders.length; i++) {

                        var id =
                            orders[i].getElementsByTagName("id")[0]
                            .childNodes[0].nodeValue;

                        var customer =
                            orders[i].getElementsByTagName("customer")[0]
                            .childNodes[0].nodeValue;

                        var product =
                            orders[i].getElementsByTagName("product")[0]
                            .childNodes[0].nodeValue;

                        var quantity =
                            orders[i].getElementsByTagName("quantity")[0]
                            .childNodes[0].nodeValue;

                        var price =
                            orders[i].getElementsByTagName("price")[0]
                            .childNodes[0].nodeValue;

                        output += "<tr>";

                        output += "<td>" + id + "</td>";
                        output += "<td>" + customer + "</td>";
                        output += "<td>" + product + "</td>";
                        output += "<td>" + quantity + "</td>";
                        output += "<td>" + price + "</td>";

                        output += "</tr>";
                    }

                    output += "</table>";

                    document.getElementById("orderData").innerHTML = output;
                }
            };

            xhttp.open("GET", "orders.xml", true);

            xhttp.send();
        }
    </script>
    </head>
    <body>
        <h1>Online Shopping - Order Viewer</h1>

        <button onclick="loadOrders()">
        Load Orders
        </button>

        <br><br>

        <div id="orderData"></div>
        </body>
</html>
