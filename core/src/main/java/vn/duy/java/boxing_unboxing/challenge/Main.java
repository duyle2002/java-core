package vn.duy.java.boxing_unboxing.challenge;

import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions) {
    public Customer(String name, double initAmount) {
        this(name.toUpperCase(), new ArrayList<>(500));
        transactions.add(initAmount);
    }
}
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John", 500);
        System.out.println(customer);
    }
}

class Bank {
    private String name;
    private ArrayList<Customer> customers =  new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.name().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public void addNewCustomer(String customerName, double initAmount) {
        if (this.getCustomer(customerName) != null) {
            return;
        }
        Customer customer = new Customer(customerName, initAmount);
        customers.add(customer);
    }

    public void addTransactions(String name, double transactionAmount) {
        Customer customer = this.getCustomer(name);
        if (customer != null) {
            customer.transactions().add(transactionAmount);
        }
    }

    public void printStatement(String customerName) {
        Customer customer = this.getCustomer(customerName);
        if (customer == null) {
            return;
        }

        System.out.println("-".repeat(30));
        System.out.println(customer.name());
        System.out.println(customer.transactions());

        for (double transactionAmount : customer.transactions()) { // unboxing
            System.out.printf("%.2f%n - (%s)", transactionAmount, transactionAmount > 0 ? "credit" : "debit");
        }
    }
}