package com.example.biomedtech.databasemodule;

import com.example.biomedtech.modelsDTO.ItemCatalog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetCatalogs {
    DataBaseHelper dbHelper = DataBaseHelper.getInstance();

    public List<ItemCatalog> GetCatalogSP(String Catalog){
        ResultSet rs = dbHelper.execSP("[dbo].[" + Catalog + "]");
        List<ItemCatalog> items = new ArrayList<>();
        ItemCatalog temp;
        try {
            while (rs.next()){
                temp = new ItemCatalog(rs.getInt("Id"), rs.getString("Text"));
                items.add(temp);
            }
        }
        catch (Exception e){

        }

        return items;
    }
}
