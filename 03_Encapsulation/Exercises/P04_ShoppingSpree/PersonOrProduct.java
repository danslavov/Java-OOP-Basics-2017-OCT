package Exercises.P04_ShoppingSpree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PersonOrProduct {
    private String name;
    private int money;
    private List<PersonOrProduct> products;

    PersonOrProduct(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new LinkedList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getMoney() {
        return this.money;
    }

    private void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<PersonOrProduct> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    public void buyProduct(PersonOrProduct product) {
        if (this.getMoney() < product.getMoney()) {
            throw new IllegalStateException(this.getName() + " can't afford " + product.getName());
        }
        this.setMoney(this.getMoney() - product.getMoney());
        this.products.add(product);
    }
}
