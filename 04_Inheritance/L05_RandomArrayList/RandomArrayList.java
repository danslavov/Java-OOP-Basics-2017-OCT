package L05_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private Random rnd;

    RandomArrayList() {
        rnd = new Random();
    }

    public Object getRandomElement() {
        int index = this.rnd.nextInt(super.size());
        Object result = super.get(index);
        super.set(index, super.get(super.size() - 1));
        super.remove(super.size() - 1);
        return result;
    }
}
