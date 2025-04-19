import java.util.InputMismatchException;
import java.util.Scanner;

public class MiCalculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int entrada = 0, contador = 0;
        float num1 = 0, total = 0;
        String letra = "";
        while (entrada != 6) {
            try {
                System.out.println(
                        "Elije una opcion: \n1. Suma \n2. Resta \n3. Multiplicacion \n4. Division \n5. Ver Resultado \n6. Salir");
                entrada = sc.nextInt();
                if (entrada > 6 || entrada < 1) {
                    System.out.println("La opcion elijada es incorrecta, intente nuevamente");
                } else if (entrada == 5) {
                    sc.nextLine();
                    System.out.println("Total = " + total);
                    System.out.println("Reiniciar S/N");
                    letra = sc.nextLine().toUpperCase();
                    if (!letra.equals("S") && !letra.equals("N")) {
                        System.out.println("Valor ingresado no valido");
                    }else if (letra.equals("N")) {
                        total = 0;
                        contador = 0;
                    }
                } else if (entrada == 6) {
                    System.out.println("Hasta luego");
                } else {
                    contador += 1;
                    if (contador <= 1) {
                        System.out.println("Ingrese el primer numero: ");
                        total = sc.nextInt();
                        System.out.println("Ingrese el segundo numero: ");
                        num1 = sc.nextInt();
                    } else {
                        System.out.println("Total: " + total
                                + "\nIngrese el siguiente numero: ");
                        num1 = sc.nextInt();
                    }
                    if (entrada == 1) {
                        total = total + num1;
                    } else if (entrada == 2) {
                        total = total - num1;
                    } else if (entrada == 3) {
                        total = total * num1;
                    } else if (entrada == 4) {
                        if (num1 == 0) {
                            System.out.println("ERROR: No se puede dividir entre cero");
                        } else {
                            total = total / num1;
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR!! Valor ingresado NO es valido");
                sc.nextLine();
            }
        }

    }
}
