package com.factoriaf5.kata;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Character closeCharacter;
    private Character distanceCharacter;

    @BeforeEach
    public void setUp() {
        closeCharacter = new MinDistance(); 
        distanceCharacter = new MaxDistance();  
    }

    
    @Test
    public void testInitialState() {
        // Comprobamos el estado inicial de los personajes
        assertEquals("Personaje{salud=1000, nivel=1, vida=true, rango de ataque=2}", closeCharacter.toString());
        assertEquals("Personaje{salud=1000, nivel=1, vida=true, rango de ataque=20}", distanceCharacter.toString());
    }

    @Test
    public void testAttackOutOfRange() {
        // closeCharacter intenta atacar a distanceCharacter que está fuera de su alcance
        closeCharacter.attack(distanceCharacter, 100, 10);
        // Se espera que se imprima "El enemigo esta fuera de tu alcance"
    }

    @Test
    public void testAttackWithinRange() {
        // distanceCharacter intenta atacar a closeCharacter dentro de su alcance
        distanceCharacter.attack(closeCharacter, 100, 10);
        // Se espera que se imprima "Daño: 100 Salud del enemigo: 900"
    }

    @Test
    public void testAttackWithMaxDistance() {
        // distanceCharacter intenta atacar a closeCharacter en su máximo rango
        distanceCharacter.attack(closeCharacter, 100, 15);
        // Se espera que se imprima "Daño: 100 Salud del enemigo: 900"
    }

    @Test
    public void testAttackWithMinDistance() {
        closeCharacter.attack(distanceCharacter, 100, 5);
    }

    @Test
    public void testAttackWhenTargetIsDead() {
        closeCharacter.life = false;
        distanceCharacter.attack(closeCharacter, 100, 10);
    }

    @Test
    public void testToString() {
        assertEquals("Personaje{salud=1000, nivel=1, vida=true, rango de ataque=2}", closeCharacter.toString());
        assertEquals("Personaje{salud=1000, nivel=1, vida=true, rango de ataque=20}", distanceCharacter.toString());
    }

    


}
