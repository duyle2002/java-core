package vn.duy.java.arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraySortNumberDescending {
    public static void main(String[] args) {
        int[] array = getRandomArray(10);
        Arrays.sort(array);
        System.out.println("Array before sorting: " + Arrays.toString(array));

//        int[] sortedArray = sortDescending(array);
//        System.out.println("Array after sorting: " + Arrays.toString(sortedArray));

//        int[] sortedArray = sortDescendingOther(array);
//        System.out.println("Array after sorting: " + Arrays.toString(sortedArray));

          int[] sortedArray = sortDescendingThirdSolution(array);
          System.out.println("Array after sorting: " + Arrays.toString(sortedArray));
    }

    private static int[] getRandomArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    private static int[] sortDescending(int[] array) {
        int[] sortedArray = new int[array.length];
        int positionTemp = sortedArray.length - 1;
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = array[positionTemp];
            positionTemp--;
        }
        return sortedArray;
    }

    private static int[] sortDescendingOther(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        int temp;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    swap(sortedArray, i, i + 1);
                    flag = true;
                }
            }
            System.out.println("-----> " + Arrays.toString(sortedArray));
        }
        return sortedArray;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int[] sortDescendingThirdSolution(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        int tempPosition = sortedArray.length - 1;
        for (int i = 0; i < sortedArray.length / 2; i++) {
            swap(sortedArray, i, tempPosition);
            tempPosition--;
        }
        return sortedArray;
    }
}
