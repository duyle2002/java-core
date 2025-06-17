package vn.duy.java.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreList {
    public static void main(String[] args) {
        String[] stringArr = { "orange", "milk", "apple", "banana" };
        List<String> list = List.of(stringArr);
        System.out.println("String Array: " + list);

//        list.add("orange"); -> compile error because list is ImmutableCollection instance
        List<String> list2 = new ArrayList<>(list);
        System.out.println("String ArrayList: " + list2);
        list2.add("cafe");
        System.out.println("String ArrayList: " + list2);

        list2.addAll(List.of("cake", "candy"));
        System.out.println("String ArrayList: " + list2);

        System.out.println("Third item: " + list2.get(2));
        if (list2.contains("candy")) {
            System.out.println("List contains candy");
        } else {
            System.out.println("List does not contain candy");
        }

        list2.add("yogurt");
        System.out.println("first = " + list2.indexOf("yogurt"));
        System.out.println("last = " + list2.lastIndexOf("yogurt"));

        System.out.println(list2);
        list2.remove("candy");
        System.out.println(list2);
        list2.add("yogurt");
        System.out.println(list2);
        list2.remove("yogurt"); // -> only return single element
        System.out.println(list2);

        list2.removeAll(List.of("yogurt"));
        System.out.println(list2);

        list2.clear();
        System.out.println("is empty: " + list2.isEmpty());

        list2.addAll(Arrays.asList(stringArr));
        System.out.println(list2);

        list2.sort(new StringComparator());
        System.out.println(list2);

        list2.sort(Comparator.naturalOrder());
        System.out.println(list2);

        list2.sort(Comparator.reverseOrder());
        System.out.println(list2);
    }
}
class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}