/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClasesXperia10III;

import ClasesXperia1IV.Almacen2;
import ClasesXperia1IV.Contabilidad2;
import ClasesXperia1IV.Ensamblador2;
import ClasesXperia1IV.Gerente2;
import ClasesXperia1IV.Jefe2;
import ClasesXperia1IV.Productor2;
import static ClasesXperia1IV.Test2.almacen2;
import static ClasesXperia1IV.Test2.contabilidad2;
import static ClasesXperia1IV.Test2.gerente2;
import static ClasesXperia1IV.Test2.jefe2;

/**
 *
 * @author alejo
 */
public class Test1 {

    public static Almacen1 almacen1;
    public static Contabilidad1 contabilidad1;
    public static Jefe1 jefe1;
    public static Gerente1 gerente1;
    public static int cantidadPCamara;
    public static int cantidadPPin;
    public static int cantidadPbotones;
    public static int cantidadPPantalla;
    public static int cantidadEnsambladores;

    public static void main(String[] args) {
        // TODO code application logic here

//Almacen
        almacen1 = new Almacen1(0, 0, 0, 0, 0);
        contabilidad1 = new Contabilidad1();
        jefe1 = new Jefe1();
        gerente1 = new Gerente1();
        //Productores camaras

        Productor1 productor1 = new Productor1("c1", "camara", 5);
        Productor1 productor2 = new Productor1("c2", "camara", 5);
        Productor1 productor3 = new Productor1("c3", "camara", 5);
        Productor1 productor4 = new Productor1("c4", "camara", 5);
        Productor1 productor5 = new Productor1("c5", "camara", 5);
        Productor1 productor6 = new Productor1("c6", "camara", 5);
        Productor1 productor7 = new Productor1("c7", "camara", 5);
        Productor1 productor8 = new Productor1("c8", "camara", 5);

//Productores pantallas
        Productor1 productor9 = new Productor1("p1", "pantalla", 3);
        Productor1 productor10 = new Productor1("p2", "pantalla", 3);

        //productores botones
        Productor1 productor11 = new Productor1("b1", "botones", 4);
        Productor1 productor12 = new Productor1("b2", "botones", 4);
        Productor1 productor13 = new Productor1("b3", "botones", 4);
        Productor1 productor14 = new Productor1("b4", "botones", 4);

        //Productores pin de carga
        Productor1 productor15 = new Productor1("pc1", "pin", 5);
        Productor1 productor16 = new Productor1("pc2", "pin", 5);

        //Ensamblador
        Ensamblador1 ensamblador1 = new Ensamblador1(6, "e1");
        Ensamblador1 ensamblador2 = new Ensamblador1(6, "e2");
        Ensamblador1 ensamblador3 = new Ensamblador1(6, "e3");
        Ensamblador1 ensamblador4 = new Ensamblador1(6, "e4");

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
        jefe1.start();
        gerente1.start();

    }

}
