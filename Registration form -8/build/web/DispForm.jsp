<%-- 
    Document   : DispForm
    Created on : 3 Sep, 2026, 2:10:51 PM
    Author     : 24uad115
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details</title>
        <style>
            div{
            margin:175px;
            padding:20px;
            margin-left:600px;
            background-color: cornsilk;
            width:325px;
            border-radius: 25px;
        }
        </style>
    </head>
    <body>
        <% String uname=request.getParameter("uname");
           String passwd=request.getParameter("passwd");
           String name=request.getParameter("name");
           String cc=request.getParameter("cc");
           String mail=request.getParameter("mail");
           String phone=request.getParameter("phone");
        %>
        
        <div>
            <h1>Registration Details:</h1>
            <table cellspacing="15">
                    <tr>
                        <td>User_Name :</td>
                        <td><%= uname%></td>
                    </tr>
                    <tr>
                        <td>Password :</td>
                        <td><%= passwd%></td>
                    </tr>
                    <tr>
                        <td>Name :</td>
                        <td><%= name%></td>
                    </tr>
                    <tr>
                        <td>Credit card number :</td>
                        <td><%= cc%></td>
                    </tr>
                    <tr>
                        <td>Email :</td>
                        <td><%= mail%></td>
                    </tr>
                    <tr>
                        <td>Phone :</td>
                        <td><%= phone%></td>
                    </tr>             
            </table>
        </div>
    </body>
</html>
