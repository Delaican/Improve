/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Esta clase define objetos de tipo Tarea.
 * 
 * @authors Christian Ruiz Lagos, Kevin Joel Dlaikan
 * @version 08/20/2020
 */
public class Tarea {

    LocalDate fecha_entrega;
    private String nombre;
    private boolean favorita;
    private long tInicio = 0;
    private long tFinal = 0;
    private long tInvertido = 0;
    private Lista lista;
    private Tarea tarea;
    private Gestor gestor;
    ArrayList<Lista> listas = new ArrayList();
    Scanner s = new Scanner(System.in);
    
     /**
     * Constructor de la clase Tarea.
     * @param nombre El nombre de la Tarea.
     * @param fecha_entrega La fecha de entrega de la Tarea.
     * @param favorita true si la Tarea es favorita o false si no lo es.
     * @param lista La lista a la cual pertenece la Tarea.
     */
    public Tarea(String nombre, LocalDate fecha_entrega, boolean favorita, Lista lista) {
        this.nombre = nombre;
        this.fecha_entrega = fecha_entrega;
        this.favorita = favorita;
        lista.agregarTarea(this);
    }
    
     /**
     * Método que permite obtener el nombre de un objeto de tipo Tarea.
     * @return Nombre de la tarea.
     */
    public String getNombre() {
        return nombre;
    }

     /**
     * Método que permite obtener la fecha de entrega de un objeto de tipo Tarea.
     * @return Fecha de entrega de la tarea.
     */
    public LocalDate getFecha_entrega() {
        return fecha_entrega;
    }

     /**
     * Método que permite conocer si un objeto de tipo Tarea es favorito o no.
     * @return true si la tarea es favorita o false si no lo es.
     */
    public boolean isFavorita() {
        return favorita;
    }

     /**
     * Método que permite obtener la lista a la cual pertenece una instancia de tipo Tarea.
     * @return Nombre de la lista destino.
     */
    public Lista getListaDestino() {
        return lista;
    }

     /**
     * Método que permite establecer un nombre a un objeto de tipo Tarea.
     * @param nombre Nombre de la Tarea.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     /**
     * Método que permite establecer una fecha de entrega a un objeto de tipo Tarea.
     * @param fecha_entrega Fecha de entrega de la Tarea.
     */
    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

     /**
     * Método que permite establecer el estado del atributo favorito a un objeto de tipo Tarea.
     * @param favorita Recibe true si la tarea es favorita o false si no lo es.
     */
    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

     /**
     * Método que permite establecer la lista padre de un objeto de tipo Tarea.
     * @param lista Recibe el nombre de la Lista a la cual pertenece.
     */
    public void setListaDestino(Lista lista) {
        this.lista = lista;
    }

     /**
     * Método que permite almacenar el tiempo en nanosegundos al iniciar una Tarea.
     */
    public void iniciarTarea() {
        tInicio = System.nanoTime();
    }

     /**
     * Método que permite almacenar el tiempo en nanosegundos al detener una tarea. Además, acumula la resta del tiempo final - tiempo inicial.
     */
     public void detenerTarea() {
        tFinal = System.nanoTime();
        tInvertido += tFinal - tInicio;
    }
    
     /**
     * Método establece el atributo tiempo final a 0, y el tiempo inicial al tiempo actual en nanosegundos.
     */
    public void reiniciarTarea() {
        tFinal = 0;
        tInicio = System.nanoTime();
    }

     /**
     * Método de prueba para crear Lista desde la pestaña Tareas.
     */
    public void crearLista() {
        while (true) {
            System.out.println("¿Qué nombre tendrá la lista? ");
            String nombre_lista = s.nextLine();
            lista = new Lista(nombre_lista);
            listas.add(lista);
            System.out.println("¿Quieres agregar otra lista? ");
            String resp = s.nextLine();
            if ("n".equals(resp)) {
                break;
            }
        }
        System.out.println();
    }

     /**
     * Método de prueba para crear Tarea.
     */
    public void crearTarea() {
        while (true) {
            System.out.println("¿Cómo se llamará la tarea? (consejo: evita nombres genéricos como \"trabajo de...\" o \"cosa para entregar\") ");
            String nombre_tarea = s.nextLine();
            System.out.println("¿Para cuándo es la entrega de esa tarea? (YYYY-MM-DD)");
            String fecha_str = s.nextLine();
            LocalDate fecha = LocalDate.parse(fecha_str);
            System.out.println("¿Tienes ganas de hacer la tarea? ");
            String resp = s.nextLine();
            boolean fav = false;
            if ("s".equals(resp)) {
                fav = true;
            }
            System.out.println("¿A qué lista pertenece la tarea? Estas son las listas que tienes creadas hasta el momento: ");
            listas.forEach((lista1) -> {
                System.out.println(lista1.getNombre());
            });
            System.out.println();
            String nombre_lista = s.nextLine();
            Lista l = null;
            for (int i = 0; i < listas.size(); i++) {
                if (listas.get(i).getNombre().equals(nombre_lista)) {
                    l = listas.get(i);
                }
            }
            tarea = new Tarea(nombre_tarea, fecha, fav, l);
            System.out.println("¿Quieres agregar otra tareaa? ");
            resp = s.nextLine();
            if ("n".equals(resp)) {
                listas.forEach((lista1) -> {
                    System.out.println(lista1.getNombre());
                    lista1.mostrarLista();
                });
                break;
            }
        }
        //l.mostrarLista();
    }

     /**
     * Método de prueba para crear Pestaña (menú que simula las funcionalidades de cada pestaña).
     */
    public void pestana() {
        String resp;
        System.out.println("Improve v.0");
        System.out.println("-------------------------\n");
        System.out.println("1. Crear tarea");
        System.out.println("2. Crear lista");
        System.out.println("3. Gestor/pomodoro");
        resp = s.nextLine();
        if ("1".equals(resp)) {
            crearTarea();
        } else if ("2".equals(resp)) {
            crearLista();
        } else if ("3".equals(resp)) {
            //gestor.pestana();
        }
    }
}
