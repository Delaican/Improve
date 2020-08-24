/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        for(int i=0; i<segundos; i++){
            try {
                System.out.println(segundos);
                segundos--;
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(segundos==0){
            System.out.println("Lograste completar un pomodoro!");
            pomCompletos++;
        }
    }
}
