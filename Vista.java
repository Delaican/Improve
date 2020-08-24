/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.time.LocalDate;

/**
 *
 * @author 8.1Pro
 */
public class Vista {

    Scanner s = new Scanner(System.in);
    private Tarea tarea;
    private Lista lista;
    Lista l1;
    Lista l2;
    Lista l3;
    Lista l4;
    Lista l5;
    Lista lc;
    ArrayList<Lista> listas = new ArrayList();

    public Vista() {
        l1 = new Lista("mi dia");
        listas.add(l1);
        l2 = new Lista("tareas urgentes");
        listas.add(l2);
        l3 = new Lista("tareas favoritas");
        listas.add(l3);
        l4 = new Lista("tareas completadas");
        listas.add(l4);
        l5 = new Lista("sin clasificar");
        listas.add(l5);
        lc = new Lista("todas");
    }

    public void crearLista() {
        while (true) {
            System.out.println("¿Qué nombre tendrá la lista? ");
            String nombre_lista = s.nextLine();
            lista = new Lista(nombre_lista);
            listas.add(lista);
            System.out.println("¿Quieres agregar otra lista? s/n");
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
            System.out.println("¿Tienes ganas de hacer la tarea? s/n ");
            String resp = s.nextLine();
            boolean fav = false;
            if ("s".equals(resp)) {
                fav = true;
            }
            System.out.println("¿A qué lista pertenece la tarea? Estas son las listas que tienes creadas hasta el momento: ");
            listas.forEach((lista1) -> {
                if(!"tareas urgentes".equals(lista1.getNombre())&&!"tareas favoritas".equals(lista1.getNombre())){
                    System.out.println(lista1.getNombre());
                }
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
            lc.agregarTarea(tarea);
            if(fecha.getDayOfMonth()-LocalDate.now().getDayOfMonth()<3){
                l2.agregarTarea(tarea);
            }
            if(tarea.isFavorita()){
                l3.agregarTarea(tarea);
            }
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

    public void calendario() {
        int[] cal = new int[31];

        for (int i = 0; i < 31; i++) {
            cal[i] = i + 1;
        }
//        for (int i=0; i<6; i++){
//            for (int j=0; j<6; j++){
//                int dia = j+(6*i)+1;
//                cal[i][j]= dia;
//                if (dia>=31){
//                    break;
//                }
//            }
//        }

        for (int i = 0; i < 31; i++) {
            System.out.print(cal[i] + "\t");
            if (cal[i] % 6 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("¿Para cuándo crees que tienes tareas? ");
        int fecha = s.nextInt();
        if (IntStream.of(cal).anyMatch(x -> x == fecha)) {
            for (int i = 0; i < lc.getLista().size(); i++) {
                if (fecha == lc.getLista().get(i).getFecha_entrega().getDayOfMonth()) {
                    System.out.println("Qué mala pata. El " + fecha + " tienes: " + lc.getLista().get(i).getNombre());
                    break;
                } else {
                    System.out.println("¡Noks no hay nada para esa fecha!");
                }
            }
        }
    }

    public void pestana() {
        String resp;
        System.out.println("Improve v.0");
        System.out.println("-------------------------\n");
        System.out.println("Mi Día:");
        System.out.println("-------------------------\n");
        if (listas.get(0).getLista().isEmpty()) {
            System.out.println("No tienes tareas del día!");
            System.out.println("Podrías comenzar creando Tareas pulsando 1, o 2 para crear Listas: ");
            resp = s.nextLine();
            if ("1".equals(resp)) {
                crearTarea();
            } else if ("2".equals(resp)) {
                crearLista();
            }

        } else {
            l1.mostrarLista();
            System.out.println("-------------------------\n");
            System.out.println("Quieres visitar el calendario? s/n");
            resp = s.nextLine();
            if ("s".equals(resp)) {
                calendario();
            }
        }
        System.out.println("-------------------------\n");
        System.out.println("Tareas Urgentes:");
        System.out.println("-------------------------\n");
        if (l2.getLista().isEmpty()) {
            System.out.println("No tienes tareas urgentes, raro...");
        } else {
            l2.mostrarLista();

        }
        System.out.println("Deseas ir a la pestaña de tareas o quieres quedarte en la sección de vistas? s/n");
        resp = s.nextLine();
        if ("s".equals(resp)) {
            tarea.pestana();
        } else {
            pestana();
        }
    }
}
