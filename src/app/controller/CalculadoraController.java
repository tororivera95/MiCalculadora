package app.controller;

import java.util.InputMismatchException;
import app.model.CalculadoraModel;
import app.view.CalculadoraView;

public class CalculadoraController {

    CalculadoraView calcView = new CalculadoraView();
    CalculadoraModel calcModel = new CalculadoraModel();

    public void iniciar() {

        int opcion = 0;
        double total = 0, num = 0;
        char letra;
        boolean validador = true;

        do {
            try {
                System.out.println("Total = " + total);
                calcView.mostrarMenu();
                opcion = calcView.leerOpction();
                if (opcion < 1 || opcion > 6) {
                    calcView.messageError();
                } else {
                    if (opcion != 5 && opcion != 6) {
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

            } catch (InputMismatchException e) {
                calcView.messageError();
                calcView.limpiarScanner();
            }

        } while (opcion != 6);

        System.out.println("Hasta pronto");
    }
}
