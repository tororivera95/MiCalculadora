package app.view;

import java.util.Scanner;

public class CalculadoraView {

    private final Scanner sc = new Scanner(System.in);

    // MENU PRINCIPAL
    public void mostrarMenuPrincipal() {
        System.out.println("MENU" +
                "\n1. Calculadora" +
                "\n2. Usuarios");
    }

    // MENU CALCULADORA|
    public void mostrarMenuCalculadora() {
        System.out.println(
                "CALCULADORA" +
                        "\n1. Suma" +
                        "\n2. Resta" +
                        "\n3. Multiplicacion" +
                        "\n4. Division" +
                        "\n5. Reiniciar" +
                        "\n0. Menu Principal");
    }

    // LEER TODOS LOS DATOS
    public int leerAll() {
        System.out.println("Elije una opcion");
        return sc.nextInt();
    }

    // LEER SOLO NUMEROS
    public String leerNum() {
        String entrada;
        boolean validar = true;

        System.out.println("Elije una opcion");
        entrada = sc.nextLine();

        while (validar) {
            if (entrada.matches("\\d+")) {
                validar = false;
            } else {
                System.out.println("Entrada inválida. Solo se permiten números.");
                entrada = sc.nextLine();
            }
        }
        return entrada;
    }

    // LEER SOLO STRING
    public String leerText() {
        System.out.println("Elije una opcion");
        return sc.nextLine();
    }

    public double solicitarNumero() {
        System.out.println("Digite un valor");
        return sc.nextDouble();
    }

    public char reinicio() {
        System.out.println("Esta seguro de reiciar S/N ?");
        return sc.next().trim().toUpperCase().charAt(0);
    }

    public void limpiarScanner() {
        sc.nextLine();
    }

    // MESAJES DE ERROR
    public void messageError() {
        System.out.println("Error, opcion no valida");
    }

    public void messageDivisionCero() {
        System.out.println("ERROR! , No se puede dividir entre cero");
    }

}