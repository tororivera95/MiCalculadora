package app.controller;

import java.util.InputMismatchException;
import app.model.CalculadoraModel;
import app.model.XmlModel;
import app.view.CalculadoraView;
import app.view.UsersView;

public class CalculadoraController {

    CalculadoraView calcView = new CalculadoraView();
    CalculadoraModel calcModel = new CalculadoraModel();
    XmlModel xmlModel = new XmlModel();
    UsersView usersView = new UsersView();

    public void iniciar() {

        int opcion = 0;
        double total = 0, num = 0;
        char letra;
        String userId = "", resultString = "";
        boolean validador = true;

        do {
            try {
                calcView.mostrarMenuPrincipal();
                opcion = Integer.parseInt(calcView.leerNum());
                if (opcion < 0 || opcion > 2) {
                    calcView.messageError();
                } else {
                    if (opcion == 1) { // MENU CALCULADORA
                        do {
                            System.out.println("Total = " + total);
                            calcView.mostrarMenuCalculadora();
                            opcion = calcView.leerAll();
                            if (opcion < 0 || opcion > 5) { // Valimos que el numero este dentro de los valores
                                calcView.messageError();
                            } else {
                                if (opcion != 0 && opcion != 5) {
                                    if (validador) {
                                        total = calcView.solicitarNumero();
                                        num = calcView.solicitarNumero();
                                        validador = false;
                                    } else {
                                        num = calcView.solicitarNumero();
                                    }

                                    if (opcion == 1) {
                                        total = calcModel.Suma(total, num);
                                    } else if (opcion == 2) {
                                        total = calcModel.Resta(total, num);
                                    } else if (opcion == 3) {
                                        total = calcModel.Multiplicacion(total, num);
                                    } else if (opcion == 4) {
                                        if (num == 0) {
                                            calcView.messageDivisionCero();
                                        } else {
                                            total = calcModel.Division(total, num);
                                        }
                                    }
                                }

                                if (opcion == 5) {
                                    letra = calcView.reinicio();
                                    if (letra != 'S' && letra != 'N') {
                                        calcView.messageError();
                                    } else if (letra == 'S') {
                                        total = 0;
                                        validador = true;
                                    }
                                }
                            }
                        } while (opcion != 0);
                            opcion = 1;

                    } else if (opcion == 2) { // MENU USUARIOS
                        usersView.Menu();
                    }
                }

            } catch (InputMismatchException e) {
                calcView.messageError();
                calcView.limpiarScanner();
            }

        } while (opcion != 0);

        System.out.println("Hasta pronto");
    }
}
