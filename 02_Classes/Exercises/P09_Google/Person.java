package Exercises.P09_Google;

import java.util.LinkedHashSet;
import java.util.Set;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private Set<Creature> parents;
    private Set<Creature> children;
    private Set<Creature> pokemons;
    // or maps to update elements values?

    public Person(String name) {
        this.name = name;
        this.company = new Company();
        this.car = new Car();
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
        this.pokemons = new LinkedHashSet<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addParent(Creature parent) {
        this.parents.add(parent);
    }

    public void addChild(Creature child) {
        this.children.add(child);
    }

    public void addPokemon(Creature pokemon) {
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        return String.format("%s%nCompany:%n%sCar:%n%sPokemon:%n%sParents:%n%sChildren:%n%s",
                name, company, car, listCreatures(pokemons), listCreatures(parents), listCreatures(children));
    }

    private StringBuilder listCreatures(Set<Creature> creatures) {
        StringBuilder result = new StringBuilder();
        if (creatures.size() > 0) {
            for (Creature creature : creatures) {
                result.append(creature).append(System.lineSeparator());
            }
        }
        return result;
    }
}
