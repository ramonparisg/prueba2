<%-- 
    Document   : PerfilFormato
    Created on : 26-05-2017, 1:02:30
    Author     : raparisg
--%>

<%@page import="model.dao.PerfilDAO"%>
<%@page import="model.dto.Auxiliar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            PerfilDAO dao = new PerfilDAO();            
            Auxiliar p = new Auxiliar();
            
            String accion="";
            if (request.getParameter("accion")!=null)
                accion = request.getParameter("accion");
                        
            
            if (request.getParameter("id")!=null){                
                p = dao.buscar(Integer.parseInt(request.getParameter("id")));
            }
        %>
        <h1>Perfil</h1>
        <form method="post" action="Perfil/<%=accion %>">
            Detalle <input type="text" value="<%=p.getDetalle() %>" required name="detalle"/>
            <input type="text" value="<%=p.getId() %>" required name="id" hidden/> <br>
            <input type="submit">        
        </form>
        
    </body>
</html>
