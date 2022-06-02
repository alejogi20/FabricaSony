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
public class Ensamblador extends Thread {

    private double salario;
    private boolean stop;

    public Ensamblador(double salario, String id) {
        this.salario = salario;
        this.stop = true;
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
            Test1.almacen.getMutexCamaras().acquire();
            Test1.almacen.getMutexPantallas().acquire();
            Test1.almacen.getMutexPinCarga().acquire();
            Test1.almacen.getMutexBotones().acquire();
            Test1.almacen.getMutexEnsamblaje().acquire();

            int numTelefonos = Test1.almacen.getTelefonos();
            int numCamaras = Test1.almacen.getCamaras();
            int numPinCarga = Test1.almacen.getPinCarga();
            int numPantalla = Test1.almacen.getPantalla();
            int numBotones = Test1.almacen.getBotones();

            if ((numCamaras - 4) > 0 && (numPinCarga - 1) > 0 && (numPantalla - 1) > 0 && (numBotones - 3) > 0) {

                Test1.almacen.setTelefonos(numTelefonos + cantidad);
                Test1.almacen.setBotones(numBotones - 3);
                Test1.almacen.setCamaras(numCamaras - 4);
                Test1.almacen.setPantalla(numPantalla - 1);
                Test1.almacen.setPinCarga(numPinCarga - 1);
                System.out.println("Telefonos en almacen " + Test1.almacen.getTelefonos());
                Thread.sleep(2000);

            }
            Test1.almacen.getMutexCamaras().release();
            Test1.almacen.getMutexPantallas().release();
            Test1.almacen.getMutexPinCarga().release();
            Test1.almacen.getMutexBotones().release();
            Test1.almacen.getMutexEnsamblaje().release();

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

}
