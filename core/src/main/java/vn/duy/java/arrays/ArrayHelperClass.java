package vn.duy.java.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ArrayHelperClass {
    public static void main(String[] args) {
        int[] firstArray = getRandomArray(10);
        System.out.println("first array: " + Arrays.toString(firstArray));

        Arrays.sort(firstArray); // primitive array -> quick sort, object array -> merge sort
        System.out.println("first array after sorting: " + Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        Arrays.fill(secondArray, 10);
        System.out.println(Arrays.toString(secondArray));

        // copy
        int[] thirdArray = getRandomArray(10);
        System.out.println("third array: " +  Arrays.toString(thirdArray));

        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println("fourth array: " + Arrays.toString(fourthArray));

        int[] smallerArray = Arrays.copyOf(thirdArray, 5);
        System.out.println("smaller array: " + Arrays.toString(smallerArray));

        int[] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println("larger array: " + Arrays.toString(largerArray));

        // binary search
        String[] sArray = { "one", "two", "three", "four", "five" };
        Arrays.sort(sArray);
        if (Arrays.binarySearch(sArray, "two") >= 0) {
            System.out.println("Found two in the array");
        }

        // arrays are equal if they have the same length and all the elements at the same position are equal
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 3, 4, 5 };
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }
    }

    private static int[] getRandomArray(int length) {
        Random random = new Random();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100);
        }

        return arr;
    }
}
