package vn.duy.java.arrays;

import java.util.Arrays;
import java.util.Random;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = randomArray(10);
        System.out.println("Original array: " + Arrays.toString(array));
        reverseArray(array);
        System.out.println("Reversed array: " + Arrays.toString(array));
    }

    public static void reverseArray(int[] arr) {
        int positionTemp = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, positionTemp);
            positionTemp--;
        }
    }

    public static int[] randomArray(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
