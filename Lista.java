/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;


/**
 * Esta clase define objetos de tipo Tarea.
 * 
 * @authors Christian Ruiz Lagos, Kevin Joel Dlaikan
 * @version 08/20/2020
 */
public class Lista {
    //private Tarea tarea;
    private String nombre;
    ArrayList<Tarea> lista;
    
     /**
     * Constructor de la clase Lista.
     * @param nombre El nombre de la Lista.
     */
    public Lista(String nombre){
        this.nombre = nombre;
         lista = new ArrayList();
    }
<<<<<<< Updated upstream

    /**
     * Método que permite obtener el nombre de un objeto de tipo Lista.
     * @return Nombre de la lista.
     */
=======
    public Lista getObjectLista() {
        return this;
    }
>>>>>>> Stashed changes
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que permite establecer el nombre a un objeto de tipo Lista.
     * @param nombre El nombre a asignar a la lista.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método que permite obtener la lista de Tareas contenidas en un objeto de tipo Lista.
     * @return Lista que almacena objetos de tipo Tarea.
     */
    public ArrayList<Tarea> getLista() {
        return lista;
    }

    /**
     * Método que permite establecer una lista que almacena Tareas a una instancia de tipo Lista.
     * @param lista ArrayList de objetos tipo Tarea.
     */
    public void setLista(ArrayList<Tarea> lista) {
        this.lista = lista;
    }
    
    /**
     * Método que permite agregar un objeto de tipo Tarea a un objeto de tipo Lista.
     * @param tarea Objeto de tipo Tarea.
     */
    public void agregarTarea(Tarea tarea){
        lista.add(tarea);
    }
    
    /**
     * Método que permite mostrar el nombre de las listas previamente creadas.
     */
    public void mostrarLista(){
        lista.forEach((lista1) -> {
            System.out.println(lista1.getNombre());
        });
    }

}
