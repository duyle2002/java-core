package vn.duy.java.linkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListLearning {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        placesToVisit.add("London");
        placesToVisit.add("New York");
        placesToVisit.add("Paris");

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);
//        gettingElements(placesToVisit);
//        printItinerary(placesToVisit);
//        printItinerary2(placesToVisit);
//        printItinerary3(placesToVisit);

        testIterator(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list) {
        list.add("Viet Nam");
        list.add("San Francisco");

        // Queue methods
        list.offer("China");
        list.offerFirst("France");
        list.offerLast("Germany");

        // stack methods
        list.push("Spain");

    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        System.out.println(list);

        list.remove("China");
        System.out.println(list);


        String s1 = list.remove();
        System.out.println(s1 + " was removed");
        System.out.println(list);


        String s2 = list.removeFirst();
        System.out.println(s2 + " was removed");
        System.out.println(list);


        String s3 = list.removeLast();
        System.out.println(s3 + " was removed");
        System.out.println(list);


        // queue methods
        String q1 = list.poll(); // remove first element
        System.out.println(q1 + " was removed");
        System.out.println(list);

        String q2 = list.pollFirst(); // remove first element
        System.out.println(q2 + " was removed");
        System.out.println(list);

        String q3 = list.pollLast(); // remove last element
        System.out.println(q3 + " was removed");
        System.out.println(list);

        // stack methods
        list.push("Taiwan");
        list.push("Korean");

        String p4 = list.pop();
        System.out.println(p4 + " was removed");

    }

    private static void gettingElements(LinkedList<String> list) {
        System.out.println("Retrieved element = " + list.get(4));

        System.out.println("First element = " + list.getFirst());

        System.out.println("Last element = " + list.getLast());

        System.out.println("Viet Nam is at position: " + list.indexOf("Viet Nam"));

        // Queue methods
        System.out.println("Element from element(): " + list.element()); // return the first element

        // Stack
        System.out.println("Element from peek(): " + list.peek());
        System.out.println("Element from peekFirst(): " + list.peekFirst());
        System.out.println("Element from peekLast(): " + list.peekLast());
    }

    public static void printItinerary(LinkedList<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println("From: " + list.get(i) + " to: " + list.get(i + 1));
        }
        System.out.println("End at: " + list.getLast());
    }

    private static void printItinerary2(LinkedList<String> list) {
        String first = list.getFirst();
        for (String element : list) {
            System.out.println("From: " + first + " to: " + element);
        }
        System.out.println("End at: " + list.getLast());
    }

    private static void printItinerary3(LinkedList<String> list) {
        String fromPlace = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("From: " + fromPlace + " to: " + next);
            fromPlace = next;
        }
        System.out.println("End at: " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list) {
        /*
        When the iterator is created, the cursor position will be point at the position before the first element
         */
        var iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().equalsIgnoreCase("China")) {
                iterator.add("Thailand");
            }
        }
        System.out.println(list);
    }
}
