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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
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
    <body class="container">
        <h1 class="text-center">Post</h1>
        <form method="post" action="Post/<%=accion %>">
            <div class="form-group border" border="1">
                <label>Titulo</label> <input class="form-control" type="text" name="titulo" value="<%=p.getTitulo() %>" required> <br>
                <label>Cuerpo</label> <textarea row="5" class="form-control" name="cuerpo" required ><%=p.getCuerpo() %></textarea> <br>
                
            </div>
                
            
            
            <input type="text" name="id" value="<%=p.getId() %>" hidden >
            <div class="row"> 
            <div class="col-md-4 form-group">
                <label>Fecha de creación</label> <input class="form-control" type="date" name="fecha" value="<%=p.getFechaCreacion() %>" required><br>
                <label>Usuario</label> <select name="idUsuario" class="form-control">                        
                        <option value=""> </option>
                        <% for(Usuario u : lista){ %>
                        <option value="<%=u.getId()%>" name="idUsuario" required><%=u.getNombre() %></option>
                        <% } %>
                    </select>
            </div>
                    </div>
                    <input type="submit" class="form-control btn btn-success">
            
        </form>
    </body>
</html>
