package vn.duy.java.arrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myIntArray = new int[10];
        myIntArray[5] = 50;

        int[] anotherArray = new int[] {1, 2, 3, 4, 5};

        String[] myFavouriteFlowers  = { "1", "2", "3", "4", "5" };
        System.out.println(Arrays.toString(myIntArray));

        // looping
        int[] newArray = new int[5];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = newArray.length - i;
        }

        // for loop
        for (int i : newArray) {
            System.out.println("i: " + i);
        }

        System.out.println(Arrays.toString(newArray)); // [5, 4, 3, 2, 1]

        Object objectVariable = newArray;

        if (objectVariable instanceof int[]) {
            System.out.println("objectVariable is an instance of int[]");
        }

        Object[] objects = new Object[3];
        objects[0] = "Hello";
        objects[1] = new String("World");
        objects[2] = newArray;
    }
}
