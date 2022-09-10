package com.example.biomedtech.sessionmodule;

enum LoginResult
{
    LOGIN_SUCCESSFUL,
    LOGIN_FAILED
}

public class LoginHelper {

    //ESTRUCTURA DE SINGLETON
    private LoginHelper() {}
    private static LoginHelper instance;
    public static LoginHelper getInstance()
    {
        if (instance == null)
        {
            instance = new LoginHelper();
        }
        return  instance;
    }

    // NOTA PARA IVANUE: CREAR LAS FUNCIONES DE LOGIN A PARTIR DE AQUI

}
