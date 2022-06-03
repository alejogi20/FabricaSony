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
public class Gerente extends Thread {

    private double salario;
    private boolean stop;
    private double horas;
    private double descuento;

    public Gerente() {
        this.salario = 180;
        this.stop = true;
        this.horas = 0;
        this.descuento = 0;
    }

    public void stopToggle() {
        this.stop = !this.stop;
    }

    @Override
    public void run() {
        while (this.stop) {

            Random rand = new Random();
            double periodo = Math.floor(rand.nextDouble() * (18 - 12) + (12));
            periodo = periodo * (1000 / 24);
            while (this.horas <= periodo) {
                vigilar();
            }

            conteoDiasG();
            this.horas = 0;

            despachar();

        }

    }

    public void conteoDiasG() {
        try {

            if (Test1.almacen.getConteoDias() != 0) {
                Thread.sleep((1000 / 24) * 6); // 6 horas

                Test1.almacen.getMutexConteoDias().acquire();
                int countDown = Test1.almacen.getConteoDias();

                System.out.println("Quedan " + countDown + " dias");
                Test1.almacen.getMutexConteoDias().release();
            }

        } catch (InterruptedException ex) {
            //
        }

    }

    public void vigilar() {
        try {

            Random rand = new Random();
            double randMinutos = rand.nextDouble() * (62.5 - 20.83) + (20.83); // 30 a 90 min
            this.horas += (long) randMinutos;
            Thread.sleep((long) randMinutos);

            if (Test1.jefe.isJugando()) {
                System.out.println("El jefe esta jugando");
                this.descuento += 2;
            }

        } catch (InterruptedException ex) {
            //
        }
    }

    public void despachar() {
        try {
            if (Test1.almacen.getConteoDias() == 0) {
                Test1.almacen.getMutexEnsamblaje().acquire();
                Test1.contabilidad.setVentas(Test1.almacen.getTelefonos() * 1199);
                Test1.almacen.setTelefonos(0);

                Test1.almacen.getMutexEnsamblaje().release();
                this.descuento = 0;
            }

        } catch (InterruptedException ex) {
            //
        }
    }
}
