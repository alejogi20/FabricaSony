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
public class Gerente2 extends Thread {

    private double salario;
    private boolean stop;
    private double horas;
    private double descuento;

    public Gerente2() {
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

            if (Test2.almacen2.getConteoDias() != 0) {
                Thread.sleep((1000 / 24) * 6); // 6 horas

                Test2.almacen2.getMutexConteoDias().acquire();
                int countDown = Test2.almacen2.getConteoDias();

                System.out.println("Quedan " + countDown + " dias");
                Test2.almacen2.getMutexConteoDias().release();
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

            if (Test2.jefe2.isJugando()) {
                System.out.println("El jefe esta jugando");
                this.descuento += 2;
            } else {
                System.out.println("El jefe esta trabajando");
            }

        } catch (InterruptedException ex) {
            //
        }
    }

    public void despachar() {
        try {
            if (Test2.almacen2.getConteoDias() == 0) {
                Test2.almacen2.getMutexEnsamblaje().acquire();
                Test2.contabilidad2.setVentas(Test2.almacen2.getTelefonos() * 1199);
                Test2.almacen2.setTelefonos(0);

                Test2.almacen2.getMutexEnsamblaje().release();

                Test2.contabilidad2.calculoSalarios();
                System.out.println("Las ventas totales son => " + Test2.contabilidad2.getVentas());
                System.out.println("El costo por salarios es => " + Test2.contabilidad2.getCostos());
                Test2.contabilidad2.setGanancia(Test2.contabilidad2.getVentas() - Test2.contabilidad2.getCostos());
                System.out.println("Las ganancia total es => " + Test2.contabilidad2.getGanancia());
                System.out.println("Las multas al jefe tienen un valor de => " + this.descuento);
                this.descuento = 0;
                Test2.contabilidad2.setGanancia(0);
                Test2.contabilidad2.setVentas(0);
                Test2.contabilidad2.setCostos(0);
                Test2.contabilidad2.setSalarioJefe(0);
                Test2.contabilidad2.setSalarioGer(0);
                Test2.contabilidad2.setSalariosEns(0);
                Test2.contabilidad2.setSalariosProd(0);
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
