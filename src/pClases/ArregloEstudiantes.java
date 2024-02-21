/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pClases;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo Jose
 */
public class ArregloEstudiantes {
    
    //metodo constructor que crea el objeto aEst de tipo arraylist
    //y carga el contenido del archivo estudiantes.txt
    private ArrayList <Estudiante> aEst;
    
    public ArregloEstudiantes(){
        aEst = new ArrayList<Estudiante>();
        cargar();
    }
    
    //metodo que adiciona un objeto de tipo Estudiante al ArrayList
    public void adicionar(Estudiante e){
        aEst.add(e);
    }
    
    //metodo que devuelve los elementos en el arreglo segun una posicion especifica
    public Estudiante obtener(int pos){
        return aEst.get(pos);
    }
    
    //metodo que busca un estudiante desde el arreglo y devuelve
    //el objeto de tipo estudiante,si no lo encuentra lo devolvera null
    public Estudiante buscar(int cod){
        for (int i = 0; i < aEst.size(); i++) {
            if (cod == aEst.get(i).getCodigo()) {
                return aEst.get(i);
            }
        }
        return null;
    }
    
    
    //metodo que devuelve el total de estudiantes registrados
    public int getTamaño(){
        return aEst.size();
    }
    
    //metodo que permite eiminar un estudiante del arreglo mediante
    //el objeto de tipo Estudiante
    public void eliminar(Estudiante e){
        aEst.remove(e);
    }
    
    //metodo que permite abrir el archivo estudiante.txt y obtener los valores contenidos
    //almacenandolos en variable
    public void cargar(){
        try {
            File archivo = new File("Estudiantes.txt");
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(
                new FileReader("Estudiantes.txt"));
                String linea;
                while ((linea=br.readLine()) !=null ) {
                    //definicion del separador de valores en estudiantes.txt
                    StringTokenizer st = new StringTokenizer(linea,",");
                    int cod= Integer.parseInt(st.nextToken().trim());
                    String nom= st.nextToken().trim();
                    int cic=Integer.parseInt(st.nextToken().trim());
                    double pen= Double.parseDouble(st.nextToken().trim());
                    
                    //crear un nuevo registro de estudiente obtenido del
                    //archivo Estudiantes.txt
                    Estudiante x= new Estudiante(cod,nom,cic,pen);
                    adicionar(x);
                }
                br.close();
            }else{
                JOptionPane.showMessageDialog(null, "El archivo de texto no existe");
            }
               
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "se produjo un Error "+x);
        }
    }
    
    //metodo que permite grabar los nuevos valores de un estudiante
    public void grabar(){
        try {
            PrintWriter pw= new PrintWriter(new FileWriter("Estudiantes.txt"));
            for (int i = 0; i < getTamaño(); i++) {//ejecuta un numero determinado de veces un conjunto de sentencias o instrucciones y controla de forma automatica el numero de iteraciones que esta realiza
            pw.print(obtener(i).getCodigo()+","+obtener(i).getNombre()+","+obtener(i).getCiclo()+","+obtener(i).getPension());
            }
            pw.close();
            JOptionPane.showMessageDialog(null, "Operacion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Grabacion no exitosa", "aviso",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    
}
