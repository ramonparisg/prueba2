<%-- 
    Document   : admin
    Created on : 24-05-2017, 15:44:17
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
        <h1>Bienvenido, administrador ${sessionScope.user}</h1>
        
        <a href="Post/ver">Posts</a> <br>
        <a href="Usuario/ver">Usuarios</a> <br>
        <a href="Perfil/ver">Perfil</a> <br>
     
    </body>
</html>
