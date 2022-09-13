/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;

/**
 *
 * @author FELIPE
 */
public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tareas";
    
    public static Connection getConnection(){
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion =  DriverManager.getConnection(JDBC_URL, "root", "");
            System.out.println("Database Connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conexion;
    }
}
