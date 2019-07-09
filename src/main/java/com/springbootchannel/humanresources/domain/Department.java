package com.springbootchannel.humanresources.domain;

import javax.persistence.*;

@Entity
public class Department extends BaseEntity{

    private String name;
    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "Id = "+ getId()+ '\'' +
                "name='" + name + '\'' +
                ", company=" + company +
                '}';
    }
}
