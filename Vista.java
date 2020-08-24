/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

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
    ArrayList<Lista> listas = new ArrayList();
    public Vista(){
        l1 = new Lista("Mi día");
        listas.add(l1);
        l2 = new Lista("Tareas urgentes");
        listas.add(l2);
        l3 = new Lista("Tareas Favoritas");
        listas.add(l3);
        l4 = new Lista("Tareas Completadas");
        listas.add(l4);
        l5 = new Lista("Sin Clasificar");
        listas.add(l5);
        
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

//        System.out.println();
//        System.out.println("¿Para cuándo crees que tienes tareas? ");
//        int fecha = s.nextInt();
//        if (IntStream.of(cal).anyMatch(x -> x == fecha)) {
//            if (fecha == tarea.getFecha_entrega().getDayOfMonth()) {
//                System.out.println("Qué mala pata. El " + fecha + " tienes: " + tarea.getNombre());
//            } else {
//                System.out.println("¡Noks no hay nada para esa fecha!");
//            }
//        }
    }
    
    public void pestana(){
        String resp;
        System.out.println("Improve v.0");
        System.out.println("-------------------------\n");
        if(listas.get(0).getLista().isEmpty()){
            System.out.println("No tienes tareas del día, pulsa \"s\" para agregar tareas!");
            resp = s.nextLine();
            if("s".equals(resp)){
                crearTarea();
            }
        } else { l1.getLista();}
        if(l2.getLista().isEmpty()){
            System.out.println("No tienes tareas urgentes, raro...");
        } else { l2.mostrarLista();}
        calendario();
    }
}
