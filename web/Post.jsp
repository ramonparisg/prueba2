<%-- 
    Document   : Post
    Created on : 24-05-2017, 3:07:05
    Author     : raparisg
--%>

<%@page import="model.dao.ComentarioDAO"%>
<%@page import="model.dto.Comentario"%>
<%@page import="model.dto.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.PostDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        
        
        <%             
            int codigo=Integer.parseInt(request.getParameter("codigo"));
            
            PostDAO postDAO = new PostDAO();
            Post post;
            post = postDAO.buscar(codigo);
            
            
            ComentarioDAO comDAO = new ComentarioDAO();
            ArrayList<Comentario> lista = comDAO.listarPostComentario(codigo);
            
            
            
        %>
    </head>
    <body class="container">                                
        
        <h2><%=post.getTitulo() %> </h2>
         <p><%=post.getFechaCreacion() %> - <%=postDAO.buscarNombreUsuario(post.getUsuarioId()) %></p>
         <hr>
         <p class="text-justify"><%=post.getCuerpo() %></p>
         <br>
         <h1>Comentarios:</h1>
         
        <% 
                String idUsuario =request.getParameter("idUsuario");
            
            
            for(Comentario com : lista){ %>
        <div style="border:1px solid black; padding: 10px; margin:10px; border-radius: 10px;">
        
            <% if (idUsuario!=null && Integer.parseInt(idUsuario)==com.getUsuarioId()){%>
            <p class="text-right"><a class="glyphicon glyphicon-pencil btn-warning btn" href="Comentario.jsp?idComentario=<%=com.getId() %>&idUsuario=<%=idUsuario %>&idPost=<%=post.getId() %>"></a>
            <a class="glyphicon glyphicon-remove btn btn-danger" href="Comentario/eliminar?idComentario=<%=com.getId() %>"></a></h4>  
            </p>
            <% } %>
            <h4><%=comDAO.buscarUsuarioComentario(com.getUsuarioId()) %>
            <p><%=com.getFechaCreacion() %></p>
            <hr style="border-color: black;">
            <div >
            <p><%=com.getComentario() %></p>
            </div>
            <br>
        </div>
        <% }  %>
        
        <% if(request.getParameter("idUsuario")!=null){ %>
            <h4>Inserta un comentario</h4>
            <form method="post" action="Comentario/agregar">
                <input type="text" value="<%=idUsuario %>" hidden name="idUsuario">
                <input type="text" value="<%=post.getId() %>" hidden name="idPost">                
                <textarea name="comentario" rows="4" cols="100"></textarea> <br>
                <input type="text" value="1" hidden name="comentarioEstadoId">
                <input type="submit">
            </form>
         <% }else { %>
         <h4><a href="Registro.jsp">Registrate</a> o <a href="Ingresar.jsp">Ingresa</a> para hacer comentarios!!</h4>
         <% } %> 
    </body>
</html>
