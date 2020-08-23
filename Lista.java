
/**
 * Listas para organizar tareas.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Lista
{
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
