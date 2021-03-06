/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesXperia10III;

import ClasesXperia1IV.*;
import static java.lang.Math.random;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author AROMERO
 */
public class Jefe1 extends Thread {

    private double salario;
    private boolean stop;
    private double horas;
    private boolean jugando;

    public Jefe1() {
        this.salario = 7;
        this.stop = true;
        this.horas = 0;
        this.jugando = false;

    }

    public void stopToggle() {
        this.stop = !this.stop;
    }

    @Override
    public void run() {
        while (this.stop) {
            while (this.horas <= 958.33) {
                clashRoyal();
                revisarPapeles();
            }
            conteoDias();
            this.horas = 0;
        }

    }

    public void conteoDias() {
        try {
            Test1.almacen1.getMutexConteoDias().acquire();
            int countDown = Test1.almacen1.getConteoDias();
            if (countDown > 0) {

                Thread.sleep((1000 / 24)); // 1 horas

                Test1.almacen1.setConteoDias(countDown - 1);

                //System.out.println("Quedan " + (countDown-1)  + " dias");


            } else {
                Test1.almacen1.setConteoDias(30);
            }
            Test1.almacen1.getMutexConteoDias().release();
        } catch (InterruptedException ex) {
            //
        }
    }

    public void clashRoyal() {
        try {

            Random rand = new Random();
            double randMinutos = rand.nextDouble() * (10.42 - 0.694) + (0.694);
            this.jugando = true;
            Thread.sleep((long) randMinutos); // 15 + 6 minutos : 21 minutos

            this.horas += (long) randMinutos;
            //System.out.println(randMinutos);
            //  System.out.println("El jefe esta jugando clash royale");

        } catch (InterruptedException ex) {
            //
        }

    }

    public void revisarPapeles() {
        try {
            Random rand = new Random();
            double randMinutos = rand.nextDouble() * (10.42 - 0.694) + (0.694);
            this.jugando = false;
            Thread.sleep((long) randMinutos); // 

            this.horas += (long) randMinutos;
            //System.out.println(randMinutos);
            //  System.out.println("El jefe esta revisando papeles");

        } catch (InterruptedException ex) {
            //
        }

    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public boolean isJugando() {
        return jugando;
    }

    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }

}
