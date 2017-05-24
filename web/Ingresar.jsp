<%-- 
    Document   : Ingresar
    Created on : 24-05-2017, 2:19:02
    Author     : raparisg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="post" action="LoginSession">
            Email <input type="text" name="email"> <br>
            Contraseña <input type="password" name="pass"> <br>
            <input type="submit">
        </form>
    </body>
</html>
