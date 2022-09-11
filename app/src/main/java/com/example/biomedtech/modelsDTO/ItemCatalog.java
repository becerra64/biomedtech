package com.example.biomedtech.modelsDTO;

public class ItemCatalog {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public ItemCatalog(int id, String text) {
        Id = id;
        Text = text;
    }

    public String toString(){
        return Text;
    }

    private int Id;
    private String Text;
}
