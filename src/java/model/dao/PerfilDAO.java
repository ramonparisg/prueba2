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
import model.dto.Auxiliar;
import util.Conexion;

/**
 *
 * @author raparisg
 */
public class PerfilDAO {
    public int insertar(Auxiliar perfil){
        int res=0;
        String q = "Insert into perfil(id,detalle) values"
                + "("+perfil.getId()+""
                + ",'"+perfil.getDetalle()+"'"
                + "); ";
        
        Conexion con = new Conexion();
        res = con.ejecutarSQL(q);
        
        return res;
    }
    
    public int modificar(Auxiliar perfil){
        int res = 0;
        String q = "Update perfil set"
                + "id="+perfil.getId()
                + ",detalle='"+perfil.getDetalle()               
                + "' where id="+perfil.getId();        
        Conexion con = new Conexion();
        res = con.ejecutarSQL(q);                       
        return res;
    }
    
    public int borrar(int id){
        int res = 0;
        String q ="delete from perfil where id="+id;
        Conexion c = new Conexion();
        res=c.ejecutarSQL(q);
        return res;
    }
    
    public Auxiliar buscar(int id){
        String q = "Select * from perfil where id="+id;
        Conexion con = new Conexion();        
        Auxiliar perfil = new Auxiliar();
        
        ResultSet rs;
        if (con.conecta()){
            rs = con.leerDatos(q);
            try {
                while (rs.next()){
                    perfil.setId(rs.getInt(0));
                    perfil.setDetalle(rs.getString(1));                    
                }
                con.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return perfil;
    }
    
    public ArrayList<Auxiliar> listar (){
        ArrayList<Auxiliar> lista= new ArrayList<Auxiliar>();
        String q = "Select * from perfil;";
        
        Conexion con = new Conexion();
        if (con.conecta()){
            ResultSet rs;
            rs=con.leerDatos(q);
            Auxiliar perfil;
            try {
                while (rs.next()){
                    perfil = new Auxiliar();
                    perfil.setId(rs.getInt(1));
                    perfil.setDetalle(rs.getString(2));                                        
                    lista.add(perfil);
                }
                con.desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return lista;
    }
}
