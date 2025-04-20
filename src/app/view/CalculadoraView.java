package app.view;

import java.util.Scanner;

public class CalculadoraView {

    private final Scanner sc = new Scanner(System.in);

    // MENU
    public void mostrarMenu() {
        System.out.println(
                "MENU " +
                        "\n1. Suma" +
                        "\n2. Resta" +
                        "\n3. Multiplicacion" +
                        "\n4. Division" +
                        "\n5. Reiniciar" +
                        "\n6. Salir");
    }

    // SOLICITAR DATOS
    public int leerOpction() {
        System.out.println("Elije una opcion");
        return sc.nextInt();
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