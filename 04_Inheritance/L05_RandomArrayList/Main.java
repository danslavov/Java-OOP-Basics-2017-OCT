package L05_RandomArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RandomArrayList ral = new RandomArrayList();
        ral.addAll(Arrays.asList("Haha", 5, new Object(), 'd'));
        while (ral.size() != 0) {
            System.out.println(ral.getRandomElement());
        }
    }
}
