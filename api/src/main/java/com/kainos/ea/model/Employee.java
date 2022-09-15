package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.signature.qual.Identifier;

import javax.validation.constraints.NotNull;

public class Employee {

    @NotNull
    @Identifier
    private int EmployeeID;
    @NotNull
    private int AddressID;
    @NotNull
    private String Name;
    private float StartingSalary;
    private String BankNum;
    private String NIN;
    private enum Department{Sales,HR,Talent,Finance}

    @JsonCreator
    public Employee(@JsonProperty("EmployeeID") @Identifier int employeeID,@JsonProperty("AddressID") int addressID,
                    @JsonProperty("Name") String name,@JsonProperty("StartingSalary") float startingSalary,
                    @JsonProperty("BankNum") String bankNum,@JsonProperty("NIN") String NIN) {
        EmployeeID = employeeID;
        AddressID = addressID;
        Name = name;
        StartingSalary = startingSalary;
        BankNum = bankNum;
        this.NIN = NIN;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public int getAddressID() {
        return AddressID;
    }

    public void setAddressID(int addressID) {
        AddressID = addressID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getStartingSalary() {
        return StartingSalary;
    }

    public void setStartingSalary(float startingSalary) {
        StartingSalary = startingSalary;
    }

    public String getBankNum() {
        return BankNum;
    }

    public void setBankNum(String bankNum) {
        BankNum = bankNum;
    }

    public String getNIN() {
        return NIN;
    }

    public void setNIN(String NIN) {
        this.NIN = NIN;
    }
}
