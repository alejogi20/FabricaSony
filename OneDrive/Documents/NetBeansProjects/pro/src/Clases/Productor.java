/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AROMERO
 */
public class Productor extends Thread {

    private double salario;
    private String tipo;
    private boolean stop;

    public Productor(String id, String tipo, double salario) {
        this.tipo = tipo;
        this.salario = salario;
        this.stop = true;
    }

    public void stopToggle() {
        this.stop = !this.stop;
    }

    @Override
    public void run() {
        while (this.stop) {

            producirCamara(1);
            producirPantalla(1);

        }

    }

    public void producirCamara(int cantidad) {
        try {
            Test.almacen.mutexProduccion.acquire();
            int numCamaras = Test.almacen.getCamaras();
            if (numCamaras + cantidad <= 20) {

                Test.almacen.setCamaras(numCamaras + cantidad);
                System.out.println("camaras en almacen " + Test.almacen.getCamaras());
                Thread.sleep(3000);
            }
            Test.almacen.mutexProduccion.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void producirPantalla(int cantidad) {
        try {
            Test.almacen.mutexProduccion.acquire();
            int numPantalla = Test.almacen.getPantalla();
            if (numPantalla + cantidad <= 40) {

                Test.almacen.setPantalla(numPantalla + cantidad);
                System.out.println("Pantallas en almacen " + Test.almacen.getPantalla());
                Thread.sleep(1000/3);
            }
            Test.almacen.mutexProduccion.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void producirPinCarga(int cantidad) {
        try {
            Test.almacen.mutexProduccion.acquire();
            int numPinCarga = Test.almacen.getPinCarga();
            if (numPinCarga + cantidad <= 15) {

                Test.almacen.setPinCarga(numPinCarga + cantidad);
                System.out.println("Pines de carga en almacen " + Test.almacen.getPinCarga());
                Thread.sleep(1000);
            }
            Test.almacen.mutexProduccion.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void producirBotones(int cantidad) {
        try {
            Test.almacen.mutexProduccion.acquire();
            int numBotones = Test.almacen.getBotones();
            if (numBotones + cantidad <= 45) {

                Test.almacen.setBotones(numBotones + cantidad);
                System.out.println("camaras en almacen " + Test.almacen.getBotones());
                Thread.sleep(1000);
            }
            Test.almacen.mutexProduccion.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
