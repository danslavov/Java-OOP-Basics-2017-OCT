package Exercises.P08_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badgeCount;
    private List<Pokemon> pokemons;

    Trainer(String name) {
        this.name = name;
        this.badgeCount = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getBadgeCount() {
        return this.badgeCount;
    }

    public int getPokemonCount() {
        return this.pokemons.size();
    }   // not needed

    public void putPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void incrementBadgeCount() {
        this.badgeCount++;
    }

    public void checkIfElementIsPresent(String element) {
        boolean isAbsent = true;
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)) {
                incrementBadgeCount();
                isAbsent = false;
                break;
            }
        }
        if (isAbsent) {
            for (int i = 0; i < pokemons.size(); i++) {
                Pokemon currentPokemon = pokemons.get(i);
                currentPokemon.loseHealth();
                if(currentPokemon.getHealth() <= 0) {
                    this.pokemons.remove(currentPokemon);
                    i--;
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.badgeCount + " " + this.pokemons.size();
    }
}
