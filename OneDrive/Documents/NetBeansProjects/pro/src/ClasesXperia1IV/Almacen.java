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
    private int conteoDias;

    private Semaphore mutexCamaras;
    private Semaphore mutexPantallas;
    private Semaphore mutexPinCarga;
    private Semaphore mutexBotones;
    private Semaphore mutexEnsamblaje;
    private Semaphore mutexConteoDias;

    public Almacen(int camaras, int pinCarga, int botones, int pantalla, int telefonos) {
        
        this.camaras = camaras;
        this.pinCarga = pinCarga;
        this.botones = botones;
        this.pantalla = pantalla;
        this.telefonos = telefonos;
        this.conteoDias = 30;
        this.mutexCamaras = new Semaphore(1);
        this.mutexPantallas = new Semaphore(1);
        this.mutexBotones = new Semaphore(1);
        this.mutexPinCarga = new Semaphore(1);
        this.mutexEnsamblaje = new Semaphore(1);
        this.mutexConteoDias = new Semaphore(1);

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

    /**
     * @return the conteoDias
     */
    public int getConteoDias() {
        return conteoDias;
    }

    /**
     * @param conteoDias the conteoDias to set
     */
    public void setConteoDias(int conteoDias) {
        this.conteoDias = conteoDias;
    }

    /**
     * @return the mutexCamaras
     */
    public Semaphore getMutexCamaras() {
        return mutexCamaras;
    }

    /**
     * @param mutexCamaras the mutexCamaras to set
     */
    public void setMutexCamaras(Semaphore mutexCamaras) {
        this.mutexCamaras = mutexCamaras;
    }

    /**
     * @return the mutexPantallas
     */
    public Semaphore getMutexPantallas() {
        return mutexPantallas;
    }

    /**
     * @param mutexPantallas the mutexPantallas to set
     */
    public void setMutexPantallas(Semaphore mutexPantallas) {
        this.mutexPantallas = mutexPantallas;
    }

    /**
     * @return the mutexPinCarga
     */
    public Semaphore getMutexPinCarga() {
        return mutexPinCarga;
    }

    /**
     * @param mutexPinCarga the mutexPinCarga to set
     */
    public void setMutexPinCarga(Semaphore mutexPinCarga) {
        this.mutexPinCarga = mutexPinCarga;
    }

    /**
     * @return the mutexBotones
     */
    public Semaphore getMutexBotones() {
        return mutexBotones;
    }

    /**
     * @param mutexBotones the mutexBotones to set
     */
    public void setMutexBotones(Semaphore mutexBotones) {
        this.mutexBotones = mutexBotones;
    }

    /**
     * @return the mutexEnsamblaje
     */
    public Semaphore getMutexEnsamblaje() {
        return mutexEnsamblaje;
    }

    /**
     * @param mutexEnsamblaje the mutexEnsamblaje to set
     */
    public void setMutexEnsamblaje(Semaphore mutexEnsamblaje) {
        this.mutexEnsamblaje = mutexEnsamblaje;
    }

    /**
     * @return the mutexConteoDias
     */
    public Semaphore getMutexConteoDias() {
        return mutexConteoDias;
    }

    /**
     * @param mutexConteoDias the mutexConteoDias to set
     */
    public void setMutexConteoDias(Semaphore mutexConteoDias) {
        this.mutexConteoDias = mutexConteoDias;
    }

}
