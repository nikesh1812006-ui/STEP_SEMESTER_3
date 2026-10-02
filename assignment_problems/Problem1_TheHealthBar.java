/**
 * Problem 1: The Health Bar
 * Category C - Week 7 Assignment Problem
 *
 * Requirements:
 * - Health must be private, changed only through takeDamage(int amount) and heal(int amount).
 * - Health must never go below 0 (floored at 0) or above maximum (capped at maxHealth).
 * - Maximum health must be final, fixed when the character is created.
 * - Provide a read-only way to check current health (no setter).
 */
public class Problem1_TheHealthBar {

    public static class Character {
        private final int maxHealth;
        private int currentHealth;

        public Character(int maxHealth) {
            this.maxHealth = Math.max(1, maxHealth);
            this.currentHealth = this.maxHealth;
        }

        public int getMaxHealth() {
            return maxHealth;
        }

        public int getHealth() {
            return currentHealth;
        }

        public void takeDamage(int amount) {
            if (amount <= 0) return;
            currentHealth = Math.max(0, currentHealth - amount);
            System.out.printf("Took %d damage -> current health = %d%s%n",
                    amount, currentHealth, (currentHealth == 0 ? " (floored at 0)" : ""));
        }

        public void heal(int amount) {
            if (amount <= 0) return;
            currentHealth = Math.min(maxHealth, currentHealth + amount);
            System.out.printf("Healed %d -> current health = %d%s%n",
                    amount, currentHealth, (currentHealth == maxHealth ? " (capped at max)" : ""));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Health Bar ===");
        Character c = new Character(100);
        System.out.println("Initial Health: " + c.getHealth());

        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
        System.out.println("Final Health: " + c.getHealth());
    }
}
