
package com.uniajc;
 
public class Dragon extends Criatura {
 
    private String escamas;
 
    public Dragon() {
        super();
    }
 
    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }
 
    @Override
    public void atacar(Criatura objetivo) {
        int dañoTotal = this.fuerza * 2;
        System.out.println(this.nombre + " (Dragón) lanza aliento de fuego a " + objetivo.getNombre()
                + " con un poder de " + dañoTotal + "!");
        objetivo.defender(dañoTotal);
    }
 
    @Override
    public void defender(int daño) {
        int dañoReal = daño;
 
        if (this.escamas != null && this.escamas.equalsIgnoreCase("gruesas")) {
            dañoReal = daño / 2; // las escamas reducen el daño
        }
 
        this.salud -= dañoReal;
 
        if (this.salud < 0) {
            this.salud = 0;
        }
 
        System.out.println(this.nombre + " recibe " + dañoReal + " de daño. Salud actual: " + this.salud);
    }
 
    public String getEscamas() {
        return escamas;
    }
 
    public void setEscamas(String escamas) {
        this.escamas = escamas;
    }
}