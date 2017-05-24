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
import model.dto.Post;
import model.dto.Comentario;
import util.Conexion;

/**
 *
 * @author raparisg
 */
public class ComentarioDAO {
    public int insertar(Comentario c){
        int res=0;
        String q = "Insert into comentario(usuario_id,post_id,comentario_estado_id,comentario,fecha_creacion) values"
                + "("+c.getUsuarioId()+""
                + ","+c.getPostId()+""
                + ","+c.getComentarioEstadoId()+""
                + ",'"+c.getComentario()+"'"
                + ",now());";
                
        
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
    
    public Comentario buscar(int id){
        String q = "Select * from comentario where id="+id;
        Conexion con = new Conexion();
        Post p = new Post();
        Comentario c = new Comentario();
        ResultSet rs;
        if (con.conecta()){
            rs = con.leerDatos(q);
            try {
                while (rs.next()){
                    c.setId(rs.getInt(1));
                    c.setUsuarioId(rs.getInt(2));
                    c.setPostId(rs.getInt(3));
                    c.setComentarioEstadoId(rs.getInt(4));
                    c.setComentario(rs.getString(5));                    
                    c.setFechaCreacion(rs.getString(6));                                        
                }
                con.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return c;
    }
    
    public ArrayList<Comentario> listar (){
        ArrayList<Comentario> lista= new ArrayList<Comentario>();
        String q = "Select * from comentario;";
        
        Conexion con = new Conexion();
        if (con.conecta()){
            ResultSet rs;
            rs=con.leerDatos(q);
            Comentario c;
            try {
                while (rs.next()){
                    c = new Comentario();
                    c.setId(rs.getInt(1));
                    c.setUsuarioId(rs.getInt(2));
                    c.setPostId(rs.getInt(3));
                    c.setComentarioEstadoId(rs.getInt(4));
                    c.setComentario(rs.getString(5));                    
                    c.setFechaCreacion(rs.getString(6));
                    
                    lista.add(c);
                }
                con.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return lista;
    }
    
    public String buscarUsuarioComentario(int id){
        String res="";
        String q = "select u.nombre, u.apellido from usuario u join comentario c on u.id ="+id;
        Conexion c = new Conexion();
        
        ResultSet rs;
        if (c.conecta()){
            rs = c.leerDatos(q);
            try {
                while (rs.next()){
                    return rs.getString(1) + " " + rs.getString(2);
                }
                c.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return res;
    }
    
    public ArrayList<Comentario> listarPostComentario(int id){
        ArrayList<Comentario> lista= new ArrayList<Comentario>();
        String q = "Select * from comentario where post_id="+id;
        
        Conexion con = new Conexion();
        if (con.conecta()){
            ResultSet rs;
            rs=con.leerDatos(q);
            Comentario c;
            try {
                while (rs.next()){
                    c = new Comentario();
                    c.setId(rs.getInt(1));
                    c.setUsuarioId(rs.getInt(2));
                    c.setPostId(rs.getInt(3));
                    c.setComentarioEstadoId(rs.getInt(4));
                    c.setComentario(rs.getString(5));                    
                    c.setFechaCreacion(rs.getString(6));
                    
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
