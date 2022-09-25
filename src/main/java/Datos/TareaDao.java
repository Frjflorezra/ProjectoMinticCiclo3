/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FELIPE
 */
public class TareaDao {
    
    public static boolean agregarTarea(Tarea tarea){
        
        boolean tareaValida = TareaDao.validarTarea(tarea);

        if(tareaValida){
            String query = "INSERT INTO tarea (titulo, prioridad, id_usuario) VALUES (?,?,?)";
            try {
                Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, tarea.getTitulo());
                stmt.setInt(2, tarea.getPrioridad());
                stmt.setInt(3, tarea.getIdOwner());
                stmt.executeUpdate();
                conn.close();
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                return false;
            }
        }else{
            return false;
        }
        return true;
    }
    
    public static boolean validarTarea(Tarea tarea){
        boolean tareaEncontrada = TareaDao.buscarTarea( tarea.getTitulo() );
        if(tareaEncontrada) return false;
        
        if("".equals(tarea.getTitulo())) return false;
        if(tarea.getPrioridad() < 0) tarea.setPrioridad(0);
        if(tarea.getPrioridad() > 100) tarea.setPrioridad(100);
        
        return true;
    }
    
    public static boolean buscarTarea(String titulo){
        //Consultar en la BD si se encuentra un usuario con el mismo username
        String query = "SELECT * FROM tarea t WHERE t.titulo = ?";
        boolean encontrado = false;
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, titulo);
            ResultSet set = stmt.executeQuery();
            if(set.next()) {
                encontrado = true;
            }
            conn.close();
            stmt.close();
            set.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return encontrado;
    }
    
    
}
