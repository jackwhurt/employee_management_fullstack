package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.signature.qual.Identifier;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SalesEmployee {

    @NotEmpty
    @Identifier
    private int EmployeeID;
    private float Commision;
    private float TotalSales;

    @JsonCreator
    public SalesEmployee(@JsonProperty("EmployeeID") @Identifier int employeeID,
                         @JsonProperty("Commision") float commision,@JsonProperty("TotalSales") float totalSales) {
        EmployeeID = employeeID;
        Commision = commision;
        TotalSales = totalSales;
    }

    public SalesEmployee(int employeeID, float totalSales) {
        this.EmployeeID = employeeID;
        this.TotalSales = totalSales;

    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public float getCommision() {
        return Commision;
    }

    public void setCommision(float commision) {
        Commision = commision;
    }

    public float getTotalSales() {
        return TotalSales;
    }

    public void setTotalSales(float totalSales) {
        TotalSales = totalSales;
    }
}
