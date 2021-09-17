<%-- 
    Document   : cart
    Created on : Jun 6, 2020, 8:42:53 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- FONT AWESOME -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <title>Cart Page</title>
    </head>
    <body>
        <div class="row d-flex justify-content-between p-4 mb-4" style="background: lightgray">
            <div class="p-4" style="margin-left: 80px">
                <h1>Cart</h1>
                <h4>All the select products in your cart</h4>
            </div>
        </div>
        <div style="margin-left: 130px">
            <form action="MainController" method="POST" class="form-group">
                <button type="submit" name="btnAction" value="Clear Cart" class="btn btn-danger" style="margin-right: 5px">
                    <i class="fa fa-times-circle"></i>
                    Clear Cart
                </button>
                <a href="#" class="btn btn-success" style="margin-left: 890px"><i class="fa fa-shopping-cart" style="color: white;"></i>Check Out</a>
            </form>
        </div>
        <div class="container" style="">
            <table class="table">
                <thead>
                    <tr>
                        <th width="40%">Product</th>
                        <th>Quantity</th>
                        <th>Unit price</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="total" value="${0}"/>
                    <c:forEach var="list" varStatus="counter" items="${sessionScope.CART.cart.values()}">  
                        <c:set var="total" value="${total + (list.quantity * list.price)}"/>
                        <tr align="left">
                            <td>${list.productName}</td>
                            <td>${list.quantity}</td>
                            <td>${list.price}</td>
                            <td>
                                ${list.quantity * list.price}
                            </td>
                            <td>
                                <form action="MainController" method="POST" class="form-group">
                                    <input type="hidden" name="txtProductID" value="${list.productID}"/>
                                    <button type="submit" name="btnAction" value="Remove" class="btn btn-danger btn-sm" style="margin-right: 5px">
                                        <i class="fa fa-times"></i>
                                        Remove
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="margin-left: 870px">
            <h4><b>Grand Total : ${total}</b></h4>
        </div>
        <form action="MainController" method="POST" class="form-group">
            <button type="submit" name="btnAction" value="Continue Shopping" class="btn btn-success" style="margin-left: 130px">
                <i class="fa fa-arrow-alt-circle-left" style="margin-right: 5px"></i>
                Continue Shopping
            </button>
        </form>
        <!-- Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    </body>
</html>
