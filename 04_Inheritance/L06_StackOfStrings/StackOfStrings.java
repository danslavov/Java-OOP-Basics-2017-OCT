package L06_StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String el) {
        this.data.add(el);
    }

    public String pop() {
        return this.data.remove(this.data.size() - 1);
    }

    public String peek() {
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
