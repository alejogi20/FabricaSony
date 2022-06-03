/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesXperia10III;

import ClasesXperia1IV.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejo
 */
public class Ensamblador1 extends Thread {

    private double salario;
    private boolean stop;
    private boolean tieneCamaras;
    private boolean tieneBotones;
    private boolean tienePin;
    private boolean tienePantalla;

    public Ensamblador1(double salario, String id) {
        this.salario = salario;
        this.stop = true;
        this.tieneBotones = false;
        this.tieneCamaras = false;
        this.tienePin = false;
        this.tienePantalla = false;
    }

    public void stopToggle() {
        this.stop = !this.stop;
    }

    @Override
    public void run() {
        while (this.stop) {
            ensamblarTelefono(1);
        }
    }

    public void ensamblarTelefono(int cantidad) {
        try {
            if (!this.tieneCamaras) {
                Test1.almacen1.getMutexCamaras().acquire();
                int numCamaras = Test1.almacen1.getCamaras();
                if ((numCamaras - 2) >= 0) {
                    Test1.almacen1.setCamaras(numCamaras - 2);
                    this.tieneCamaras = true;
                }
                Test1.almacen1.getMutexCamaras().release();
            }

            if (!this.tienePantalla) {
                Test1.almacen1.getMutexPantallas().acquire();
                int numPantallas = Test1.almacen1.getPantalla();
                if ((numPantallas - 1) >= 0) {
                    Test1.almacen1.setPantalla(numPantallas - 1);
                    this.tienePantalla = true;
                }
                Test1.almacen1.getMutexPantallas().release();
            }

            if (!this.tienePin) {
                Test1.almacen1.getMutexPinCarga().acquire();
                int numPin = Test1.almacen1.getPinCarga();
                if ((numPin - 1) >= 0) {
                    Test1.almacen1.setPinCarga(numPin - 1);
                    this.tienePin = true;
                }
                Test1.almacen1.getMutexPinCarga().release();
            }

            if (!this.tieneBotones) {
                Test1.almacen1.getMutexBotones().acquire();
                int numBotones = Test1.almacen1.getBotones();
                if ((numBotones - 2) >= 0) {
                    Test1.almacen1.setBotones(numBotones - 2);
                    this.tieneBotones = true;
                }
                Test1.almacen1.getMutexBotones().release();
            }

            if (this.tieneBotones && this.tieneCamaras && this.tienePantalla && this.tienePin) {
                Thread.sleep(2000);
                Test1.almacen1.getMutexEnsamblaje().acquire();
                int numTelefonos = Test1.almacen1.getTelefonos();
                Test1.almacen1.setTelefonos(numTelefonos + cantidad);
                System.out.println("Telefonos en almacen " + Test1.almacen1.getTelefonos());
               
                Test1.almacen1.getMutexEnsamblaje().release();

                this.tieneBotones = false;
                this.tieneCamaras = false;
                this.tienePantalla = false;
                this.tienePin = false;
            }
            /*
            Test1.almacen.getMutexPantallas().release();
            Test1.almacen.getMutexPantallas().acquire();
            Test1.almacen.getMutexPinCarga().acquire();
            Test1.almacen.getMutexBotones().acquire();
            Test1.almacen.getMutexEnsamblaje().acquire();

            int numTelefonos = Test1.almacen.getTelefonos();

            int numPinCarga = Test1.almacen.getPinCarga();
            int numPantalla = Test1.almacen.getPantalla();
            int numBotones = Test1.almacen.getBotones();

            if ((numCamaras - 4) >= 0 && (numPinCarga - 1) >= 0 && (numPantalla - 1) >= 0 && (numBotones - 3) >= 0) {

                Test1.almacen.setBotones(numBotones - 3);
                Test1.almacen.setCamaras(numCamaras - 4);
                Test1.almacen.setPantalla(numPantalla - 1);
                Test1.almacen.setPinCarga(numPinCarga - 1);

                Test1.almacen.getMutexCamaras().release();
                Test1.almacen.getMutexPantallas().release();
                Test1.almacen.getMutexPinCarga().release();
                Test1.almacen.getMutexBotones().release();

                Thread.sleep(2000);
                Test1.almacen.setTelefonos(numTelefonos + cantidad);
                System.out.println("Telefonos en almacen " + Test1.almacen.getTelefonos());
                Test1.almacen.getMutexEnsamblaje().release();
            } else {
                Test1.almacen.getMutexCamaras().release();
                Test1.almacen.getMutexPantallas().release();
                Test1.almacen.getMutexPinCarga().release();
                Test1.almacen.getMutexBotones().release();
                Test1.almacen.getMutexEnsamblaje().release();
            }
             */
        } catch (InterruptedException ex) {
            Logger.getLogger(Almacen1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

}
