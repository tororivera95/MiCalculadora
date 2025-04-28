package app.view;

import java.util.ArrayList;

import app.model.UsersModel;
import app.model.XmlModel;

public class UsersView {

    XmlModel xmlModel = new XmlModel();
    UsersModel userModel = new UsersModel();
    CalculadoraView calcView = new CalculadoraView();

    public void Menu() {

        System.out.println("MENU USUARIOS " /*+
                 "\n1. Crear" +
                "\n2. Buscar por ID" +
                "\n3. otros"*/);

       // calcView.leerNum();

        ArrayList<UsersModel> usersList = new ArrayList<>();
        usersList = xmlModel.obtenerUsuarios();

        for (UsersModel user : usersList) {
            System.out.println("Usuario: " + user.getId());
        }

        /* 
        System.out.println("ID: " + userModel.getName() +
                "\nName: " + userModel.getName() +
                "\nLastName: " + userModel.getLastName() +
                "\nAge: " + userModel.getAge() +
                "\nNationality: " + userModel.getNationality());
        */
    }
}
