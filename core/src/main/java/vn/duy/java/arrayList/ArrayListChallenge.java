package vn.duy.java.arrayList;

import java.util.*;

public class ArrayListChallenge {
    public static void main(String[] args) {
        List<String> groceries = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        menu();
        int choice;
        do {
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Add items to the list");
                String[] groceryArr = scanner.nextLine().split(",");
                for (String groceryInput : groceryArr) {
                    if (!groceries.contains(groceryInput)) {
                        groceries.add(groceryInput);
                    }
                }
            } else if (choice == 2) {
                System.out.println("Remove item(s) from the list");
                String[] groceryArr = scanner.nextLine().split(",");
                groceries.removeAll(Arrays.asList(groceryArr));
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        } while (choice != 0);
    }

    public static void menu() {
        System.out.println("Available actions:");
        System.out.println("0 - to shutdown");
        System.out.println("1 - to add item(s) to list (comma delimited list)");
        System.out.println("2 - to remove any items (comma delimited list)");
        System.out.println("Enter a number for which action you would like to perform: ");
    }
}
