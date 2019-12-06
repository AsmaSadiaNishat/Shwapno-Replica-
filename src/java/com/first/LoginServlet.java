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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jahid
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    /*
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        session.invalidate();
        Cookie userNameCookieRemove = new Cookie("username", "");
        userNameCookieRemove.setMaxAge(0);
        response.addCookie(userNameCookieRemove);
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/profile").forward(request, response);

    }
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        

        c = oracle.oracle();

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        try {

            sql = "SELECT name, password FROM Registration WHERE name = ? and password = ?";
            ps = c.prepareStatement(sql);

            ps.setString(1, userName);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if (rs.next()) {
                //if (userName.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
  
                    RequestDispatcher rd = request.getRequestDispatcher("/grocery.html");
                    rd.forward(request, response);
                } else  {
                    
                    ServletContext sc = getServletContext();
                    sc.getRequestDispatcher("/login.html").forward(request, response);
                }
            
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
