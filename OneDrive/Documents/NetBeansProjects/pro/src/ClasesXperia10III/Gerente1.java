/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesXperia10III;

import ClasesXperia1IV.*;
import java.util.Random;

/**
 *
 * @author AROMERO
 */
public class Gerente1 extends Thread {

    private double salario;
    private boolean stop;
    private double horas;
    private double descuento;

    public Gerente1() {
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

            if (Test1.almacen1.getConteoDias() != 0) {
                Thread.sleep((1000 / 24) * 6); // 6 horas

                Test1.almacen1.getMutexConteoDias().acquire();
                int countDown = Test1.almacen1.getConteoDias();

                System.out.println("Quedan " + countDown + " dias");
                Test1.almacen1.getMutexConteoDias().release();
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

            if (Test1.jefe1.isJugando()) {
                System.out.println("El jefe esta jugando");
                this.descuento += 2;
            }

        } catch (InterruptedException ex) {
            //
        }
    }

    public void despachar() {
        try {
            if (Test1.almacen1.getConteoDias() == 0) {
                Test1.almacen1.getMutexEnsamblaje().acquire();
                Test1.contabilidad1.setVentas(Test1.almacen1.getTelefonos() * 600);
                Test1.almacen1.setTelefonos(0);

                Test1.almacen1.getMutexEnsamblaje().release();

                Test1.contabilidad1.calculoSalarios();
                System.out.println("Las ventas totales son => " + Test1.contabilidad1.getVentas());
                System.out.println("El costo por salarios es => " + Test1.contabilidad1.getCostos());
                Test1.contabilidad1.setGanancia(Test1.contabilidad1.getVentas() - Test1.contabilidad1.getCostos());
                System.out.println("Las ganancia total es => " + Test1.contabilidad1.getGanancia());
                System.out.println("Las multas al jefe tienen un valor de => " + this.descuento);
                this.descuento = 0;
                Test1.contabilidad1.setGanancia(0);
                Test1.contabilidad1.setVentas(0);
                Test1.contabilidad1.setCostos(0);
                Test1.contabilidad1.setSalarioJefe(0);
                Test1.contabilidad1.setSalarioGer(0);
                Test1.contabilidad1.setSalariosEns(0);
                Test1.contabilidad1.setSalariosProd(0);
            }

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

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

}
