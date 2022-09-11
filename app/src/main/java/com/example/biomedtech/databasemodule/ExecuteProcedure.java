package com.example.biomedtech.databasemodule;

import com.example.biomedtech.modelsDTO.Account;
import com.example.biomedtech.modelsDTO.Address;
import com.example.biomedtech.modelsDTO.Comunication;
import com.example.biomedtech.modelsDTO.Contact;
import com.example.biomedtech.modelsDTO.Telecom;

import java.sql.ResultSet;

public class ExecuteProcedure {
    DataBaseHelper dbHelper = DataBaseHelper.getInstance();

    public void AddAccount(Account account){
        String query = "EXEC [dbo].[CreateAccount] '" +
                account.getUUID() + "', '" +
                account.getFullname() + "', '" +
                account.getSurname() + "', '" +
                account.getGiven() + "', '" +
                account.getPrefix() + "', '" +
                account.getSuffix() + "', " +
                account.getIdGender() + ", " +
                account.getBirthDate() + ", " +
                account.getIdNationality() + "; ";

         ResultSet rs = dbHelper.execSP(query);
    }

    public void AddAddress(Address address){
        String query = "EXEC [dbo].[AddAddress] '"+
                address.getUUID()+"', "+
                address.getIdUse()+", "+
                address.getIdType()+", '"+
                address.getAddress()+"', '"+
                address.getCity()+"', '"+
                address.getDistrict()+"', '"+
                address.getState()+"', '"+
                address.getPostalCode()+"', '"+
                address.getCountry()+"';";

        ResultSet rs = dbHelper.execSP(query);
    }

    public void AddTelecom(Telecom telecom){
        String query = "EXEC [dbo].[AddTelecom] '"+
                telecom.getUUID()+"', "+
                telecom.getIdSystem()+", '"+
                telecom.getValue()+"', "+
                telecom.getIdUseContact()+", "+
                telecom.getRank()+";";

        ResultSet rs = dbHelper.execSP(query);
    }

    public void AddComunication(Comunication comunication){
        String query = "EXEC [dbo].[AddComunication] '"+
                comunication.getUUID()+"', "+
                comunication.getIdLanguage()+", "+
                comunication.getPrefered()+";";

        ResultSet rs = dbHelper.execSP(query);
    }

    public void AddContact(Contact contact){
        String query = "EXEC [dbo].[AddContact] '"+
                contact.getAccount().getUUID()+"', '"+
                contact.getRelationship()+"', '"+
                contact.getAccount().getFullname()+"', '"+
                contact.getAccount().getSurname()+"', '"+
                contact.getAccount().getGiven()+"', '"+
                contact.getAccount().getPrefix()+"', '"+
                contact.getAccount().getSuffix()+"', "+
                contact.getAddress().getIdUse()+", "+
                contact.getAddress().getIdType()+", '"+
                contact.getAddress().getAddress()+"', '"+
                contact.getAddress().getCity()+"', '"+
                contact.getAddress().getDistrict()+"', '"+
                contact.getAddress().getState()+"', '"+
                contact.getAddress().getPostalCode()+"', '"+
                contact.getAddress().getCountry()+"', "+
                contact.getTelecom().getIdSystem()+", '"+
                contact.getTelecom().getValue()+"', "+
                contact.getTelecom().getIdUseContact()+", "+
                contact.getTelecom().getRank()+", "+
                contact.getGender()+";";

        ResultSet rs = dbHelper.execSP(query);
    }

    public void GetAccount(String UUID) {
        String query = "EXEC [dbo].[get_Account] " + UUID + ";";
        ResultSet rs = dbHelper.execSP(query);
        Account account;
        try {
            while (rs.next()) {
                account = new Account(UUID,
                        rs.getString("Fullname"),
                        rs.getString("Family"),
                        rs.getString("Given"),
                        rs.getString("Prefix"),
                        rs.getString("Sufix"),
                        1,
                        rs.getString("BirthDate"),
                        1);

            }
        } catch (Exception e) {
        }


    }

    public void GetAddress(String UUID){
        String query = "EXEC [dbo].[get_Adress] " + UUID + ";";
        ResultSet rs = dbHelper.execSP(query);
    }

    public void GetContact(String UUID){
        String query = "EXEC [dbo].[get_Contact] " + UUID + ";";
        ResultSet rs = dbHelper.execSP(query);
    }

    public void GetTelecom(String UUID){
        String query = "EXEC [dbo].[get_Telecom] " + UUID + ";";
        ResultSet rs = dbHelper.execSP(query);
    }
}
