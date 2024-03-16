package com.pojo;

import java.io.Serializable;

/**
 * @author Lemon
 * @create 2022-11-21-11:06
 */
public class Emp implements Serializable {
    private int id;
    private String empName;
    private String email;
    private double salary;
    private Dept dept;

    public Emp() {
    }

    public Emp(int id, String empName, String email, double salary, com.pojo.Dept dept) {
        this.id = id;
        this.empName = empName;
        this.email = email;
        this.salary = salary;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", dept=" + dept +
                '}';
    }
}
