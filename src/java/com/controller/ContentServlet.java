
package com.controller;

import com.bean.LoginBean;
import com.dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ContentServlet")
public class ContentServlet extends HttpServlet {

    public String loginUrl = "/Model2Architecture/CookieLoginServlet";

 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        
        Cookie[] cookies = request.getCookies();
        int length = cookies.length;
        
        String userName = null;
        String password = null;

        LoginBean bean = new LoginBean();
        LoginDao dao = new LoginDao();

        for (int i = 0; i < length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("userName")) {
                userName = cookie.getValue();
            } else if (cookie.getName().equals("password")) {
                password = cookie.getValue();
            }
        }
        


   

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Welcome</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("Welcome. " + userName);
        out.println("</BODY>");
        out.println("</HTML>");

        // request.getRequestDispatcher("/JSP/LoginSuccess.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }
}
