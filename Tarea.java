/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 8.1Pro
 */
public class Tarea {

    LocalDate fecha_entrega;
    private String nombre;
    private boolean favorita;
    private long tInicio = 0;
    private long tFinal = 0;
    private Lista lista;
    private Tarea tarea;
    private Gestor gestor;
    ArrayList<Lista> listas = new ArrayList();
    Scanner s = new Scanner(System.in);

    public Tarea(String nombre, LocalDate fecha_entrega, boolean favorita, Lista lista) {
        this.nombre = nombre;
        this.fecha_entrega = fecha_entrega;
        this.favorita = favorita;
        lista.agregarTarea(this);
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha_entrega() {
        return fecha_entrega;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public Lista getListaDestino() {
        return lista;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    public void setListaDestino(Lista lista) {
        this.lista = lista;
    }

    public void iniciarTarea() {
        tInicio = System.nanoTime();
    }

    public void detenerTarea() {
        tFinal = System.nanoTime();
    }

    public void reiniciarTarea() {
        tInicio = System.nanoTime();
        tFinal = 0;
    }

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
