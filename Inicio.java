
/**
 * Es la ventana inicial de la aplicación. En esta se muestra la sección de
 * vistas.
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Inicio
{
    private Vista v = new Vista();
    
    public Inicio() {
        //menu();
        Lista l1 = new Lista("Mi día");
        Lista l2 = new Lista("Tareas Urgentes");
        Lista l3 = new Lista("Tareas Favoritas");
        Lista l4 = new Lista("Tareas Completadas");
        Lista l5 = new Lista("Sin Clasificar");
    }

    public void menu() {

        int selection;
        Scanner input = new Scanner(System.in);
        while (true) {
            /**
             * ************************************************
             */
            System.out.println("Improve v.0");
            System.out.println("-------------------------\n");
            System.out.println("1 - Añade una lista para añadir tareas!");
            System.out.println("2 - Añade tareas");
            System.out.println("3 - Calendario");
            System.out.println("0 - Salir");

            selection = input.nextInt();
            if (selection == 1) {
                v.agregarLista();
            }
            if (selection == 2) {
                v.agregarTarea();
            }
            if (selection == 3) {
                v.calendario();
            }
            if (selection == 0) {
                System.out.println("bueno está bien :(");
                break;
            }
        }
    }
}
