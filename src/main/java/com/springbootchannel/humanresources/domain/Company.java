package com.springbootchannel.humanresources.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company extends BaseEntity{

    private String name;
    private String phoneNumber;
    private String address;
    private String address2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Company{" +
                "id=" + getId() +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                '}';
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }
}
