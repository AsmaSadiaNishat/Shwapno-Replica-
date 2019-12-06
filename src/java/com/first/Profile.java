package com.first;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

@WebServlet(name = "Profile", urlPatterns = "/profile")

public class Profile extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql, table, style, html;

        try (PrintWriter w = response.getWriter()) {

            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            /*
            c = oracle.oracle();

            sql = "SELECT * FROM SEC_B ORDER BY ID";

            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
             */
            w.println("<head>");
            w.println("<title> Displaying from Database </title>");
            w.println("<style>");
            w.println("body {background-color:blue}");
            w.println("caption, table, th, td { ");
            w.println("border:2px solid black;");
            w.println("border-collapse:collapse;");
            w.println("color:white;");
            w.println("font-family:courier new;");
            w.println("font-size:120%; }");
            w.println("</style>");
            w.println("</head>");
            w.println("<body>");
            w.println("<hr>");
            w.println("<table align=center>");
            w.println("<caption> Student Record: </caption>");
            w.println("<tr>");
            w.println("<th> Student ID </th>");
            w.println("<th> Student Name </th>");
            w.println("</th>");
            
            while (rs.next()){

                w.println ("<tr>");
                w.println ("<td>" +rs.getInt(1) +"</td>");
                w.println ("<td>" +rs.getString(2) +"</td>");
                w.println ("</tr>");
            }
             
            w.println("</table>");
            w.println("<hr>");
            w.println("</body>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sql, table, style, html;

        try (PrintWriter w = response.getWriter()) {

            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            /*
            c = oracle.oracle();

            sql = "SELECT * FROM SEC_B ORDER BY ID";

            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
             */
            w.println("<head>");
            w.println("<title> Displaying from Database </title>");
            w.println("<style>");
            w.println("body {background-color:blue}");
            w.println("caption, table, th, td { ");
            w.println("border:2px solid black;");
            w.println("border-collapse:collapse;");
            w.println("color:white;");
            w.println("font-family:courier new;");
            w.println("font-size:120%; }");
            w.println("</style>");
            w.println("</head>");
            w.println("<body>");
            w.println("<hr>");
            w.println("<table align=center>");
            w.println("<caption> Student Record: </caption>");
            w.println("<tr>");
            w.println("<th> Student ID </th>");
            w.println("<th> Student Name </th>");
            w.println("</th>");
            /*
            while (rs.next()){

                w.println ("<tr>");
                w.println ("<td>" +rs.getInt(1) +"</td>");
                w.println ("<td>" +rs.getString(2) +"</td>");
                w.println ("</tr>");
            }
             */
            w.println("</table>");
            w.println("<hr>");
            w.println("</body>");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
