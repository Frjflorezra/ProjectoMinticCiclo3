/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author FELIPE
 */
public class Tarea {
    private int id;
    private String titulo;
    private int prioridad;
    private int id_owner;
    
    public Tarea(){
        
    }

    public Tarea(String titulo, int prioridad, int id_owner) {
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.id_owner = id_owner;
    }
    
    public int validarPrioridad(String dataFormPrioridad){
        boolean isNumeric =  dataFormPrioridad.matches("[+-]?\\d*(\\.\\d+)?");
        int prioridad = isNumeric ? Integer.parseInt(dataFormPrioridad) : 0;
        return prioridad;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    public int getIdOwner() {
        return this.id_owner;
    }
    
    @Override
    public String toString(){
        return "{ Titulo: " + this.titulo + ", Prioridad " + this.prioridad + "}\n";
    }
}
