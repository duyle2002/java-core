package vn.duy.java.nestedClass.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {
    public static void main(String[] args) {
        List<StoreEmployee> storeEmployees = new ArrayList<>(
                List.of(
                        new StoreEmployee("1", "Duy", 2025, "A"),
                        new StoreEmployee("2", "Quan", 2020, "A"),
                        new StoreEmployee("3", "an", 2019, "B"),
                        new StoreEmployee("4", "Tuan", 2023, "C")
                )
        );

        EmployeeComparator<Employee> c1 = new EmployeeComparator<>();
        var c2 = new Employee.EmployeeComparator<>();
        var c3 = new StoreEmployee().new StoreEmployeeComparator<>();

        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);
        sortIt(storeEmployees, c3);

        // local class
        class NameSort<T extends StoreEmployee> implements Comparator<T> {
            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }

        var c4 = new NameSort<>();
        sortIt(storeEmployees, c4);

        // anonymous class
        var c5 = new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortIt(storeEmployees, c5);

        sortIt(storeEmployees, new Comparator<>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static <T> void sortIt(List<T> list,
                             Comparator<? super T> comparator) {
        System.out.println("Sorting with comparator: " + comparator.toString());

        list.sort(comparator);
        for (T t : list) {
            System.out.println(t);
        }
    }
}
