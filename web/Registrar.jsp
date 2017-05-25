<%-- 
    Document   : Registrar
    Created on : 24-05-2017, 14:43:45
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
        <h1>Registrarse</h1>
        <form method="post" action="Usuario/agregar">
            E-mail <input type="email" name="email"> <br>
            Nombre <input type="text" name="nombre"> <br>
            Apellido <input type="text" name="apellido"> <br>
            <input type="submit">
        </form>
    </body>
</html>
