<%-- 
    Document   : OrderDetails
    Created on : 3 Sep, 2026, 3:30:58 PM
    Author     : 24uad115
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Customer Details:</h1>
        <%
            String name=request.getParameter("name");
            String mail=request.getParameter("mail");
            String phone=request.getParameter("phone");
            String lat=request.getParameter("lat");
            String lon=request.getParameter("lon");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","test@123");
            PreparedStatement ps=con.prepareStatement("INSERT INTO custdetails (name, mail, phone, latitude, longitude) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1,name);
            ps.setString(2,mail);
            ps.setString(3,phone);
            ps.setString(4,lat);
            ps.setString(5,lon);
            ps.executeUpdate();
            ps = con.prepareStatement("SELECT * FROM custdetails");
            ResultSet rs = ps.executeQuery();
        

        
           %>
        <table border='1'>

        <tr>
       <th>Name</th>
       <th>Mail</th>
       <th>Phone</th>
       <th>Latitude</th>
       <th>Longitude</th>
       </tr>
       <%
        while (rs.next()) {
        %>
         <tr>

             <td><%= rs.getString("name")%></td>
            <td><%= rs.getString("mail") %></td>
            <td><%= rs.getString("phone") %></td>
            <td><%= rs.getString("latitude")%></td>
            <td><%= rs.getString("longitude")%></td>

         </tr>
         <%
        }
        %>
        </table>
        <%    
        rs.close();
        ps.close();
        con.close();
        %>
    </body>
</html>
