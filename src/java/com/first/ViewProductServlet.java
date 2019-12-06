/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.first;

import com.DB.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jahid
 */
@WebServlet(name = "ViewProductServlet", urlPatterns = {"/ViewProductServlet"})
public class ViewProductServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            Connection con = DBConnection.createConnection();
            PreparedStatement ps = null;
            Statement s = null;
            ResultSet rs = null;

            String sql = "SELECT product_image FROM Add_Product";

            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "<style>\n"
                    + "ul {\n"
                    + "  list-style-type: none;\n"
                    + "  margin: 0;\n"
                    + "  padding: 0;\n"
                    + "  overflow: hidden;\n"
                    + "  background-color: black;\n"
                    + "}\n"
                    + "\n"
                    + "li {\n"
                    + "  float: left;\n"
                    + "}\n"
                    + "\n"
                    + "li a {\n"
                    + "  display: block;\n"
                    + "  color: white;\n"
                    + "  text-align: center;\n"
                    + "  padding: 24px 26px;\n"
                    + "  text-decoration: none;\n"
                    + "}\n"
                    + "\n"
                    + "li :hover{\n"
                    + " background-color: red;\n"
                    + "\n"
                    + "}\n"
                    + "\n"
                    + "\n"
                    + "li a:hover:not(.active) {\n"
                    + "  background-color: palevioletred;\n"
                    + "  color: black;\n"
                    + "}\n"
                    + "\n"
                    + ".active {\n"
                    + "  background-color: palevioletred;\n"
                    + "}\n"
                    + "</style>\n"
                    + "\n"
                    + "\n"
                    + "	<title>Bootstrap Product Grid</title>\n"
                    + "	<!-- Bootstrap css -->\n"
                    + "	<link rel=\"stylesheet\" type=\"text/css\" href=\"view/css/bootstrap.min.css\">\n"
                    + "	<!-- Style css -->\n"
                    + "	<link rel=\"stylesheet\" type=\"text/css\" href=\"view/css/product.css\">\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "\n"
                    + "\n"
                    + "<ul>\n"
                    + "  <li><a href=\"view/index.html\">Home</a></li>\n"
                    + "  <li><a href=\"view/mycart.html\">My Cart</a></li>\n"
                    + "  <li><a href=\"view/aboutus.html\">About Us</a></li>\n"
                    + "  <li style=\"float:right\"><a class=\"active\" href=\"view/product.html\">My Store</a></li>\n"
                    + "</ul>\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "	<div class=\"container\">\n"
                    + "\n"
                    + "		<h1 class=\"text-center\">SHOP FROM HERE</h1>\n"
                    + "		<hr>");
            try {
                s = con.createStatement();
                rs = s.executeQuery(sql);

                while (rs.next()) {
                    out.println("<div class=\"row\">");
                    out.println("<div class=\"col-md-4 product-grid\">");
                    out.println("<div class=\"image\">");
                    out.println("<a href=\"view/grocery_view_prod_1.html\">");
                    out.println("<img src=" + rs.getBytes("product_image") + " class=\"w-100\">");
                    out.println("<div class=\"overlay\">");
                    out.println("<div class=\"detail\">View Details</div>");
                    out.println("</div> </a> </div>");
                    out.println("<h5 class=\"text-center\" ></h5>");
                    out.println("<h5 class=\"text-center\">Price:</h5>");
                    out.println("<a href=\"view/grocery_buy_prod_1.html\" class=\"btn buy\">BUY</a> </div> </div>");
                }

            } catch (Exception e) {

            }

            out.println("</body> </html>");
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
