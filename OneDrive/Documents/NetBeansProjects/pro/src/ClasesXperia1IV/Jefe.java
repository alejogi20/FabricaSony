/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesXperia1IV;

import java.util.Random;

/**
 *
 * @author AROMERO
 */
public class Jefe extends Thread {

    private double salario;
    private int countDown;
    private boolean stop;

    public Jefe() {
        this.salario = 7;
        this.countDown = 30;
        this.stop = true;

    }

    public void stopToggle() {
        this.stop = !this.stop;
    }

    @Override
    public void run() {
        while (this.stop) {
            conteoDias();
        }

    }

    public void conteoDias() {
        try {
            if(this.countDown > 0){
            this.countDown = this.countDown - 1;
            System.out.println("Quedan " + this.countDown + " dias");
            Thread.sleep((1000 / 24) * 7);

            //Jugando y revisando papeles
            Random random = new Random();
            Thread.sleep(random.nextInt(15));
            }

        } catch (InterruptedException ex) {
            //
        }
    }

}
