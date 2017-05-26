<%-- 
    Document   : Tabla
    Created on : 24-05-2017, 15:58:52
    Author     : raparisg
--%>

<%@page import="model.dto.Post"%>
<%@page import="java.util.ArrayList"%>
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
        <style>
       .table {
          table-layout:fixed;
        }

        .table td {
          white-space: nowrap;
          overflow: hidden;
          text-overflow: ellipsis;
        }
        </style>
    </head>
    <body>
        <div class="container-fluid">
        <h1 class="text-center">Lista de Posts</h1>
        <p><a href="<%=request.getContextPath() %>/PostFormato.jsp?accion=agregar" class="glyphicon glyphicon-plus btn btn-success" ></a></p>
        <table class="table table-hover">
            <thead class="text-center">
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
                    <td><a href="<%=request.getContextPath() %>/PostFormato.jsp?id=<%=p.getId() %>&accion=modificar" class="btn btn-warning"><spam class="glyphicon glyphicon-pencil"></spam></a>
                        <a href="<%=request.getContextPath()%>/Post/eliminar?id=<%=p.getId() %>" class="btn btn-danger"><spam class="glyphicon glyphicon-remove"></spam></a> </td> 
                 </tbody>
            <% }}else{ %>
                <h1>No hay datos :(</h1>
                <% } %>
        </table>
        </div>
    </body>
    
</html>
