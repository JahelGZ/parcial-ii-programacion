package com.uniajc;

public class Main {

    public static void simularBatalla(Criatura atacante, Criatura defensor) {
        int turno = 1;

        System.out.println("\n========================================");
        System.out.println("BATALLA: " + atacante.getNombre() + " VS " + defensor.getNombre());
        System.out.println("========================================");

        // La batalla continua mientras ambas criaturas sigan vivas.
        while (atacante.estaViva() && defensor.estaViva()) {
            System.out.println("\nTurno " + turno + ":");

            atacante.atacar(defensor);

            if (!defensor.estaViva()) {
                break;
            }

            defensor.atacar(atacante);
            turno++;
        }

        System.out.println("\nRESULTADO FINAL");
        if (atacante.estaViva() && !defensor.estaViva()) {
            System.out.println("Ganador: " + atacante.getNombre());
        } else if (defensor.estaViva() && !atacante.estaViva()) {
            System.out.println("Ganador: " + defensor.getNombre());
        } else {
            System.out.println("La batalla termina en empate.");
        }

        System.out.println(atacante.getNombre() + " -> Salud: " + atacante.getSalud());
        System.out.println(defensor.getNombre() + " -> Salud: " + defensor.getSalud());
        System.out.println("========================================\n");
    }

    public static void main(String[] args) {
        Dragon dragon = new Dragon("Draco", 120, 18, "gruesas");
        Mago mago = new Mago("Merlin", 90, 12, "fuego");
        Guerrero guerrero = new Guerrero("Ares", 100, 15, "espada");

        simularBatalla(dragon, mago);
        simularBatalla(guerrero, dragon);
    }
}