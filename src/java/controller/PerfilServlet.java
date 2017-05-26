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
import model.dao.PerfilDAO;
import model.dto.Auxiliar;
import util.Ayudante;

/**
 *
 * @author raparisg
 */
public class PerfilServlet extends HttpServlet {

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
        PerfilDAO dao = new PerfilDAO();
        Auxiliar p;
        ArrayList<Auxiliar> lista = new ArrayList<Auxiliar>();
        
        switch(accion){
            case "ver":
                lista = dao.listar();
                request.setAttribute("lista", lista);                
                request.getRequestDispatcher("../PerfilAdmin.jsp").forward(request, response);                
                break;
            case "modificar":
                p = new Auxiliar();
                p.setId(Integer.parseInt(request.getParameter("id")));
                p.setDetalle(request.getParameter("detalle"));
                if (dao.modificar(p)>0){
                    lista = dao.listar();
                    request.setAttribute("lista", lista);                
                    request.getRequestDispatcher("../PerfilAdmin.jsp").forward(request, response);
                }
                break;
            case "agregar":
                p = new Auxiliar();
                p.setId(Integer.parseInt(request.getParameter("id")));
                p.setDetalle(request.getParameter("detalle"));
                if (dao.insertar(p)>0){
                    lista = dao.listar();
                    request.setAttribute("lista", lista);                
                    request.getRequestDispatcher("../PerfilAdmin.jsp").forward(request, response);
                } 
                break;
            case "eliminar":
                int id=Integer.parseInt(request.getParameter("id"));
                if (dao.borrar(id)>0){
                    lista = dao.listar();
                    request.setAttribute("lista", lista);                
                    request.getRequestDispatcher("../PerfilAdmin.jsp").forward(request, response);
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
