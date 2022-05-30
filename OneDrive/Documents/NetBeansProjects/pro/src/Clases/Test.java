/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

/**
 *
 * @author AROMERO
 */
public class Test {

    public static Almacen almacen;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        almacen = new Almacen(0, 0, 0, 0, 0);
        Productor productor1 = new Productor("1", "camara", 4);
        Productor productor2 = new Productor("2", "camara", 4);
        Productor productor3 = new Productor("3", "camara", 4);
        Ensamblador ensamb1 = new Ensamblador(6, "1");
        productor1.start();
        productor2.start();
        productor3.start();
        
        
        productor1.producirCamara(1);
        
        ensamb1.start();

    }

}
