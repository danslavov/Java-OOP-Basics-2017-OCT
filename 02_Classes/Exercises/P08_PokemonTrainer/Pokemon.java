package Exercises.P08_PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return this.element;
    }

    public int getHealth() {
        return this.health;
    }

    public void loseHealth() {
        this.health -= 10;
    }
}
