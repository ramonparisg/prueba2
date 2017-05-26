<%-- 
    Document   : index
    Created on : 24-05-2017, 2:49:00
    Author     : raparisg
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.PostDAO"%>
<%@page import="model.dto.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        
        
        <% 
            PostDAO p = new PostDAO();
            ArrayList<Post> lista = p.listar();
        %>
    </head>
    <body class="container">                        
        <h1>Bienvenido, ${sessionScope.user}</h1>
        <% 
            for(Post post : lista){                
         %>
         <a href="Post.jsp?codigo=<%=post.getId() %>&idUsuario=${sessionScope.id}"> <h2><%=post.getTitulo()%></h2></a>                  
         <p class="text-right"><%=post.getFechaCreacion()%> - <%=p.buscarNombreUsuario(post.getUsuarioId())%></p>
         <hr>
         <p class="text-justify"><%=post.getCuerpo() %></p>
         <br>
        <%        
        }
        %>
        
    </body>
</html>
