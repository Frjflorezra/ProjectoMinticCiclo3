/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import java.util.Arrays;

/**
 *
 * @author FELIPE
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String username;        
    private String password;        

    public Usuario(){}
    
    public Usuario(int id, String nombre, String apellido, String correo, String username, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.username = username;
        this.password = password;
    }
    
    public Usuario(String nombre, String apellido, String correo, String username, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.username = username;
        this.password = password;
    }
    
    
    /**
     * Metodo que retorna una lista con los atributos de un usuario ( Funcion : Faciltiar la validacion de los datos )
     * @param u = usuario
     * @return 
     */
    public List<String> getAtributos(){
        String tmpAtributos[] = {this.getApellido() , this.getCorreo(), this.getNombre(), this.getPassword(), this.getUsername()};
        return Arrays.asList(tmpAtributos); //Metodo que convierte un array estatico en una List<T>
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", username=" + username + '}';
    }

}
