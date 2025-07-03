package vn.duy.java.nestedClass.domain;

import java.util.Comparator;

public class StoreEmployee extends Employee {
    private String store;

    public StoreEmployee(String employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    public StoreEmployee(String store) {
        this.store = store;
    }

    public StoreEmployee() {
    }

    public class StoreEmployeeComparator<T extends StoreEmployee> implements Comparator<StoreEmployee> {
        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.store.compareTo(o2.store);
            if (result == 0) {
                result = new Employee.EmployeeComparator<>(EmployeeSortType.YEAR_STARTED).compare(o1, o2);
            }
            return result;
        }
    }

    @Override
    public String toString() {
        return "%s %s".formatted(store, super.toString());
    }
}
