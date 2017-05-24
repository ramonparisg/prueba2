/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raparisg
 */
public class Conexion {
    private String url="jdbc:mysql://localhost:3306/prograweb";
    private String login="root";
    private String pass="";
    Connection con;
    
    
    public boolean conecta(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,login,pass);
            System.out.println("bieeen");
            return true;
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public void desconecta(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int ejecutarSQL(String q){
        int res=0;
        
        if (conecta()){
            try {
                Statement stm=con.createStatement();
                res = stm.executeUpdate(q);
                desconecta();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        return res;
    }
    
    public ResultSet leerDatos(String q){
        ResultSet rs=null;
        PreparedStatement stm;
        try {
            stm = con.prepareStatement(q);
            rs = stm.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }                      
        return rs;        
    }
}
