package com.example.biomedtech.modelsDTO;

public class Address {
    private String UUID;
    private int IdUse;
    private int IdType;
    private String Address;
    private String City;

    public Address(String UUID, int idUse, int idType, String address, String city, String district, String state, String postalCode, String country) {
        this.UUID = UUID;
        IdUse = idUse;
        IdType = idType;
        Address = address;
        City = city;
        District = district;
        State = state;
        PostalCode = postalCode;
        Country = country;
    }

    private String District;
    private String State;
    private String PostalCode;
    private String Country;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public int getIdUse() {
        return IdUse;
    }

    public void setIdUse(int idUse) {
        IdUse = idUse;
    }

    public int getIdType() {
        return IdType;
    }

    public void setIdType(int idType) {
        IdType = idType;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

}
