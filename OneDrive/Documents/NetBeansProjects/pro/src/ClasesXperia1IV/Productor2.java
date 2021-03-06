/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesXperia1IV;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AROMERO
 */
public class Productor2 extends Thread {

    private double salario;
    private String tipo;
    private boolean stop;

    public Productor2(String id, String tipo, double salario) {
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
            switch (this.getTipo()) {
                case "camara":
                    producirCamara(1);
                case "pin":
                    producirPinCarga(1);
                case "pantalla":
                    producirPantalla(1);
                case "botones":
                    producirBotones(1);

                default:
            }

        }

    }

    public void producirCamara(int cantidad) {
        try {
            Thread.sleep(3000);
            //double salarios = Test1.contabilidad.getSalariosProd();
            //Test.contabilidad.setSalariosProd(this.salario + salarios);
            //System.out.println("Salario => " + Test1.contabilidad.getSalariosProd());
            Test2.almacen2.getMutexCamaras().acquire();
            int numCamaras = Test2.almacen2.getCamaras();
            if (numCamaras + cantidad <= 20) {

                Test2.almacen2.setCamaras(numCamaras + cantidad);
                System.out.println("Camaras en almacen => " + Test2.almacen2.getCamaras());

            }
            Test2.almacen2.getMutexCamaras().release();

            //Test.almacen.mutexEnsamblaje.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Almacen2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void producirPantalla(int cantidad) {
        try {
            Thread.sleep(1000 / 3);
            Test2.almacen2.getMutexPantallas().acquire();
            int numPantalla = Test2.almacen2.getPantalla();
            if (numPantalla + cantidad <= 40) {

                Test2.almacen2.setPantalla(numPantalla + cantidad);
                System.out.println("Pantallas en almacen => " + Test2.almacen2.getPantalla());

            }
            Test2.almacen2.getMutexPantallas().release();
            //Test.almacen.mutexEnsamblaje.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Almacen2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void producirPinCarga(int cantidad) {
        try {
            Thread.sleep(1000);
            Test2.almacen2.getMutexPinCarga().acquire();
            int numPinCarga = Test2.almacen2.getPinCarga();
            if (numPinCarga + cantidad <= 15) {

                Test2.almacen2.setPinCarga(numPinCarga + cantidad);
                System.out.println("Pines de carga en almacen => " + Test2.almacen2.getPinCarga());
               
            }
            Test2.almacen2.getMutexPinCarga().release();
            //Test.almacen.mutexEnsamblaje.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Almacen2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void producirBotones(int cantidad) {
        try {
            Thread.sleep(1000);
            Test2.almacen2.getMutexBotones().acquire();
            int numBotones = Test2.almacen2.getBotones();
            if (numBotones + cantidad <= 45) {

                Test2.almacen2.setBotones(numBotones + cantidad);
                System.out.println("Botones en almacen => " + Test2.almacen2.getBotones());

            }
            Test2.almacen2.getMutexBotones().release();
            //Test.almacen.mutexEnsamblaje.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Almacen2.class.getName()).log(Level.SEVERE, null, ex);
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
