package vn.duy.java.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {
    public static void main(String[] args) {
        int[] array = readIntegers();
        System.out.println("Original array: " + Arrays.toString(array));

        int minimumElement = findMin(array);
        System.out.println("Minimum element is: " + minimumElement);
    }
    public static int[] readIntegers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a length: ");
        int length = sc.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

}
