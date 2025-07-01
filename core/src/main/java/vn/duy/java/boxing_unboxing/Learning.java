package vn.duy.java.boxing_unboxing;

import java.util.ArrayList;
import java.util.Arrays;

public class Learning {
    public static void main(String[] args) {
        Integer intObj = 10;
        System.out.println(intObj.getClass().getName());

        // unboxing
        int intPrimitive = intObj;

        ArrayList<Integer> objArray = new ArrayList<>();
        objArray.add(1);
        objArray.add(2);
        System.out.println(objArray);

        Integer[] intArray = new Integer[objArray.size()];
        intArray[0] = 1;
        intArray[1] = 2;
        System.out.println(Arrays.toString(objArray.toArray()));
    }
}
