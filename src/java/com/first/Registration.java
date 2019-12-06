/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Student
 */
@WebServlet(name = "Registration", urlPatterns = "/Registration")
public class Registration extends HttpServlet {

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

        String n=request.getParameter("username");  
        String e=request.getParameter("useremail");  
        String m=request.getParameter("usermobile");  
        String p=request.getParameter("password");  

        try {

            sql = "insert into Registration values(?,?,?,?)";
            ps = c.prepareStatement(sql);

            ps.setString(1, n);
            ps.setString(2, e);
            ps.setString(3, m);
            ps.setString(4, p);

            int i = ps.executeUpdate();
            if (i>0) {
                out.println("You are successfully registered !!!");
                out.println("<a class=\"vp\" href=\"viewprofile.html\">Go to Profile</a>");
                
                }
            
            
          

        }catch (Exception e2) {
            e2.printStackTrace();

        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    

}
}
