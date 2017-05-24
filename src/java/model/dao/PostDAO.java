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
import util.Conexion;
/**
 *
 * @author raparisg
 */
public class PostDAO {
    public int insertar(Post p){
        int res=0;
        String q = "Insert into post(usuario_id,titulo,cuerpo,post_estado_id,fecha_creacion) values"
                + "("+p.getUsuarioId()+""
                + ",'"+p.getTitulo()+"'"
                + ",'"+p.getCuerpo()+"'"
                + ","+p.getPostEstadoId()+""
                + ",'"+p.getFechaCreacion()
                + "'); ";
        
        Conexion c = new Conexion();
        res = c.ejecutarSQL(q);
        
        return res;
    }
    
    public int modificar(Post p, int id){
        int res = 0;
        String q = "Update post set"
                + " usuario_id="+p.getUsuarioId()
                + ",titulo='"+p.getTitulo()
                + "',cuerpo='"+p.getCuerpo()
                + "',post_estado_id="+p.getPostEstadoId()
                + ",fecha_creacion='"+p.getFechaCreacion()
                + "' where id="+id;
        
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
    
    public Post buscar(int id){
        String q = "Select * from post where id="+id;
        Conexion c = new Conexion();
        Post p = new Post();
        ResultSet rs;
        if (c.conecta()){
            rs = c.leerDatos(q);
            try {
                while (rs.next()){
                    p.setId(rs.getInt(1));
                    p.setUsuarioId(rs.getInt(2));
                    p.setTitulo(rs.getString(3));
                    p.setCuerpo(rs.getString(4));
                    p.setPostEstadoId(rs.getInt(5));                    
                    p.setFechaCreacion(rs.getString(6));                                        
                }
                c.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p;
    }
    
    public ArrayList<Post> listar (){
        ArrayList<Post> lista= new ArrayList<Post>();
        String q = "Select * from post";
        
        Conexion c = new Conexion();
        if (c.conecta()){
            ResultSet rs;
            rs=c.leerDatos(q);
            
            try {
                while (rs.next()){
                    Post p = new Post();                    
                    p.setId(rs.getInt(1));
                    p.setUsuarioId(rs.getInt(2));
                    p.setTitulo(rs.getString(3));
                    p.setCuerpo(rs.getString(4));
                    p.setPostEstadoId(rs.getInt(5));                    
                    p.setFechaCreacion(rs.getString(6));   
                    lista.add(p);
                }
                c.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return lista;
    }
    
    public String buscarNombreUsuario(int id){
        String res="";
        String q = "select u.nombre, u.apellido from usuario u join post p on u.id ="+id;
        Conexion c = new Conexion();
        Post p = new Post();
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
}
