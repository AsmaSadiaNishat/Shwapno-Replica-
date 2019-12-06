/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.first;

import com.DB.DBConnection;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Jahid
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig
public class UploadServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        PrintWriter out = response.getWriter();
        
        Connection connection = DBConnection.createConnection();
        PreparedStatement preparedStatement = null;
        Statement s = null;
        ResultSet rs = null;

        int product_id = Integer.parseInt(request.getParameter("product_id"));
        String product_name = request.getParameter("product_name");
        String catagory = request.getParameter("catagory");
        String weight = request.getParameter("weight");
        String product_size = request.getParameter("product_size");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int unit_price = Integer.parseInt(request.getParameter("unit_price"));

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        //InputStream fileContent = filePart.getInputStream();
        String fileName = extractFileName(filePart); // MSIE fix.
        String savepath = "G:\\Sadia_Nishat\\4-2\\Shwapno\\web\\view\\productImage\\" +File.separator +fileName;
        
        String Name = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        File save = new File(savepath);
        
        filePart.write(savepath +File.separator);
        

        String sql = "INSERT INTO ADD_PRODUCT(product_id, product_name, catagory, "
                + "weight, product_size, quantity, unit_price, image_link) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, product_id);
            preparedStatement.setString(2, product_name);
            preparedStatement.setString(3, catagory);
            preparedStatement.setString(4, weight);
            preparedStatement.setString(5, product_size);
            preparedStatement.setInt(6, quantity);
            preparedStatement.setInt(7, unit_price);
            //preparedStatement.setBlob(8, fileContent);
            preparedStatement.setString(8, Name);
            
            int i = preparedStatement.executeUpdate();
            if (i > 0)
            {
                out.println ("Successfully uploaded into DB!");
                
            }
        } catch (Exception e) {

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

    private String extractFileName(Part filePart) {
 
        String cd = filePart.getHeader("content-disposition");
        String [] items = cd.split(";");
        for (String s : items)
        {
            if (s.trim().startsWith("filename"))
            {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
//To change body of generated methods, choose Tools | Templates.
return "";
    }

}
