package com.example.biomedtech.modelsDTO;

public class Telecom {
    private String UUID;
    private int IdSystem;
    private String Value;
    private int IdUseContact;
    private int Rank;

    public Telecom(String UUID, int idSystem, String value, int idUseContact, int rank) {
        this.UUID = UUID;
        IdSystem = idSystem;
        Value = value;
        IdUseContact = idUseContact;
        Rank = rank;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public int getIdSystem() {
        return IdSystem;
    }

    public void setIdSystem(int idSystem) {
        IdSystem = idSystem;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public int getIdUseContact() {
        return IdUseContact;
    }

    public void setIdUseContact(int idUseContact) {
        IdUseContact = idUseContact;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

}
