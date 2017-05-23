/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.Comentario;
import model.dto.Post;
import util.Conexion;

/**
 *
 * @author raparisg
 */
public class PerfilDAO {
    public int insertar(Comentario c){
        int res=0;
        String q = "Insert into comentario(usuario_id,post_id,comentario_estado_id,comentario,fecha_creacion) values"
                + "("+c.getUsuarioId()+""
                + ","+c.getPostId()+""
                + ","+c.getComentarioEstadoId()+""
                + ",'"+c.getComentario()+"'"
                + ",'"+c.getFechaCreacion()
                + "'); ";
        
        Conexion con = new Conexion();
        res = con.ejecutarSQL(q);
        
        return res;
    }
    
    public int modificar(Comentario c, int id){
        int res = 0;
        String q = "Update comentario set"
                + "usuario_id="+c.getUsuarioId()
                + ",post_id="+c.getPostId()
                + ",comentario_estado_id="+c.getComentarioEstadoId()
                + ",comentario='"+c.getComentario()
                + "',fecha_creacion='"+c.getFechaCreacion()
                + "' where id="+id;
        
        Conexion con = new Conexion();
        res = con.ejecutarSQL(q);                       
        return res;
    }
    
    public int borrar(int id){
        int res = 0;
        String q ="delete from comentario where id="+id;
        Conexion c = new Conexion();
        res=c.ejecutarSQL(q);
        return res;
    }
    
    public void buscar(int id){
        String q = "Select * from comentario where id="+id;
        Conexion con = new Conexion();
        Post p = new Post();
        Comentario c = new Comentario();
        ResultSet rs;
        if (con.conecta()){
            rs = con.leerDatos(q);
            try {
                while (rs.next()){
                    c.setId(rs.getInt(0));
                    c.setUsuarioId(rs.getInt(1));
                    c.setPostId(rs.getInt(2));
                    c.setComentarioEstadoId(rs.getInt(3));
                    c.setComentario(rs.getString(4));                    
                    c.setFechaCreacion(rs.getString(5));                                        
                }
                con.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList<Comentario> listar (){
        ArrayList<Comentario> lista= null;
        String q = "Select * from comentario;";
        
        Conexion con = new Conexion();
        if (con.conecta()){
            ResultSet rs;
            rs=con.leerDatos(q);
            Comentario c;
            try {
                while (rs.next()){
                    c = new Comentario();
                    c.setId(rs.getInt(0));
                    c.setUsuarioId(rs.getInt(1));
                    c.setPostId(rs.getInt(2));
                    c.setComentarioEstadoId(rs.getInt(3));
                    c.setComentario(rs.getString(4));                    
                    c.setFechaCreacion(rs.getString(5));
                    
                    lista.add(c);
                }
                con.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return lista;
    }
}
