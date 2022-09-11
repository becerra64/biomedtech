package com.example.biomedtech.modelsDTO;

public class Contact {
    public String getRelationship() {
        return Relationship;
    }

    public void setRelationship(String relationship) {
        Relationship = relationship;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Telecom getTelecom() {
        return telecom;
    }

    public void setTelecom(Telecom telecom) {
        this.telecom = telecom;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public Contact(String relationship, Account account, Telecom telecom, Address address, int gender) {
        Relationship = relationship;
        this.account = account;
        this.telecom = telecom;
        this.address = address;
        Gender = gender;
    }



    private String Relationship;
    private Account account;
    private Telecom telecom;
    private Address address;
    private int Gender;
}
