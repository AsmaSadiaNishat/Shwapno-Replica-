/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.first;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author success
 */
public class DBTest {
    public static void main (String args[]){
        
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        boolean status = false;

        c = oracle.oracle();
        
      String userName, password;
      Scanner in = new Scanner(System.in);
      userName = in.next();
      password = in.next();
        
        try {

            sql = "SELECT * FROM login WHERE username = ? and password = ?";
            ps = c.prepareStatement(sql);

            ps.setString(1, userName);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if (rs.next()) {
              //  if (userName.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
  System.out.println("Login Successful");
  //System.out.println("Login Successful");
                    
                } else  {
                    
                   System.out.println("Login Failed");
                }
            }
            
          

         catch (Exception e) {
            e.printStackTrace();
        }
    }
}
