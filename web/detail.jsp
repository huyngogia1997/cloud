<%-- 
    Document   : detail
    Created on : Jun 6, 2020, 10:51:49 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- FONT AWESOME -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <title>Detail Page</title>
    </head>
    <body>
        <div class="row d-flex justify-content-between p-4 mb-4" style="background: lightgray">
            <div class="p-4" style="margin-left: 150px">
                <h1>Products</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-5">
                <img class="img-fluid" src="product/${requestScope.DETAIL.image}" alt="sp1" />
            </div>

            <div class="col-sm-7">
                <h5>${requestScope.DETAIL.productName}</h5>
                <p>${requestScope.DETAIL.description}</p>
                <h8><b>Item Code : </b></h8><p>${requestScope.DETAIL.productID}</p>
                <h8><b>Manufacturer : </b></h8><p>${requestScope.DETAIL.manufacturer}</p>
                <h8><b>Category : </b></h8><p>${requestScope.DETAIL.category}</p>
                <h8><b>Available units in stock : </b></h8><p>${requestScope.DETAIL.quantity}</p>
                <h8><b>Price : </b></h8><p>${requestScope.DETAIL.price} USD</p>
                <div class="row">
                    <form action="MainController" method="POST" class="form-group">
                        <input type="hidden" name="txtProductID" value="${requestScope.DETAIL.productID}"/>
                        <button type="submit" name="btnAction" value="Back" class="btn btn-info" style="color: white">
                            <i class="fa fa-arrow-alt-circle-left"></i>
                            Back
                        </button>
                        <button type="submit" name="btnAction" value="Order Now" class="btn btn-warning" style="color: white">
                            <i class="fa fa-shopping-cart"></i>
                            Order Now
                        </button>
                    </form>
                </div>   
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    </body>
</html>
