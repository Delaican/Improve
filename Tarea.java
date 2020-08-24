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
    private Lista lista;
    private Tarea tarea;
    ArrayList<Lista> listas = new ArrayList();
    Scanner s = new Scanner(System.in);

    public Tarea(String fecha_entrega, String nombre, boolean favorita, Lista lista) {
        this.fecha_entrega = LocalDate.parse(fecha_entrega);
        this.nombre = nombre;
        this.favorita = favorita;
        lista.agregarTarea(this);
    }

    public LocalDate getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
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
            String fecha = s.nextLine();
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
            tarea = new Tarea(fecha, nombre_tarea, fav, l);
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
            resp = s.nextLine();
            if ("1".equals(resp)) {
                crearTarea();
            }
    }
}
