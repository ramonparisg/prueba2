<%-- 
    Document   : PerfilAdmin
    Created on : 26-05-2017, 0:53:19
    Author     : raparisg
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Auxiliar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <% 
            if (request.getAttribute("lista")!=null){
            ArrayList<Auxiliar> lista = new ArrayList<Auxiliar>();
            lista = (ArrayList<Auxiliar>) request.getAttribute("lista");
            
        %>
    </head>
    <body>
        <div class="container ">
        <h1 class="text-center">Lista de Perfiles</h1>
        <p><a class="btn btn-success" href="<%=request.getContextPath() %>/PerfilFormato.jsp?accion=agregar"  ><spam class="glyphicon glyphicon-plus"></spam></a></p>
        <table class="table table-hover">
            <thead>
                <th>ID</th>
                <th>Nombre</th>                
                <th>Acción</th>
            </thead>
            <% for(Auxiliar perfil : lista){ %>
                <tbody>
                    <td><%=perfil.getId() %></td>                 
                    <td><%=perfil.getDetalle() %></td>                    
                    <td><a class="btn btn-warning" href="<%=request.getContextPath() %>/PerfilFormato.jsp?id=<%=perfil.getId() %>&accion=modificar"> <spam class="glyphicon glyphicon-pencil"></spam></a>
                        <a class="btn btn-danger" href="<%=request.getContextPath()%>/Perfil/eliminar?id=<%=perfil.getId() %>" > <spam class="glyphicon glyphicon-remove"></spam></a> </td> 
                 </tbody>
            <% }}else{ %>
                <h1>No hay datos :(</h1>
                <% } %>
        </table>
        </div>
    </body>
</html>