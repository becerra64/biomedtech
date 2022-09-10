package com.example.biomedtech.databasemodule;
import java.sql.DriverManager;

public final class DataBaseHelper {

    //PUBLIC
    public static DataBaseHelper getInstance()
    {
        if(instance == null)
        {
            instance = new DataBaseHelper();
        }
        return  instance;
    }



    //PRIVATE
    private static DataBaseHelper instance;
    private DataBaseHelper()
    {
        // creating data base
    }
}
