<%-- 
    Document   : error
    Created on : Jun 4, 2020, 8:37:50 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>ERROR !!!</h1>
        <h2>
            <font color="red">
            Message : ${requestScope.ERROR}
            </font>
        </h2>
        <a href="login.jsp">Back to Login Page</a>
    </body>
</html>
