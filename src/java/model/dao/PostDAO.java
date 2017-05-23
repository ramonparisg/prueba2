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
import model.dto.Usuario;
import util.Conexion;
/**
 *
 * @author raparisg
 */
public class PostDAO {
    public int insertar(Post p){
        int res=0;
        String q = "Insert into usuario(usuario_id,titulo,cuerpo,post_estado_id,fecha_creacion) values"
                + "("+p.getUsuarioId()+""
                + ",'"+p.getTitulo()+"'"
                + ",'"+p.getCuerpo()+"'"
                + ",'"+p.getPostEstadoId()+"'"
                + ",'"+p.getFechaCreacion()
                + "'); ";
        
        Conexion c = new Conexion();
        res = c.ejecutarSQL(q);
        
        return res;
    }
    
    public int modificar(Post p, int id){
        int res = 0;
        String q = "Update post set"
                + "usuario_id='"+p.getUsuarioId()
                + "',titulo='"+p.getTitulo()
                + "',cuerpo='"+p.getCuerpo()
                + "',post_estado_id='"+p.getPostEstadoId()
                + "',fecha_creacion='"+p.getFechaCreacion()
                + " where id="+id;
        
        Conexion c = new Conexion();
        res = c.ejecutarSQL(q);                       
        return res;
    }
    
    public int borrar(int id){
        int res = 0;
        String q ="delete from post where id="+id;
        Conexion c = new Conexion();
        res=c.ejecutarSQL(q);
        return res;
    }
    
    public void buscar(int id){
        String q = "Select * from post where id="+id;
        Conexion c = new Conexion();
        Post p = new Post();
        ResultSet rs;
        if (c.conecta()){
            rs = c.leerDatos(q);
            try {
                while (rs.next()){
                    p.setId(rs.getInt(0));
                    p.setUsuarioId(rs.getInt(1));
                    p.setTitulo(rs.getString(2));
                    p.setCuerpo(rs.getString(3));
                    p.setPostEstadoId(rs.getInt(4));                    
                    p.setFechaCreacion(rs.getString(5));                                        
                }
                c.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList<Post> listarUsuarios (){
        ArrayList<Post> lista= null;
        String q = "Select * from usuario;";
        
        Conexion c = new Conexion();
        if (c.conecta()){
            ResultSet rs;
            rs=c.leerDatos(q);
            Post p;
            try {
                while (rs.next()){
                    p = new Post();
                    p.setId(rs.getInt(0));
                    p.setUsuarioId(rs.getInt(1));
                    p.setTitulo(rs.getString(2));
                    p.setCuerpo(rs.getString(3));
                    p.setPostEstadoId(rs.getInt(4));                    
                    p.setFechaCreacion(rs.getString(5));
                    
                    lista.add(p);
                }
                c.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return lista;
    }
}
