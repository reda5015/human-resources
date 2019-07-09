package com.springbootchannel.humanresources.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Employee extends BaseEntity{

    private String employeeName;
    private int salary;
    @ManyToOne
    private Department department ;

    @Override
    public String toString() {
        return "Employee{" +
                "Id = '"+getId()+'\''+
                "employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }



}
