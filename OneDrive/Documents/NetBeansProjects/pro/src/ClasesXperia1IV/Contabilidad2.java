/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesXperia1IV;

/**
 *
 * @author AROMERO
 */
public class Contabilidad2 {

    private double salariosProd;
    private double salariosEns;
    private double salarioGer;
    private double salarioJefe;
    private double costos;
    private double ventas;
    private double ganancia;

    public Contabilidad2() {
        this.salariosProd = 0;
        this.salariosEns = 0;
        this.salarioGer = 0;
        this.salarioJefe = 0;
        this.ventas = 0;
        this.costos = 0;
        this.ganancia = 0;
    }

    public double getCostos() {
        return costos;
    }

    public void setCostos(double costos) {
        this.costos = costos;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public void calculoSalarios() {
        int salariosTotalesProd = Test2.cantidadPCamara * 5 * 24 * 30;
        salariosTotalesProd += Test2.cantidadPPin * 5 * 24 * 30;
        salariosTotalesProd += Test2.cantidadPPantalla * 3 * 24 * 30;
        salariosTotalesProd += Test2.cantidadPbotones * 4 * 24 * 30;
        this.setSalariosProd(salariosTotalesProd);
        int salariosTotalesEn = Test2.cantidadEnsambladores * 6 * 24 * 30;
        this.setSalariosEns(salariosTotalesEn);
        this.setSalarioGer(180 * 30);
        this.setSalarioJefe(7 * 24 * 30 - Test2.gerente2.getDescuento());
        this.setCostos(this.getSalarioGer() + this.getSalarioJefe() + this.getSalariosEns() + this.getSalariosProd());

    }

    /**
     * @return the salariosProd
     */
    public double getSalariosProd() {
        return salariosProd;
    }

    /**
     * @param salariosProd the salariosProd to set
     */
    public void setSalariosProd(double salariosProd) {
        this.salariosProd = salariosProd;
    }

    /**
     * @return the salariosEns
     */
    public double getSalariosEns() {
        return salariosEns;
    }

    /**
     * @param salariosEns the salariosEns to set
     */
    public void setSalariosEns(double salariosEns) {
        this.salariosEns = salariosEns;
    }

    /**
     * @return the salarioGer
     */
    public double getSalarioGer() {
        return salarioGer;
    }

    /**
     * @param salarioGer the salarioGer to set
     */
    public void setSalarioGer(double salarioGer) {
        this.salarioGer = salarioGer;
    }

    /**
     * @return the salarioJefe
     */
    public double getSalarioJefe() {
        return salarioJefe;
    }

    /**
     * @param salarioJefe the salarioJefe to set
     */
    public void setSalarioJefe(double salarioJefe) {
        this.salarioJefe = salarioJefe;
    }

    /**
     * @return the ventas
     */
    public double getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

}
