package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.signature.qual.Identifier;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.validation.constraints.NotNull;

public class Address {

    @NotNull
    @Identifier
    @Unique
    private int AddressID;
    @Unique
    @NotNull
    private String AddressLineOne;
    private String Town;
    private String County;
    @NotNull
    private String Postcode;

    @JsonCreator
    public Address(@JsonProperty("AddressID") @Identifier @Unique int addressID,
                   @JsonProperty("AddressLineOne") @Unique String addressLineOne,@JsonProperty("Town") String town,
                   @JsonProperty("County") String county,@JsonProperty("Postcode")String postcode) {
        AddressID = addressID;
        AddressLineOne = addressLineOne;
        Town = town;
        County = county;
        Postcode = postcode;
    }

    public int getAddressID() {
        return AddressID;
    }

    public void setAddressID(int addressID) {
        AddressID = addressID;
    }

    public String getAddressLineOne() {
        return AddressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        AddressLineOne = addressLineOne;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }
}
