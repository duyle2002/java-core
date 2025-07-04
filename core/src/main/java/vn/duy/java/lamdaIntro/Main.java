package vn.duy.java.lamdaIntro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return "%s %s".formatted(firstName, lastName);
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(
                Arrays.asList(
                        new Person("Le", "Duy"),
                        new Person("Hoang", "Duy"),
                        new Person("Shanghai", "Shanghai"),
                        new Person("Jia", "Ken")
                )
        );

        // sort by anonymous class
        var c1 = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.lastName.compareTo(p2.lastName);
            }
        };
        people.sort(c1);
        System.out.println(people);

        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        });

        System.out.println(people);

        // lamda expression
        people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        System.out.println(people);

        var enhanceComparator = new EnhanceComparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int lastNameCompareResult = o1.lastName.compareTo(o2.lastName);
                return lastNameCompareResult == 0 ? sortAdvanced(o1, o2) :  lastNameCompareResult;
            }

            @Override
            public int sortAdvanced(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };

        people.sort(enhanceComparator);
        System.out.println(people);

        people.removeIf(p -> p.lastName.equalsIgnoreCase("Duy"));
        System.out.println(people);
    }

    interface EnhanceComparator<T extends Person> extends Comparator<T> {
        int sortAdvanced(T o1, T o2);
    }
}
