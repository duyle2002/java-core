package vn.duy.java.comparable_comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] numbers = { 0, 5, -10, 60, 39};
        for (Integer number : numbers) {
            System.out.printf("%d %s %d, compareTo = %d%n", five,
                    five.compareTo(number) == 0 ? "=="
                            : five.compareTo(number) > 0 ? ">"
                            : "<",
                    number,
                    five.compareTo(number)
            );
        }

        String name = "Duy";
        String[] nameArr = { "bench", "Jane", "John", "Lewis", "Duy"};
        for (String str : nameArr) {
            int compareValue = name.compareTo(str);
            System.out.printf("%s %s %s, compareTo = %d%n",
                    name, compareValue == 0 ? "==" : compareValue > 0 ? ">" : "<", str, compareValue);
        }
        Arrays.sort(nameArr);
        System.out.println(Arrays.toString(nameArr));

        Student duy = new Student("duy");
        Student[] students = { duy, new Student("quang"), new Student("jane"), new Student("Hung")};
//        Arrays.sort(students);
//        System.out.println(Arrays.toString(students));

        StudentGPAComparator studentGPAComparator = new StudentGPAComparator();
        Arrays.sort(students, studentGPAComparator);
    }
}

class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student> {
    protected String name;

    protected double gpa;
    private Random random = new Random();

    public Student(String name) {
        this.name = name;
        this.gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return name + " (" + gpa + ")";
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}