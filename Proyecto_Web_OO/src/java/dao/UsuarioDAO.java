/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class UsuarioDAO {
    private static String db = "proyectoweboo";
    private static String url = "jdbc:mysql://localhost/"+db;
    private static String user = "root";
    private static String pass = "admin";
    private static Connection con;
    
    public static boolean login(String rut, String password){
        con = null;
        PreparedStatement ps = null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            
            con = DriverManager.getConnection(db, user, pass);
            
            ps = con.prepareStatement("SELECT rut, password FROM usuario where rut = ? and password = ? ");
            ps.setString(1, rut);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("rut"));
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            System.out.println("Error in login() --> " + ex.getMessage());
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error in login() --> " + ex.getMessage());
                return false;
            }
        }
    }
}
