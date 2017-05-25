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
import model.dto.Usuario;
import util.Conexion;

/**
 *
 * @author raparisg
 */
public class UsuarioDAO {
    
    public int insertar(Usuario u){
        int res=0;
        String q = "Insert into usuario(perfil_id,nombre,apellido,email,fecha_creacion) values"
                + "(2"
                + ",'"+u.getNombre()+"'"
                + ",'"+u.getApellido()+"'"
                + ",'"+u.getEmail()+"'"
                + ",now())";
                
        
        Conexion c = new Conexion();
        res = c.ejecutarSQL(q);
        
        return res;
    }
    
    public int modificar(Usuario u){
        int res = 0;
        String q = "Update usuario set"
                + " perfil_id="+u.getPerfilId()
                + ",nombre='"+u.getNombre()
                + "',apellido='"+u.getApellido()
                + "',fecha_creacion='"+u.getFechaCreacion()
                + "' where id="+u.getId();
        
        Conexion c = new Conexion();
        res = c.ejecutarSQL(q);                       
        return res;
    }
    
    public int borrar(int id){
        int res = 0;
        String q ="delete from usuario where id="+id;
        Conexion c = new Conexion();
        res=c.ejecutarSQL(q);
        return res;
    }
    
    public Usuario buscar(String email){
        String q = "Select * from usuario where email='"+email+"';";
        Conexion c = new Conexion();
        Usuario u = new Usuario();
        ResultSet rs;
        if (c.conecta()){
            rs = c.leerDatos(q);
            try {
                while (rs.next()){
                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setApellido(rs.getString("apellido"));
                    u.setEmail(rs.getString("email"));
                    u.setFechaCreacion(rs.getString("fecha_creacion"));
                    u.setPerfilId(rs.getInt("perfil_id"));
                    
                }
                c.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return u;
    }
    
    public Usuario buscarId(int id){
        String q = "Select * from usuario where id='"+id+"';";
        Conexion c = new Conexion();
        Usuario u = new Usuario();
        ResultSet rs;
        if (c.conecta()){
            rs = c.leerDatos(q);
            try {
                while (rs.next()){
                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setApellido(rs.getString("apellido"));
                    u.setEmail(rs.getString("email"));
                    u.setFechaCreacion(rs.getString("fecha_creacion"));
                    u.setPerfilId(rs.getInt("perfil_id"));
                    
                }
                c.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return u;
    }
    
    public ArrayList<Usuario> listarUsuarios (){
        ArrayList<Usuario> lista= new ArrayList<Usuario>();
        String q = "Select * from usuario;";
        
        Conexion c = new Conexion();
        if (c.conecta()){
            ResultSet rs;
            rs=c.leerDatos(q);
            Usuario u;
            try {
                while (rs.next()){
                    u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setApellido(rs.getString("apellido"));
                    u.setEmail(rs.getString("email"));
                    u.setFechaCreacion(rs.getString("fecha_creacion"));
                    u.setPerfilId(rs.getInt("perfil_id"));
                    
                    lista.add(u);
                }
                c.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return lista;
    }
    
    public boolean buscarEmail (String email){
        boolean res=false;
        String q = "Select * from usuario where email='"+email+"';";
        Conexion c = new Conexion();
        Usuario u = new Usuario();
        ResultSet rs;
        if (c.conecta()){
            rs = c.leerDatos(q);
            try {
                while (rs.next()){
                    c.desconecta();
                    return true;
                    
                }
                c.desconecta();                
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }
    
    public String buscarNombreEmail (String email){
        String res="";
        String q = "Select nombre from usuario where email='"+email+"';";
        Conexion c = new Conexion();
        Usuario u = new Usuario();
        ResultSet rs;
        if (c.conecta()){
            rs = c.leerDatos(q);
            try {
                while (rs.next()){
                    res=rs.getString("nombre");
                }
                c.desconecta();                
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }
}
