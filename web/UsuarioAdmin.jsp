<%-- 
    Document   : UsuarioAdmin
    Created on : 24-05-2017, 15:53:14
    Author     : raparisg
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <% 
            if (request.getAttribute("lista")!=null){
            ArrayList<Usuario> lista = new ArrayList<Usuario>();
            lista = (ArrayList<Usuario>) request.getAttribute("lista");
            
        %>
    </head>
    <body>
        <div class="container">
        <h1>Lista de Post</h1>
        <p><a href="<%=request.getContextPath() %>/Registrar.jsp" class="glyphicon glyphicon-plus" >Add</a></p>
        <table border="1">
            <thead>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Fecha creación</th>
                <th>Perfil ID</th>
                <th>Acción</th>
            </thead>
            <% for(Usuario u : lista){ %>
                <tbody>
                    <td><%=u.getId() %></td>                 
                    <td><%=u.getNombre() %></td>
                    <td><%=u.getApellido() %></td>
                    <td><%=u.getEmail() %></td>                    
                    <td><%=u.getFechaCreacion() %></td>
                    <td><%=u.getPerfilId() %></td>
                    <td><a href="<%=request.getContextPath() %>/UsuarioFormato.jsp?id=<%=u.getId() %>&accion=modificar" class="glyphicon glyphicon-pencil"> Modificar</a> <br/> 
                        <a href="<%=request.getContextPath()%>/Usuario/eliminar?id=<%=u.getId() %>" class="glyphicon glyphicon-remove"> Eliminar</a> </td> 
                 </tbody>
            <% }}else{ %>
                <h1>No hay datos :(</h1>
                <% } %>
        </table>
        </div>
    </body>
</html>
