/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClasesXperia1IV;

/**
 *
 * @author AROMERO
 */
public class Test1 {

    public static Almacen almacen;
    public static Contabilidad contabilidad;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Almacen
        
        

        almacen = new Almacen(0, 0, 0, 0, 0);
        contabilidad = new Contabilidad();
        
        //Productores camaras
        
        Productor productor1 = new Productor("c1", "camara", 5);
        Productor productor2 = new Productor("c2", "camara", 5);
        Productor productor3 = new Productor("c3", "camara", 5);
        Productor productor4 = new Productor("c4", "camara", 5);
        Productor productor5 = new Productor("c5", "camara", 5);
        Productor productor6 = new Productor("c6", "camara", 5);
        Productor productor7 = new Productor("c7", "camara", 5);
        Productor productor8 = new Productor("c8", "camara", 5);
        
        //Productores pantallas
        
        Productor productor9 = new Productor("p1", "pantalla", 3);
        Productor productor10 = new Productor("p2", "pantalla", 3);
        
        //productores botones
        
        Productor productor11 = new Productor("b1", "botones", 4);
        Productor productor12 = new Productor("b2", "botones", 4);
        Productor productor13 = new Productor("b3", "botones", 4);
        Productor productor14 = new Productor("b4", "botones", 4);
        
        //Productores pin de carga
        
        Productor productor15 = new Productor("pc1", "pin", 5);
        Productor productor16 = new Productor("pc2", "pin", 5);
        
        //Ensamblador
        Ensamblador ensamblador1 = new Ensamblador(6, "e1");
        Ensamblador ensamblador2 = new Ensamblador(6, "e2");
        Ensamblador ensamblador3 = new Ensamblador(6, "e3");
        Ensamblador ensamblador4 = new Ensamblador(6, "e4");

        //Jefe
        
        Jefe jefecito = new Jefe();
        
        productor1.start();
        productor2.start();
        productor3.start();
        productor4.start();
        productor5.start();
        productor6.start();
        productor7.start();
        productor8.start();
        productor9.start();
        productor10.start();
        productor11.start();
        productor12.start();
        productor13.start();
        productor14.start();
        productor15.start();
        productor16.start();
        
        ensamblador1.start();
        ensamblador2.start();
        ensamblador3.start();
        ensamblador4.start();
        jefecito.start();
        
        
        


    }

}
