package com.example.biomedtech.modelsDTO;

public class Comunication {
    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public int getIdLanguage() {
        return IdLanguage;
    }

    public void setIdLanguage(int idLanguage) {
        IdLanguage = idLanguage;
    }

    public Boolean getPrefered() {
        return Prefered;
    }

    public void setPrefered(Boolean prefered) {
        Prefered = prefered;
    }

    public Comunication(String UUID, int idLanguage, Boolean prefered) {
        this.UUID = UUID;
        IdLanguage = idLanguage;
        Prefered = prefered;
    }

    private String UUID;
    private int IdLanguage;
    private Boolean Prefered;
}
