package com.uniajc;

public abstract class Criatura {

    //atributos protegidos
    protected String nombre;
    protected int salud;
    protected int fuerza;    

    //Constructores
    public Criatura() {}

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    //Metodo abstracto atacar
    public abstract void atacar(Criatura objetivo);

    //Metodo abstracto daño
    public abstract void defender(int daño);

    //Metodo concreto
    public boolean estaViva() {
        return this.salud > 0;
    }
    //Getters and Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getSalud() {
        return salud;
    }
    public void setSalud(int salud) {
        this.salud = salud;
    }
    public int getFuerza() {
        return fuerza;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
}
