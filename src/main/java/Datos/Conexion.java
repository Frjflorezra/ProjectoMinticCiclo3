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
    private static final String JDBC_URL = "jdbc:mysql://root:VdSuZkuXVJUqdprPrmZl@containers-us-west-79.railway.app:6141/railway";
    
    public static Connection getConnection(){
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion =  DriverManager.getConnection(JDBC_URL, "root", "VdSuZkuXVJUqdprPrmZl");
            System.out.println("Database Connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conexion;
    }
}
