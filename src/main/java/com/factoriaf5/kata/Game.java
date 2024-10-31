package com.factoriaf5.kata;

public class Game {
    public static void main(String[] args) {
        Character closeCharacter = new MinDistance();
        Character distanceCharacter = new MaxDistance();
    
        System.out.println("Initial state:");
        System.out.println(closeCharacter);
        System.out.println(distanceCharacter);
    
        System.out.println("fuera de alcance:");
        closeCharacter.attack(distanceCharacter, 100, 5);
    
        System.out.println("distancia para ataque");
        distanceCharacter.attack(closeCharacter, 100, 15);
        System.out.println("Final :");
        System.out.println(closeCharacter);
        System.out.println(distanceCharacter);
        }
    }
    

