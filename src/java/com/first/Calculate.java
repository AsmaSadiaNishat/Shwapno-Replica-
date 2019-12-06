/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.first;

import com.DB.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author success
 */
@WebServlet(name = "Calculate", urlPatterns = "/Calculate")
public class Calculate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        Connection con = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql, name;
        int price, qty, sub, id;

        name = request.getParameter("name");
        id = Integer.parseInt(request.getParameter("product_id"));
        price = Integer.parseInt(request.getParameter("price"));
        qty = Integer.parseInt(request.getParameter("qty"));

        sub = price * qty;

        System.out.println(sub);

        try {

            PrintWriter out = response.getWriter();

            
            sql = "insert into orders(product_id, product_name, quantity, price, login_id) values(?,?,?,?, ?)";
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, qty);
            ps.setInt(4, sub);
            ps.setInt(5, 1);
            ps.executeUpdate();
/*
            ServletContext sc = getServletContext();
            sc.getRequestDispatcher("/view/index.html").forward(request, response);
            */

response.sendRedirect("/view/viewcart.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
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
