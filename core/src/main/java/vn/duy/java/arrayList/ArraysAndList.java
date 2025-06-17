package vn.duy.java.arrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysAndList {
    public static void main(String[] args) {
        String[] array = { "a", "c", "b" };
        List<String> list = List.of(array); // -> immutable, can not add, remove, sort
        System.out.println(list);

        List<String> arrayList = Arrays.asList(array); // -> is not resizeable (can not add, remove), mutable (sortable)
        System.out.println(arrayList);
//        arrayList.add("d"); -> compile error
        arrayList.sort(Comparator.naturalOrder());
        System.out.println(arrayList);
    }
}
