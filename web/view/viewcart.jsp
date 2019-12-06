<%-- 
    Document   : viewcart
    Created on : Nov 10, 2019, 12:43:01 AM
    Author     : success
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.DB.DBConnection"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css" />
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css" />

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css" />

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css" />

    </head>
    <body>

        

        <div class="row" >

            <div class="col-md-12">
                <div class="order-summary clearfix">
                    <div class="section-title">
                        <h3 class="title">Order Review</h3>
                    </div>
                    <table class="shopping-cart-table table">
                        <thead>
                            <tr>
                                <th>Product</th>
                                <th></th>
                                <th class="text-center">Product</th>
                                <th class="text-center">Quantity</th>
                                <th class="text-center">Total</th>
                                <th class="text-right"></th>
                            </tr>
                        </thead>
                        <tbody>

                     <%
                               
                                Connection con = null;                              
                                Statement stmt = null;
                                ResultSet rs = null;
                                String product = null;
                                Integer price, qty, sum = 0;
                    
                                try {
                                    con = DBConnection.createConnection();
                                    stmt = con.createStatement();
                                    rs = stmt.executeQuery("select product_name, quantity, price from orders where login_id = 1");
                                    while (rs.next()) {

                                        product = rs.getString("product_name");
                                        qty = rs.getInt("quantity");
                                        price = rs.getInt("price");
                                        sum += price;
                                        //out.println(fileName);
%>       
                            <tr>
                                <td class="thumb"></td>
                                <td class="details"></td>
                                
                                <td class="qty text-center"><input class="input" type="text" value="<%=product%>"></td>
                                <td class="qty1 text-center"><input class="input" type="number" readonly="" value="<%=qty%>"></td>
                                <td class="qty2 text-center"><input class="input" type="number" readonly="" value="<%=price%>"></td>

                                <td class="text-right"><button class="main-btn icon-btn"><i class="fa fa-close"></i></button></td>
                            </tr>

                            <%
                            // display the image
                        }
                    } catch (Exception e) {
                        
                    }
                %>

                            
                        </tbody>
                        <tfoot>


                            <!--<tr>
                                    <th class="empty" colspan="3"></th>
                                    <th>SUBTOTAL</th>										
                                    
                                    <th colspan="2" class="sub-total"><br>
                            </tr>
                            <tr>
                                    <th class="empty" colspan="3"></th>
                                    <th>SHIPING</th>
                                    <td colspan="2">Free Shipping</td>
                            </tr>
                            <tr>
                                    <th class="empty" colspan="3"></th>
                                    <th>TOTAL</th>
                                    <th colspan="2" class="total">$97.50</th>
                            </tr>-->
                        </tfoot>
                    </table>



                    <label>Total </label><br>
                    <input type="text" name="" value="<%=sum%>"><br>
                    <form action="userlogin.html">
                        <div class="pull-left">
                            
                            <button class="primary-btn">Place Order</button>
                            
                        </div>
                    </form>
                </div>

            </div>
     
    </div>



</div>

</body>
</html>