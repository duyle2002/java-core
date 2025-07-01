package vn.duy.java.linkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

record Place(String name, int distance) {
    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }
}

public class ChallengeLinkedList {
    public static void main(String[] args) {
        List<Place> placesToVisit = new LinkedList<>();
        addPlace(placesToVisit, new Place("SaiGon", 4000));
        addPlace(placesToVisit, new Place("HaNoi", 3000));
        addPlace(placesToVisit, new Place("TP Hue", 200));
        placesToVisit.addFirst(new Place("Da Nang", 0));

        menu();
        Scanner sc = new Scanner(System.in);
        ListIterator<Place> listIterator = placesToVisit.listIterator();
        boolean forward = true;
        boolean quit = false;
        while (!quit) {
            String option = sc.nextLine().toUpperCase().substring(0,1);
            if (!listIterator.hasPrevious()) {
                System.out.println("Starting from: " + listIterator.next());
            }
            if (!listIterator.hasNext()) {
                System.out.println("Ending at: " + listIterator.previous());
                forward = false;
            }
            switch (option) {
                case "F": {
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Forward to " + listIterator.next());
                    }
                    break;
                }
                case "B": {
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Back to " + listIterator.previous());
                    }
                    break;
                }
                case "L": {
                    System.out.println(placesToVisit);
                    break;
                }
                case "M": {
                    menu();
                    break;
                }
                default: {
                    quit = true;
                    break;
                }
            }
        }
    }

    public static void menu() {
        System.out.println("Available actions (select word or letter)");
        System.out.println("(F)orward");
        System.out.println("(B)ackward");
        System.out.println("(L)ist Places");
        System.out.println("(M)enu");
        System.out.println("(Q)uit");
    }

    private static void addPlace(List<Place> places, Place newPlace) {
        for (Place p : places) {
            if (p.name().equalsIgnoreCase(newPlace.name())) {
                System.out.println("Place already exists");
                return;
            }
        }

        int matchedIndex = 0;

        for (Place listPlace : places) {
            if (newPlace.distance() < listPlace.distance()) {
                places.add(matchedIndex, newPlace);
                return;
            }
            matchedIndex++;
        }
        places.add(newPlace);
    }
}
