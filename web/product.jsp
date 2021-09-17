<%-- 
    Document   : product
    Created on : May 31, 2020, 5:38:49 PM
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
        <title>Product Page</title>
    </head>
    <body>
        <div class="row d-flex justify-content-between p-4 mb-4" style="background: lightgray">
            <div class="p-4">
                <h1>Products</h1>
                <h4>All the available products in our store</h4>
            </div>
            <div class="p-4">
                <form action="MainController" method="POST" class="form-group">
                    <div>
                        <button type="submit" name="btnAction" value="View Cart" class="btn btn-light" >
                            <i class="fa fa-shopping-cart"></i>
                            View Cart
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <div class="container" style="margin-bottom: 100px">
            <div class="card-group">
                <c:if test="${requestScope.LISTPRODUCT != null}">
                    <c:if test="${not empty requestScope.LISTPRODUCT}">
                        <c:forEach var="list" varStatus="counter" items="${requestScope.LISTPRODUCT}">  
                            <div class="col-md-3 mb-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h3 class="card-title">${list.productName}</h3>
                                        <img class="card-img-top" src="product/${list.image}" />
                                        <p class="card-text">${list.description}</p>
                                        <p class="card-text">${list.price} USD</p>
                                        <p class="card-text">${list.quantity} units in stock</p>
                                        <div class="row">
                                            <form action="MainController" method="POST" class="form-group">
                                                <input type="hidden" name="txtProductID" value="${list.productID}"/>
                                                <button type="submit" name="btnAction" value="Details" class="btn btn-info" >
                                                    <i class="fas fa-info-circle"></i>
                                                    Details
                                                </button>
                                                <button type="submit" name="btnAction" value="Order Now" class="btn btn-warning" style="color: white">
                                                    <i class="fa fa-shopping-cart "></i>
                                                    Order Now
                                                </button>
                                            </form>
                                        </div>                           
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </c:if>
            </div>
        </div> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    </body>
</html>
