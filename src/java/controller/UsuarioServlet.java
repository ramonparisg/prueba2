/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.UsuarioDAO;
import model.dto.Usuario;
import util.Ayudante;

/**
 *
 * @author raparisg
 */
public class UsuarioServlet extends HttpServlet {

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
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        Usuario u;
        switch(accion){
            case "agregar":
                u = new Usuario();
                u.setEmail(request.getParameter("email"));
                
                u.setNombre(request.getParameter("nombre"));
                u.setApellido(request.getParameter("apellido"));

                if (!dao.buscarEmail(u.getEmail()) && dao.insertar(u)>0){
                    response.sendRedirect("../Ingresar.jsp");
                }else{
                    response.sendRedirect("../ErrorLogin.jsp");
                }
                break;
            case "ver":
                 lista = dao.listarUsuarios();
                 request.setAttribute("lista", lista);                
                request.getRequestDispatcher("../UsuarioAdmin.jsp").forward(request, response);
                break;
            case "eliminar":
                int id = Integer.parseInt(request.getParameter("id"));
                if (dao.borrar(id)>0){
                    lista = dao.listarUsuarios();
                    request.setAttribute("lista", lista); 
                    request.getRequestDispatcher("../UsuarioAdmin.jsp").forward(request, response);
                }
                break;
            case "modificar":
                u = new Usuario();
                u.setNombre(request.getParameter("nombre"));
                u.setApellido(request.getParameter("apellido"));
                u.setFechaCreacion(request.getParameter("fecha"));
                u.setPerfilId(Integer.parseInt(request.getParameter("idPerfil")));
                u.setId(Integer.parseInt(request.getParameter("id")));
                if (dao.modificar(u)>0){
                    lista = dao.listarUsuarios();
                    request.setAttribute("lista", lista); 
                    request.getRequestDispatcher("../UsuarioAdmin.jsp").forward(request, response);
                }
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
