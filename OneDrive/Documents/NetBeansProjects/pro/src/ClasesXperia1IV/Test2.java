/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClasesXperia1IV;

/**
 *
 * @author AROMERO
 */
public class Test2 {

    public static Almacen2 almacen2;
    public static Contabilidad2 contabilidad2;
    public static Jefe2 jefe2;
    public static Gerente2 gerente2;
    public static int cantidadPCamara;
    public static int cantidadPPin;
    public static int cantidadPbotones;
    public static int cantidadPPantalla;
    public static int cantidadEnsambladores;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Almacen
        almacen2 = new Almacen2(0, 0, 0, 0, 0);
        contabilidad2 = new Contabilidad2();
        jefe2 = new Jefe2();
        gerente2 = new Gerente2();
        //Productores camaras

        Productor2 productor1 = new Productor2("c1", "camara", 5);
        Productor2 productor2 = new Productor2("c2", "camara", 5);
        Productor2 productor3 = new Productor2("c3", "camara", 5);
        Productor2 productor4 = new Productor2("c4", "camara", 5);
        Productor2 productor5 = new Productor2("c5", "camara", 5);
        Productor2 productor6 = new Productor2("c6", "camara", 5);
        Productor2 productor7 = new Productor2("c7", "camara", 5);
        Productor2 productor8 = new Productor2("c8", "camara", 5);

        //Productores pantallas
        Productor2 productor9 = new Productor2("p1", "pantalla", 3);
        Productor2 productor10 = new Productor2("p2", "pantalla", 3);

        //productores botones
        Productor2 productor11 = new Productor2("b1", "botones", 4);
        Productor2 productor12 = new Productor2("b2", "botones", 4);
        Productor2 productor13 = new Productor2("b3", "botones", 4);
        Productor2 productor14 = new Productor2("b4", "botones", 4);

        //Productores pin de carga
        Productor2 productor15 = new Productor2("pc1", "pin", 5);
        Productor2 productor16 = new Productor2("pc2", "pin", 5);

        //Ensamblador
        Ensamblador2 ensamblador1 = new Ensamblador2(6, "e1");
        Ensamblador2 ensamblador2 = new Ensamblador2(6, "e2");
        Ensamblador2 ensamblador3 = new Ensamblador2(6, "e3");
        Ensamblador2 ensamblador4 = new Ensamblador2(6, "e4");

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
        jefe2.start();
        gerente2.start();

    }

}
