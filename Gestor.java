
/**
 * Permite gestionar las tareas y utilizar el pomodoro.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gestor {

    private Tarea tarea;
    private Lista lista;
    private int pomCompletos = 0;

    public int getPomCompletos() {
        return pomCompletos;
    }

    public void setPomCompletos(int pomCompletos) {
        this.pomCompletos = pomCompletos;
    }

    public Gestor() {
        // initialise instance variables
    }

    public void pomodoro() {
        int segundos = 10;
        while(segundos>0){
            try {
                System.out.println(segundos);
                segundos--;
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Lograste completar un pomodoro!");
        pomCompletos++;
        
    }
}
