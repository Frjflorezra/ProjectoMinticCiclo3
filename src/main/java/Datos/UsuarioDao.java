/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Usuario;
import java.sql.*;
import java.util.List;

/**
 *
 * @author FELIPE
 */
public class UsuarioDao{
    
    
    /**
     * Metodo para la edicion de los datos de un usuario
     * @param usuario 
     */
    public static void editarUsuario(Usuario usuario) {
        String query = "UPDATE usuario SET nombre = ?, apellido = ?, username = ?, password = ? WHERE id_usuario = ?";
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getUsername());
            stmt.setString(4, usuario.getPassword());
            stmt.setInt(5, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    /**
     * Metodo para agregar usuario cuando se haga el registro, No se validan usuarios repetidos
     * @param usuario
     */
    public static boolean agregarUsuario(Usuario usuario){
        
        boolean usuarioValido = UsuarioDao.validarUsuario(usuario);

        if(usuarioValido){
            String query = "INSERT INTO usuario (nombre, apellido, correo, username, password) VALUES (?,?,?,?,?)";
            try {
                Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, usuario.getNombre());
                stmt.setString(2, usuario.getApellido());
                stmt.setString(3, usuario.getCorreo());
                stmt.setString(4, usuario.getUsername());
                stmt.setString(5, usuario.getPassword());
                stmt.executeUpdate();
                conn.close();
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                return false;
            }
        }else{
            System.out.println("Nanai papi no se pudo");
            return false;
        }
        return true;
    }
    
    
    public static boolean validarUsuario(Usuario usuario){
        boolean usuarioEncontrado = UsuarioDao.buscarUsuario( usuario.getUsername() );
        if(usuarioEncontrado) return false;
        List<String> atributos = usuario.getAtributos();   
        for(String atributo : atributos){
            if( "".equals(atributo) ){
                return false;
            }
        }
        return true;
    }
    
    public static boolean buscarUsuario(String username){
        //Consultar en la BD si se encuentra un usuario con el mismo username
        String query = "SELECT * FROM usuario u WHERE u.username = ?";
        boolean encontrado = false;
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet set = stmt.executeQuery();
            if(set.next()) {
                encontrado = true;
                System.out.println("Papu, este username ya esta en uso XD");
            }
            conn.close();
            stmt.close();
            set.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return encontrado;
    }
    
    public static String getNombre(String username){
        System.out.println("yesss into");
        String query = "SELECT * FROM usuario u WHERE u.username = ?";
        String nombre = "";
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet set = stmt.executeQuery();
            if(set.next()) {
                System.out.println("YEEEEES " + set.getString("nombre"));
                nombre += set.getString("nombre");
                nombre += " " + set.getString("apellido");
            }
            conn.close();
            stmt.close();
            set.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return nombre;
    }
    
    public static boolean autenticarUsuario(String username, String password){
        boolean credencialesValidas = false;
        try {
            String query = "SELECT username, password FROM usuario u WHERE u.username = ?";
            Connection conn = Conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet set = stmt.executeQuery();
            if(set.next()) {
                String DB_USERNAME = set.getString("username");
                String DB_PASSWORD = set.getString("password");
                if(username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)){
                    credencialesValidas = true;
                }
            }
            conn.close();
            stmt.close();
            set.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return credencialesValidas;
    }
}
