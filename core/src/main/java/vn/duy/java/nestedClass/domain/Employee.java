package vn.duy.java.nestedClass.domain;

import java.util.Comparator;
import java.util.Objects;

public class Employee {

    public static class EmployeeComparator <T extends Employee> implements Comparator<Employee> {
        private EmployeeSortType sortType;

        public EmployeeComparator(EmployeeSortType sortType) {
            this.sortType = sortType;
        }

        public EmployeeComparator() {}

        @Override
        public int compare(Employee o1, Employee o2) {
            if (sortType == EmployeeSortType.YEAR_STARTED) {
                return o1.yearStarted - o2.yearStarted;
            }
            return o1.name.compareTo(o2.name);
        }
    }

    private String employeeId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(String employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%s %3s %d".formatted(employeeId, name, yearStarted);
    }
}
