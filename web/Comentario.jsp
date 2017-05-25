<%-- 
    Document   : Comentario
    Created on : 24-05-2017, 11:19:08
    Author     : raparisg
--%>

<%@page import="model.dto.Comentario"%>
<%@page import="model.dao.ComentarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            int id = Integer.parseInt(request.getParameter("idComentario"));
            ComentarioDAO comentarioDAO = new ComentarioDAO();
            Comentario c = comentarioDAO.buscar(id);            
        %>
    </head>
    <body>
        <h1>Modificar Comentario:</h1>
        
        <form method="post" action="Comentario/modificar">
                <input type="text" value="<%=c.getId()%>" hidden name="idComentario">                
                <textarea name="comentario" rows="4" cols="100"><%=c.getComentario() %></textarea> <br>                
                <input type="submit">
            </form>
    </body>
</html>
