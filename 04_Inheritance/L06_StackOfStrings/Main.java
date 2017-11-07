package L06_StackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings myStackOfStrings = new StackOfStrings();
        myStackOfStrings.push("String");
        myStackOfStrings.push("utf");
        myStackOfStrings.push("rofl");
        myStackOfStrings.push("imhao");
        myStackOfStrings.push("omg");
        myStackOfStrings.push("end");
        System.out.println(myStackOfStrings.isEmpty());
        System.out.println(myStackOfStrings.peek());
        System.out.println(myStackOfStrings.pop());
        System.out.println(myStackOfStrings.pop());
    }
}
