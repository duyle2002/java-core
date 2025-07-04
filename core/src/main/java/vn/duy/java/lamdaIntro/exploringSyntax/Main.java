package vn.duy.java.lamdaIntro.exploringSyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        list.forEach((s) -> System.out.println(s));

        list.forEach((s) -> {
            System.out.println(s.toUpperCase());
        });

        String prefix = "Hello";
        list.forEach((s) -> {
            System.out.println(prefix + " " + s);
        });
    }
}
