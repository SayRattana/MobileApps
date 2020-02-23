package com.company;

public class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee() {
        firstName = null;
        lastName = null;
        monthlySalary = 0.0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return monthlySalary;
    }

    public void setFirstName(String first) {
        firstName = first;
    }

    public void setLastName(String last) {
        lastName = last;
    }

    public void setSalary(double salary) {
        monthlySalary = salary;
    }
}