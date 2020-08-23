/**
 * La clase Tareas permite acceder a los diferentes atributos de tareas.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
public class Tarea
{
  ArrayList<Lista> listas = new ArrayList();
  private Tarea tarea;
    
    // instance variables - replace the example below with your own
    LocalDate fecha_entrega;
    private String nombre;
    private boolean favorita;
    private Lista lista;
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
    
    public void crearTarea() {
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
}   