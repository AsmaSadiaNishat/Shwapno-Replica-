
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

@WebServlet(urlPatterns = "/CookieLoginServlet")
public class CookieLoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doPost(request, response);
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String name;
        LoginBean bean = new LoginBean();
        LoginDao dao = new LoginDao();
        
        bean.setUserName(userName);
        bean.setPassword(password);
        
        if(dao.validateLogin(bean)){
            Cookie cookie1 = new Cookie("name", userName);
            Cookie cookie2 = new Cookie("password", password);
            
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            
            //name = userName;
            response.sendRedirect("/view/success1.html");
        }
        else{
            request.setAttribute("errMessage", "Invalid User or Password");
            response.sendRedirect("/view/userlogin.html");
            //request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
