<%-- 
    Document   : PostFormato
    Created on : 24-05-2017, 19:07:14
    Author     : raparisg
--%>

<%@page import="model.dao.PostDAO"%>
<%@page import="model.dto.Post"%>
<%@page import="model.dto.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% 
            UsuarioDAO udao = new UsuarioDAO();
            ArrayList<Usuario> lista = udao.listarUsuarios();
            Post p = new Post();
            String accion="";
            if (request.getParameter("accion")!=null)
                accion = request.getParameter("accion");
                        
            
            if (request.getParameter("id")!=null){
                PostDAO daoPost = new PostDAO();
                p = daoPost.buscar(Integer.parseInt(request.getParameter("id")));
            }
        %>
    </head>
    <body>
        <h1>Post</h1>
        <form method="post" action="Post/<%=accion %>">
            Usuario <select name="idUsuario">                        
                        <option value=""> </option>
                        <% for(Usuario u : lista){ %>
                        <option value="<%=u.getId()%>" name="idUsuario" required><%=u.getNombre() %></option>
                        <% } %>
            </select> <br>
            Titulo <input type="text" name="titulo" value="<%=p.getTitulo() %>" required> <br>
            Cuerpo <input type="text" name="cuerpo" value="<%=p.getCuerpo() %>" required> <br>
            Fecha Creacion <input type="date" name="fecha" value="<%=p.getFechaCreacion() %>" required> <br>
            Estado del Post <input type="text" name="postEstado" value="<%=p.getPostEstadoId() %>"required><br>
            <input type="text" name="id" value="<%=p.getId() %>" hidden >
            <input type="submit">
            
        </form>
    </body>
</html>
