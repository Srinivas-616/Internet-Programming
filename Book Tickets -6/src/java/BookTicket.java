/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 24uad115
 */
@WebServlet(urlPatterns = {"/BookTicket"})
public class BookTicket extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
String movie=request.getParameter("movie");
        String timing=request.getParameter("timing");
        int seat=Integer.parseInt(request.getParameter("seat"));
        String date=request.getParameter("date");
        int price=Integer.parseInt(request.getParameter("price"));
        PrintWriter out = response.getWriter();
        try{            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","test@123");
            PreparedStatement ps=con.prepareStatement("INSERT INTO star (movie, timing, seat, movie_date, price) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1,movie);
            ps.setString(2,timing);
            ps.setInt(3,seat);
            ps.setString(4,date);
            ps.setInt(5,price);
            ps.executeUpdate();
            ps = con.prepareStatement("SELECT * FROM star");
             ResultSet rs = ps.executeQuery();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>All Bookings</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>All Bookings</h1>");

        out.println("<table border='1'>");

        out.println("<tr>");
        out.println("<th>Movie</th>");
        out.println("<th>Timing</th>");
        out.println("<th>Seat</th>");
        out.println("<th>Date</th>");
        out.println("<th>Price</th>");
        out.println("</tr>");

        while (rs.next()) {

            out.println("<tr>");

            out.println("<td>" + rs.getString("movie") + "</td>");
            out.println("<td>" + rs.getString("timing") + "</td>");
            out.println("<td>" + rs.getInt("seat") + "</td>");
            out.println("<td>" + rs.getString("movie_date") + "</td>");
            out.println("<td>" + rs.getInt("price") + "</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");

        rs.close();
        ps.close();
        con.close();
        
        }catch(Exception e1){
            e1.printStackTrace();
            out.println("Error: " + e1.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
