<%-- 
    Document   : Tabla
    Created on : 24-05-2017, 15:58:52
    Author     : raparisg
--%>

<%@page import="model.dto.Post"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <% 
            if (request.getAttribute("lista")!=null){
            ArrayList<Post> lista = new ArrayList<Post>();
            lista = (ArrayList<Post>) request.getAttribute("lista");
            
        %>
    </head>
    <body>
        <div class="container">
        <h1>Lista de Post</h1>
        <p><a href="<%=request.getContextPath() %>/PostFormato.jsp?accion=agregar" class="glyphicon glyphicon-plus" >Add</a></p>
        <table border="1">
            <thead>
                <th>ID</th>
                <th>Usuario ID</th>
                <th>Titulo</th>
                <th>Cuerpo</th>
                <th>Post Estado</th>
                <th>Fecha </th>
                <th>Acción</th>
            </thead>
            <% for(Post p : lista){ %>
                <tbody>
                    <td><%=p.getId() %></td>                 
                    <td><%=p.getUsuarioId() %></td>
                    <td><%=p.getTitulo() %></td>
                    <td><%=p.getCuerpo() %></td>                    
                    <td><%=p.getPostEstadoId() %></td>
                    <td><%=p.getFechaCreacion() %></td>
                    <td><a href="<%=request.getContextPath() %>/PostFormato.jsp?id=<%=p.getId() %>&accion=modificar" class="glyphicon glyphicon-pencil"> Modificar</a> <br/> 
                        <a href="<%=request.getContextPath()%>/Post/eliminar?id=<%=p.getId() %>" class="glyphicon glyphicon-remove"> Eliminar</a> </td> 
                 </tbody>
            <% }}else{ %>
                <h1>No hay datos :(</h1>
                <% } %>
        </table>
        </div>
    </body>
    
</html>
