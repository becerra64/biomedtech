package com.example.biomedtech.databasemodule;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ConcurrentModificationException;

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

    public void connect()
    {
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection conn = DriverManager.getConnection(ConnectionString());
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE Shit (\n" +
                    "    PersonaID int,\n" +
                    "    Apellido varchar(255),\n" +
                    "    Nombre varchar(255),\n" +
                    "    Direccion varchar(255),\n" +
                    "    Ciudad varchar(255) \n" +
                    ");";
            st.executeQuery(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //PRIVATE
    private static DataBaseHelper instance;
    private DataBaseHelper()
    {
        // creating data base
    }
    private String ConnectionString()
    {
        return "jdbc:jtds:sqlserver://biomedtechproyect.database.windows.net:1433;" +
                "DatabaseName=biomedProyect;" +
                "user=SA_Biomed@biomedtechproyect;" +
                "password=418B1omed#;" +
                "encrypt=false;" +
                "trustServerCertificate=true;" +
                "hostNameInCertificate=*.database.windows.net;" +
                "loginTimeout=30;" +
                ";ssl=request";
    }
}
