package vn.duy.java.nestedClass.domain;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(
                List.of(
                        new Employee("1", "Duy", 2025),
                        new Employee("2", "Quan", 2020),
                        new Employee("3", "an", 2019),
                        new Employee("4", "Tuan", 2023)
                )
        );

//        EmployeeComparator<Employee> employeeComparator = new EmployeeComparator<>();
//        employees.sort(employeeComparator);
        employees.sort(new Employee.EmployeeComparator<>(EmployeeSortType.YEAR_STARTED));

        System.out.println(employees);
    }
}
