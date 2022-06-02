/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesXperia1IV;

import static java.lang.Math.random;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author AROMERO
 */
public class Jefe extends Thread {

    private double salario;
    private boolean stop;

    public Jefe() {
        this.salario = 7;
        this.stop = true;

    }

    public void stopToggle() {
        this.stop = !this.stop;
    }

    @Override
    public void run() {
        while (this.stop) {
            conteoDias();
            ClashRoyal();
        }

    }

    public void conteoDias() {
        try {
            Test1.almacen.getMutexConteoDias().acquire();
            int countDown = Test1.almacen.getConteoDias();
            if (countDown > 0) {
                
                Thread.sleep((1000 / 24) * 7); // 6 + 1 horas
                
                Test1.almacen.setConteoDias(countDown - 1);

                System.out.println("Quedan " + countDown + " dias");

                Thread.sleep(10000); //Deberia ser 1000

            } else {
                Test1.almacen.setConteoDias(30);
            }
            Test1.almacen.getMutexConteoDias().release();
        } catch (InterruptedException ex) {
            //
        }
    }

    public void ClashRoyal() {
        try {
            Test1.almacen.getMutexConteoDias().acquire();
                
            Thread.sleep((long) Math.floor(Math.random()*(0.69 - 0.03 +1)+(0.03))); // 15 + 6 minutos : 21 minutos

                System.out.println("El jefe esta jugando Clash Royal");

            Test1.almacen.getMutexConteoDias().release();
        } catch (InterruptedException ex) {
            //
        }


    }

}
