package com.factoriaf5.kata;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    private Character character1;
    private Character character2;
    
    @BeforeEach
    public void setUp() {
        character1 = new Character(10); 
        character2 = new Character(5);   
    }

    @Test
    public void testAttackWhenTargetIsNull() {
        character1.attack(null, 50, 5);
    }

    @Test
    public void testAttackWhenAttackingSelf() {
        character1.attack(character1, 50, 5);
    }

    @Test
    public void testAttackWhenTargetIsDead() {
        character2.life = false;
        character1.attack(character2, 50, 5);
    }

    @Test
    public void testAttackOutOfRange() {
        character1.attack(character2, 50, 15);
    }

    @Test
    public void testAttackWithinRange() {
        character1.attack(character2, 50, 5);
    }

    @Test
    public void testAttackWithLevelDifference() {
        character2.level = 6;  
        character1.attack(character2, 50, 5);  
    }

    @Test
    public void testAttackWithLevelAdvantage() {
        character1.level = 6;  
        character1.attack(character2, 50, 5);  
    }

    @Test
    public void testHealWhenAlive() {
        character1.heal(100);
        assertEquals(1000, character1.health); 
    }

    @Test
    public void testHealWhenDead() {
        character1.life = false;
        character1.heal(100);
    }

    @Test
    public void testCharacterToString() {
        String expected = "Personaje{salud=1000, nivel=1, vida=true, rango de ataque=10}";
        assertEquals(expected, character1.toString());
    }
}
