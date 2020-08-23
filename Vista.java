
/**
 * Permite mostrar las diferentes funcionalidades encontradas en inicio.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Vista
{
  ArrayList<Lista> listas = new ArrayList();
  private Tarea tarea;
  Scanner s = new Scanner(System.in);
  
    public void agregarLista(){
        while (true) {
            System.out.println("¿Qué nombre tendrá la lista? ");
            String nombre = s.nextLine();
            Lista lista = new Lista(nombre);
            listas.add(lista);
            System.out.println("¿Quieres agregar otra listirijilla? ");
            String resp = s.nextLine();
            if ("n".equals(resp)) {
                break;
            }
        }
        System.out.println();
    }

  public void agregarTarea() {
      while (true) {
            System.out.println("¿Cómo se llamará la tarea? (consejo: evita nombres genéricos como \"trabajo de...\" o \"basura para entregar\") ");
            String nombre_tarea = s.nextLine();
            System.out.println("¿Para cuándo es la entrega de esa tareijirilla? (YYYY-MM-DD)");
            String fecha_entrega = s.nextLine();
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
            tarea = new Tarea(fecha_entrega, nombre_tarea, fav, l);
            System.out.println("¿Quieres agregar otra tareijirijilla? ");
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
        //for (int i=0; i<6; i++){
        //  for (int j=0; j<6; j++){
        //      int dia = j+(6*i)+1;
        //      cal[i][j]= dia;
        //      if (dia>=31){
        //        break;
        //      }
        //  }
        //}

        for (int i = 0; i < 31; i++) {
            System.out.print(cal[i] + "\t");
            if (cal[i] % 6 == 0) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("¿Para cuándo crees que tienes tareas? ");
        int fecha = s.nextInt();
        if (IntStream.of(cal).anyMatch(x -> x == fecha)) {
            if (fecha == tarea.getFecha_entrega().getDayOfMonth()) {
                System.out.println("Qué mala pata. El " + fecha + " tienes: " + tarea.getNombre());
            } else {
                System.out.println("¡Noks no hay nada para esa fecha!");
            }
        }
    }
}
