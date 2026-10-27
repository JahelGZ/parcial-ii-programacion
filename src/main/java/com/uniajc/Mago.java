
package com.uniajc;
 
public class Mago extends Criatura {
 
    private String hechizo;
 
    public Mago() {
        super();
    }
 
    public Mago(String nombre, int salud, int fuerza, String hechizo) {
        super(nombre, salud, fuerza);
        this.hechizo = hechizo;
    }
 
    @Override
    public void atacar(Criatura objetivo) {
        int dañoTotal = this.fuerza + 3;
 
        if (this.hechizo != null && this.hechizo.equalsIgnoreCase("fuego")) {
            dañoTotal += 2;
        }
 
        System.out.println(this.nombre + " (Mago) lanza " + this.hechizo + " a " + objetivo.getNombre()
                + " y causa " + dañoTotal + " de daño.");
        objetivo.defender(dañoTotal);
    }
 
    @Override
    public void defender(int daño) {
        int dañoReal = daño;
 
        if (this.hechizo != null && this.hechizo.equalsIgnoreCase("escudo")) {
            dañoReal = daño / 2;
        }
 
        this.salud -= dañoReal;
 
        if (this.salud < 0) {
            this.salud = 0;
        }
 
        System.out.println(this.nombre + " recibe " + dañoReal + " de daño. Salud actual: " + this.salud);
    }
 
    public String getHechizo() {
        return hechizo;
    }
 
    public void setHechizo(String hechizo) {
        this.hechizo = hechizo;
    }
}