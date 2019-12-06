package com.first;

import java.sql.*;

public class oracle {
    public static Connection oracle(){

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String reg, url, user, pass;

        reg = "oracle.jdbc.driver.OracleDriver";
        url = "jdbc:oracle:thin:@localhost:1521:orcl";
        user = "SHWAPNO";
        pass = "Oracle_1";

        try
        {
            Class.forName(reg);
            c = DriverManager.getConnection(url, user, pass);
        }

        catch (Exception e)
        {

        }

        return c;

    }
}
