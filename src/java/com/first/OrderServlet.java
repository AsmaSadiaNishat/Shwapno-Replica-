/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nishat
 */
@WebServlet(name = "OrderServlet", urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;

        c = oracle.oracle();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String product = request.getParameter("name");

        int price = Integer.parseInt(request.getParameter("price"));
        int pid = Integer.parseInt(request.getParameter("product_id"));
        int qty = Integer.parseInt(request.getParameter("qty"));

        int total = price*qty;

        try {
            
            out.println("<html> <body>");
            out.println("<h2>" + total + "</h2>");
            out.println("</html> </body>");
/*
            sql = "insert into usercart values(?,?,?,?,?)";
            ps = c.prepareStatement(sql);

            ps.setString(1, product);
            ps.setInt(2, price);
            ps.setInt(3, subtotal);
            ps.setInt(4, shipping);
            ps.setInt(5, total);

            int i = ps.executeUpdate();
            if (i > 0) {

                ServletContext sc = getServletContext();
                sc.getRequestDispatcher("/view/checkout.html").forward(request, response);

            }
*/
        } catch (Exception e2) {
            e2.printStackTrace();

        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
    }
}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
