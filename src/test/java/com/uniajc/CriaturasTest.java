package com.uniajc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class CriaturasTest {

    @Test
    void dragonAtacaConElDobleDeSuFuerza() {
        Dragon dragon = new Dragon("Draco", 100, 10, "normales");
        Guerrero objetivo = new Guerrero("Ares", 100, 5, "hacha");

        dragon.atacar(objetivo);

        assertEquals(80, objetivo.getSalud());
    }

    @Test
    void escamasGruesasReducenElDañoALaMitad() {
        Dragon dragon = new Dragon("Draco", 100, 10, "gruesas");

        dragon.defender(20);

        assertEquals(90, dragon.getSalud());
    }

    @Test
    void magoConFuegoAumentaElDañoDeSuAtaque() {
        Mago mago = new Mago("Merlin", 100, 10, "fuego");
        Guerrero objetivo = new Guerrero("Ares", 100, 5, "hacha");

        mago.atacar(objetivo);

        assertEquals(85, objetivo.getSalud());
    }

    @Test
    void magoConEscudoReduceElDañoALaMitad() {
        Mago mago = new Mago("Merlin", 100, 10, "escudo");

        mago.defender(20);

        assertEquals(90, mago.getSalud());
    }

    @Test
    void guerreroConEspadaAumentaElDañoDeSuAtaque() {
        Guerrero guerrero = new Guerrero("Ares", 100, 10, "espada");
        Mago objetivo = new Mago("Merlin", 100, 5, "hielo");

        guerrero.atacar(objetivo);

        assertEquals(85, objetivo.getSalud());
    }

    @Test
    void guerreroConEscudoReduceElDañoALaMitad() {
        Guerrero guerrero = new Guerrero("Ares", 100, 10, "escudo");

        guerrero.defender(20);

        assertEquals(90, guerrero.getSalud());
    }

    @Test
    void saludNoPuedeQuedarPorDebajoDeCero() {
        Dragon dragon = new Dragon("Draco", 10, 5, "normales");

        dragon.defender(20);

        assertEquals(0, dragon.getSalud());
        assertFalse(dragon.estaViva());
    }

    @Test
    void criaturaConSaludPositivaSigueViva() {
        Mago mago = new Mago("Merlin", 1, 5, "fuego");

        assertTrue(mago.estaViva());
    }

    @Test
    void batallaMuestraElGanadorYTerminaCuandoUnaCriaturaMuere() {
        Dragon dragon = new Dragon("Draco", 100, 10, "gruesas");
        Mago mago = new Mago("Merlin", 5, 1, "fuego");
        PrintStream salidaOriginal = System.out;
        ByteArrayOutputStream salida = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(salida, true, StandardCharsets.UTF_8));
            Main.simularBatalla(dragon, mago);
        } finally {
            System.setOut(salidaOriginal);
        }

        assertFalse(mago.estaViva());
        assertTrue(salida.toString(StandardCharsets.UTF_8).contains("Ganador: Draco"));
    }
}
