package com.uniajc;
 
public class Guerrero extends Criatura {
 
    private String arma;
 
    public Guerrero() {
        super();
    }
 
    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }
 
    @Override
    public void atacar(Criatura objetivo) {
        int dañoTotal = this.fuerza + 2;
 
        if (this.arma != null && this.arma.equalsIgnoreCase("espada")) {
            dañoTotal += 3;
        }
 
        System.out.println(this.nombre + " (Guerrero) ataca con " + this.arma + " a "
                + objetivo.getNombre() + " y causa " + dañoTotal + " de daño.");
        objetivo.defender(dañoTotal);
    }
 
    @Override
    public void defender(int daño) {
        int dañoReal = daño;
 
        if (this.arma != null && this.arma.equalsIgnoreCase("escudo")) {
            dañoReal = daño / 2;
        }
 
        this.salud -= dañoReal;
 
        if (this.salud < 0) {
            this.salud = 0;
        }
 
        System.out.println(this.nombre + " recibe " + dañoReal + " de daño. Salud actual: " + this.salud);
    }
 
    public String getArma() {
        return arma;
    }
 
    public void setArma(String arma) {
        this.arma = arma;
    }
}