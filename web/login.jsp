<%-- 
    Document   : index
    Created on : May 31, 2020, 3:07:48 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"> 
        <title>Login Page</title>
    </head>
    <body>
        <h1 class="p-4 mb-4" style="background: lightgray">Mobile Store</h1>
        <div class="container-fluid d-flex justify-content-center">
            <div class="col-md-4 col-sm-4 col-xs-12">
                <div class="card">
                    <h4 class="card-header bg-light">Please sign in</h4>
                    <form action="MainController" method="POST" class="card-body form-group" >
                        <input type="text" name="txtUsername" class="form-control" required="" placeholder="User Name" minlength="1" maxlength="11"/>
                        <br/>
                        <input type="password" name="txtPassword" class="form-control" required="" placeholder="Password" minlength="1" maxlength="21"/>
                        <br/>
                        <input type="submit" value="Login" name="btnAction" class="btn btn-success btn-block p-2"/>
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
