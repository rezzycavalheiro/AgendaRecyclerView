package com.example.agendarecycler;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class DataModel {
    private static DataModel instance = new DataModel();
    private DataModel(){
        userArray.add(
                new UserInfo("Renata", "Rua Parana, 12", "98080-7684", "Casa")
        );
        userArray.add(
                new UserInfo("Pedro", "Rua Sta Catarina, 3", "89565-7684", "Trabalho")
        );
        userArray.add(
                new UserInfo("Jose", "Rua RS, 36", "3356-2563", "Outro")
        );
    }
    public static DataModel getInstance(){
        return instance;
    }
    // Singleton. Abaixo criando os itens necessários para a recycler view

    ArrayList<UserInfo> userArray = new ArrayList<>();
}
