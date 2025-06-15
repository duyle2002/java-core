package vn.duy.java.arrays;

public class ArrayVarArgs {
    public static void main(String[] args) {
        printText("Hello World");
        printText(new String[] { "Hello", "World" });
    }

    public static void printText(String... texts) {
        for (String text : texts) {
            System.out.println(" " + text);
        }
    }
}
