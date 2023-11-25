package homework.stream_api;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Employees {
    private int id;
    private String firstName;
    private String lastName;
    private Manager manager;
    private double salary;

    public Employees(int id, String firstName, String lastName, Manager manager, double salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.manager = manager;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", manager=" + manager +
                ", salary=" + salary +
                '}';
    }


}

