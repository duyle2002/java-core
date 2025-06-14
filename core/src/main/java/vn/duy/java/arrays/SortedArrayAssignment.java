package vn.duy.java.arrays;

import java.util.Arrays;
import java.util.Random;

public class SortedArrayAssignment {
    public static void main(String[] args) {
        int[] array = getIntegers(10);

        int[] sortedArray = sortIntegers(array);

        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] getIntegers(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
        Arrays.sort(array);

        int[] descSortedArray = new int[array.length];
        int tempPosition = array.length - 1;

        for (int i = 0; i < descSortedArray.length; i++) {
            descSortedArray[i] = array[tempPosition];
            tempPosition--;
        }
        return descSortedArray;
    }
}
