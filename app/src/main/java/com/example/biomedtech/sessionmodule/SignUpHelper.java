package com.example.biomedtech.sessionmodule;

public class SignUpHelper {

    //ESTRUCTURA DE SINGLETON
    private SignUpHelper(){}
    private static SignUpHelper instance;
    public static SignUpHelper getInstance()
    {
        if (instance == null)
        {
            instance = new SignUpHelper();
        }
        return  instance;
    }

    // NOTA PARA IVANUE: CREAR LAS FUNCIONES DE LOGIN A PARTIR DE AQUI
}
