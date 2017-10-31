package Exercises;

import java.lang.reflect.Field;

public class P01_DefineClassPerson {
    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}
