/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.ComentarioDAO;
import model.dto.Comentario;
import util.Ayudante;

/**
 *
 * @author raparisg
 */
public class ComentarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        
        
        
        
        
        
        switch (accion){
            case "agregar":
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                int idPost = Integer.parseInt(request.getParameter("idPost"));        
                String comentario = request.getParameter("comentario");
                int comentarioEstadoId = Integer.parseInt(request.getParameter("comentarioEstadoId"));
                
                Comentario c = new Comentario(idUsuario,idPost,comentario,comentarioEstadoId);
                comentarioDAO.insertar(c);
                response.sendRedirect(request.getContextPath()+"/Post.jsp?codigo="+idPost+"&idUsuario="+idUsuario);
                break;
            
            case "modificar":
                Comentario update = new Comentario();
                int idComentario=Integer.parseInt(request.getParameter("idComentario"));
                update=comentarioDAO.buscar(idComentario);
                
                update.setComentario(request.getParameter("comentario"));                
                if (comentarioDAO.modificar(update)>0){
                    request.getRequestDispatcher(request.getContextPath()+"/Post.jsp?codigo="+update.getPostId()+"&idUsuario="+update.getUsuarioId()).forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath()+"/ErrorLogin.jsp");
                }
                break;
            case "eliminar":
                int id=Integer.parseInt(request.getParameter("idComentario"));
                Comentario delete = new Comentario();
                delete = comentarioDAO.buscar(id);
                comentarioDAO.borrar(delete.getId());
//                request.getRequestDispatcher("../Post.jsp?codigo="+delete.getPostId()+"&idUsuario="+delete.getUsuarioId()).forward(request, response);
                response.sendRedirect("../Post.jsp?codigo="+delete.getPostId()+"&idUsuario="+delete.getUsuarioId());
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
