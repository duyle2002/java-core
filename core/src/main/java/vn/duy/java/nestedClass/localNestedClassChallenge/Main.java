package vn.duy.java.nestedClass.localNestedClassChallenge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Employee(String firstName, String lastName, LocalDate hiredDate) {

}
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(
                List.of(
                        new Employee("Le", "Duy", LocalDate.of(2025, 7, 14)),
                        new Employee("Hoang", "Lien", LocalDate.of(2024, 3, 11)),
                        new Employee("Duc", "Tin", LocalDate.of(2023, 1, 11))
                )
        );

        methodName(employees);

    }

    public static void methodName(List<Employee> employees) {
        class CalculateEmployee {
            private String fullName;
            private int yearWorked;
            public CalculateEmployee() {
            }
            public CalculateEmployee(Employee employee) {
                this.fullName = employee.firstName() +  " " + employee.lastName();
                this.yearWorked = employee.hiredDate().getYear();
            }

            @Override
            public String toString() {
                return fullName + " [" + yearWorked + "]";
            }
        }

        List<CalculateEmployee> calculateEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            calculateEmployees.add(new CalculateEmployee(employee));
        }

        // sort by full name
        calculateEmployees.sort(new Comparator<>() {

            @Override
            public int compare(CalculateEmployee o1, CalculateEmployee o2) {
                return o1.fullName.compareTo(o2.fullName);
            }
        });

        System.out.println("Sort by FullName: ");
        for  (CalculateEmployee employee : calculateEmployees) {
            System.out.println(employee);
        }

        // sort by year of worked
        calculateEmployees.sort(new Comparator<>() {
            @Override
            public int compare(CalculateEmployee o1, CalculateEmployee o2) {
                return o1.yearWorked - o2.yearWorked;
            }
        });
        System.out.println("Sort by Year Worked: ");
        for  (CalculateEmployee employee : calculateEmployees) {
            System.out.println(employee);
        }
    }
}
