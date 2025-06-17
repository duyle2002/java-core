package vn.duy.java.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record GroceryItem(String name, String type, int count) {
    public GroceryItem(String name) {
        this(name, "DAIRY", 5);
    }

    @Override
    public String toString() {
        return String.format("%s %d in %s", name, count, type);
    }
}

public class ArrayListLearning {
    public static void main(String[] args) {
        Object[] objectArray = new Object[3];
        objectArray[0] = new GroceryItem("Book");
        objectArray[1] = new GroceryItem("Book", "Book", 10);
        objectArray[2] = "Hello World";
        System.out.println("Object array: " + Arrays.toString(objectArray));

        GroceryItem[] groceryItems = new GroceryItem[3];
        groceryItems[0] = new GroceryItem("Book");
        groceryItems[1] = new GroceryItem("Book", "Book", 10);
        System.out.println("Grocery items: " + Arrays.toString(groceryItems));

//        List groceryItemList = new ArrayList<GroceryItem>();
        List<GroceryItem> groceryItemList = new ArrayList<>();
        groceryItemList.add(new GroceryItem("Book"));
        groceryItemList.add(new GroceryItem("Book", "Book", 10));
        groceryItemList.add(new GroceryItem("milk"));
        groceryItemList.set(0, new GroceryItem("orange"));
        System.out.println("Grocery items: " + Arrays.toString(groceryItemList.toArray()));
        System.out.println(groceryItemList);

    }
}
