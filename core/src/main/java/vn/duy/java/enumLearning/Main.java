package vn.duy.java.enumLearning;

import java.time.DayOfWeek;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DayOfTheWeek dow = DayOfTheWeek.SUNDAY;
        System.out.println(dow);

        System.out.println(dow.ordinal());

        System.out.println(getRandomDay());
    }

    public static DayOfTheWeek getRandomDay() {
        Random rand = new Random();
        int index = rand.nextInt(7);
        return DayOfTheWeek.values()[index];
    }
}
