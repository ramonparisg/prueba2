<%-- 
    Document   : UsuarioFormato
    Created on : 24-05-2017, 21:25:55
    Author     : raparisg
--%>

<%@page import="model.dto.Auxiliar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.PerfilDAO"%>
<%@page import="model.dao.UsuarioDAO"%>
<%@page import="model.dto.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% 
            PerfilDAO p = new PerfilDAO();
            ArrayList<Auxiliar> lista = p.listar();
            
            Usuario u = new Usuario();                                    
            
            String accion="";
            if (request.getParameter("accion")!=null)
                accion = request.getParameter("accion");
            
            if (request.getParameter("id")!=null){
                UsuarioDAO udao = new UsuarioDAO();
                u = udao.buscarId(Integer.parseInt(request.getParameter("id")));
            
        %>
    </head>
    <body>
        <h1>Usuario</h1>
        <form method="post" action="Usuario/<%=accion %>">
                        
            Nombre <input type="text" name="nombre" value="<%=u.getNombre() %>" required> <br>
            Apellido <input type="text" name="apellido" value="<%=u.getApellido() %>" required> <br>
            Fecha Creacion <input type="date" name="fecha" value="<%=u.getFechaCreacion() %>" required><br>
            Perfil <select name="idPerfil">                        
                        <option value=""> </option>
                        <% for(Auxiliar perfil : lista){ %>
                        <option value="<%=perfil.getId()%>" name="idPerfil" required><%=perfil.getDetalle() %></option>
                        <% } %>
            </select> <br>
            <input type="text" name="id" value="<%=u.getId() %>" hidden >
            <input type="submit">
            
        </form>
            <% } %>
    </body>
</html>
