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
            Test.almacen.mutexProduccion.acquire();
            int numTelefonos = Test.almacen.getTelefonos();
            int numCamaras = Test.almacen.getCamaras();
            int numPinCarga = Test.almacen.getPinCarga();
            int numPantalla = Test.almacen.getPantalla();
            int numBotones = Test.almacen.getBotones();
            
            if (numCamaras > 0 && numPinCarga > 0 && numPantalla > 0 && numBotones > 0) {
                
                Test.almacen.setTelefonos(numTelefonos + cantidad);
                Test.almacen.setBotones(numBotones - 3);
                Test.almacen.setCamaras(numCamaras -4);
                Test.almacen.setPantalla(numPantalla -1);
                Test.almacen.setPantalla(numPinCarga -1);
                System.out.println("Telefonos en almacen " + Test.almacen.getTelefonos());
                Thread.sleep(2000);
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



}
