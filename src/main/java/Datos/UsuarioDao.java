/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Usuario;
import java.sql.*;

/**
 *
 * @author FELIPE
 */
public class UsuarioDao {
    
    
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
     * Metodo para agregar usuario cuando se logueen
     * @param usuario
     */
    public static void agregarUsuario(Usuario usuario){
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
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
