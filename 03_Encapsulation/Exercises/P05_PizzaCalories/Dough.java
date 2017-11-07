package Exercises.P05_PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!"White".equals(flourType) && !"Wholegrain".equals(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!"Crispy".equals(bakingTechnique) && !"Chewy".equals(bakingTechnique)
                && !"Homemade".equals(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private double calculateFlourCalories() {
        if ("White".equals(this.flourType)) {
            return 1.5;
        } else {
            return 1.0;
        }
    }

    private double calculateBakingCalories() {
        if ("Crispy".equals(this.bakingTechnique)) {
            return 0.9;
        } else if ("Chewy".equals(this.bakingTechnique)) {
            return 1.1;
        } else {
            return 1.0;
        }
    }

    public double calculateCalories() {
        return 2.0 * this.weight * calculateFlourCalories() * calculateBakingCalories();
    }
}
