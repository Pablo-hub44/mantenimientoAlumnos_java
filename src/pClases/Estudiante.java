/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pClases;

/**
 *
 * @author Pablo Jose
 */
public class Estudiante {
    //atributos privados de la clase estudiante
    private int codigo,ciclo;
    private String nombre;
    private double pension;
    
    //metodo constructor
    public Estudiante(int codigo,String nombre, int ciclo,double pension){
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciclo = ciclo;
        this.pension = pension;
    }
    
    //metodos sets y gets de los atributos de la clase Estudiante
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public int getCodigo(){
        return codigo;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    public void setPension(double pension){
        this.pension = pension;
    }
    public double getPension(){
        return pension;
    }
    
    public void setCiclo(int ciclo){
        this.ciclo = ciclo;
    }
    public int getCiclo(){
        return ciclo;
    }
    
}
