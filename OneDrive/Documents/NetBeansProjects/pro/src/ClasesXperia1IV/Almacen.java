/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesXperia1IV;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AROMERO
 */
public class Almacen {

    private int camaras;
    private int pinCarga;
    private int botones;
    private int pantalla;
    private int telefonos;

    public Semaphore mutexCamaras;
    public Semaphore mutexPantallas;
    public Semaphore mutexPinCarga;
    public Semaphore mutexBotones;
    public Semaphore mutexEnsamblaje;

    public Almacen(int camaras, int pinCarga, int botones, int pantalla, int telefonos) {
        
        this.camaras = camaras;
        this.pinCarga = pinCarga;
        this.botones = botones;
        this.pantalla = pantalla;
        this.telefonos = telefonos;
        this.mutexCamaras = new Semaphore(1);
        this.mutexPantallas = new Semaphore(1);
        this.mutexBotones = new Semaphore(1);
        this.mutexPinCarga = new Semaphore(1);
        this.mutexEnsamblaje = new Semaphore(1);

    }

    public int getCamaras() {
        return camaras;
    }

    public void setCamaras(int camaras) {
        this.camaras = camaras;
    }

    public int getPinCarga() {
        return pinCarga;
    }

    public void setPinCarga(int pinCarga) {
        this.pinCarga = pinCarga;
    }

    public int getBotones() {
        return botones;
    }

    public void setBotones(int botones) {
        this.botones = botones;
    }

    public int getPantalla() {
        return pantalla;
    }

    public void setPantalla(int pantalla) {
        this.pantalla = pantalla;
    }

    public int getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(int telefonos) {
        this.telefonos = telefonos;
    }

}
