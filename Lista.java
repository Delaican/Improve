/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;


/**
 *
 * @author 8.1Pro
 */
public class Lista {
    //private Tarea tarea;
    private String nombre;
    ArrayList<Tarea> lista = new ArrayList();
    
    public Lista(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<Tarea> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Tarea> lista) {
        this.lista = lista;
    }
    
    public void agregarTarea(Tarea tarea){
        lista.add(tarea);
    }
    
    public void mostrarLista(){
        lista.forEach((lista1) -> {
            System.out.println(lista1.getNombre());
        });
    }

}
