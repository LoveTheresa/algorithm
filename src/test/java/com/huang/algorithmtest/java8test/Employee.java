package com.huang.algorithmtest.java8test;

import org.junit.platform.engine.TestExecutionResult;

import java.util.Objects;

/**
 * @author Huangzhanpeng
 * @date 2020/3/19 - 11:23
 */
public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;
    private Status status;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary, Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public Employee(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(int id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return id == employee.id &&
//                age == employee.age &&
//                Double.compare(employee.salary, salary) == 0 &&
//                Objects.equals(name, employee.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, age, salary);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() &&
                getAge() == employee.getAge() &&
                Double.compare(employee.getSalary(), getSalary()) == 0 &&
                getName().equals(employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getSalary());
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public enum Status{
        FRES,
        BUSY,
        VOCATION;
    }


}
