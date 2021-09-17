<%-- 
    Document   : admin
    Created on : May 31, 2020, 5:36:52 PM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"> 
        <title>Admin Page</title>
    </head>
    <body>
        <div class="row d-flex justify-content-between p-4 mb-4" style="background: lightgray">
            <div style="margin-left: 90px">
                <h1>Product</h1>
                <h4>Add products</h4>
            </div>
            <div class="p-4">
                <form action="MainController" method="GET" class="form-group">
                    <h4><%= session.getAttribute("USER")%></h4>
                    <input type="submit" name="btnAction" value="LogOut" class="btn btn-danger"/>
                </form>
            </div>
        </div>
        <div class="p-4 mb-4">
            <div style="width: 90%; height: 90%; margin-left: 80px" >
                <h5>Add new product</h5>
                <hr>
                <form action="MainController" method="GET" class="form-group" style="width: 70%; height: 40%; margin-left: 55px">
                    <h1 style="color: red; text-align: center">${requestScope.RESULT}</h1>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Product Name</label>
                        <div class="col-sm-10">
                            <input type="text" name="txtProductName" required="" class="form-control" minlength="1" maxlength="100"/><br/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Unit Price</label>
                        <div class="col-sm-10">
                            <input type="number" name="txtUnitPrice" required="" class="form-control" min="1"/><br/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Units In Stock</label>
                        <div class="col-sm-10">
                            <input type="number" name="txtUnitsInStock" required="" value="0" class="form-control" min="1"/><br/>
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Description</label>
                        <div class="col-sm-10">
                            <textarea cols="20" rows="2" name="txtDescription" class="form-control"></textarea><br/>
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Manufacturer</label>
                        <div class="col-sm-10">
                            <input type="text" name="txtManufacturer" required="" class="form-control" minlength="1" maxlength="30"/><br/>
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Category</label>
                        <div class="col-sm-10">
                            <input type="text" name="txtCategory" required="" class="form-control" minlength="1" maxlength="50"/><br/>
                        </div>
                    </div>  
                    Condition 
                    <input type="radio" name="txtCondition" style="margin-left:70px; margin-bottom: 40px" value="New" required=""/>
                    New
                    <input type="radio" name="txtCondition" value="Old"/> 
                    Old
                    <input type="radio" name="txtCondition" value="Refurbished"/>
                    Refurbished
                    <br/>
                    Product Image File <input type="file" name="txtImage" size="60" style="margin-left:10px; margin-bottom: 40px" required=""/><br/>
                    <input type="submit" value="Add Product" name="btnAction" class="btn btn-primary pt-1 pl-3" style="margin-left: 145px" />
                    
                </form>
            </div>
        </div>
        <!-- Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    </body>
</html>
