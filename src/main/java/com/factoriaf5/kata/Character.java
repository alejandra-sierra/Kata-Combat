package com.factoriaf5.kata;

public class Character {
        protected int health;
        protected int level;
        protected boolean life;
        protected int attackRange; 
    
        public Character(int attackRange) {
            this.health = 1000;
            this.level = 1;
            this.life = true;
            this.attackRange = attackRange;
        }
    
        public void attack(Character target, int damage, int distance) {
            if (target == null || target == this || !target.life) {
                System.out.println("No se puede atacar");
                return;
            }
    
            if (distance > this.attackRange) {
                System.out.println("El enemigo esta fuera de tu alcance");
                return;
            }
    
            if (target.level >= this.level + 5) {
                damage /= 2;
            } else if (this.level >= target.level + 5) {
                damage = (int) (damage * 1.5);
            }
    
            target.health -= damage;
    
            if (target.health <= 0) {
                target.health = 0;
                target.life = false;
                System.out.println("Enemigo muerto");
            } else {
                System.out.println("Daño: " + damage + " Salud del enemigo: " + target.health);
            }
        }
    
        public void heal(int amount) {
            if (!this.life) {
                System.out.println("Has muerto");
                return;
            }
            this.health = Math.min(this.health + amount, 1000);
            System.out.println("Te has curado. Ahora tu energia es: " + this.health);
        }
    
        @Override
        public String toString() {
            return "Personaje{" +
                    "salud=" + health +
                    ", nivel=" + level +
                    ", vida=" + life +
                    ", rango de ataque=" + attackRange +
                    '}';
        }
    }
    

