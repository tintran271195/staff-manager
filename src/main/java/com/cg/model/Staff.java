package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String identityCard;
    private LocalDate dob;
    private String address;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Staff(String fullName, String identityCard, LocalDate dob, String address, String phoneNumber) {
        this.fullName = fullName;
        this.identityCard = identityCard;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Staff(String fullName, String identityCard, LocalDate dob, String address, String phoneNumber, Department department) {
        this.fullName = fullName;
        this.identityCard = identityCard;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", department=" + department +
                '}';
    }
}

