import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        ArrayList<String> listaEspera = new ArrayList<String>();
        //crea una lista vacía para almacenar los nombres de los pacientes que esperan para recibir medicamentos
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese su nombre y apellidos: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese su edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // limpia el buffer del scanner
            System.out.println("Ingrese su afiliación (POS o PC): ");
            String afiliacion = scanner.nextLine();
            System.out.println("¿Tiene alguna condición especial? (embarazo o limitación motriz): ");
            String condicionEspecial = scanner.nextLine();

            String paciente = nombre + " - " + edad + " años - Afiliación: " + afiliacion + " - Condición especial: " + condicionEspecial;
            if (edad < 12 || edad >= 60) { 
                // si el paciente es una persona de la tercera edad o menor de 12 años
                listaEspera.add(0, paciente); 
                // agregar al principio de la lista
            } else if (condicionEspecial.equalsIgnoreCase("embarazo")) { 
                // si el paciente es una mujer embarazada
                listaEspera.add(listaEspera.indexOf("60 años o menos"), paciente); 
                // agregar después de los pacientes de la tercera edad o menores de 12 años
            } else if (condicionEspecial.equalsIgnoreCase("limitación motriz")) { 
                // si el paciente tiene una limitación motriz
                listaEspera.add(listaEspera.indexOf("Mujeres embarazadas"), paciente); 
                // agregar después de las mujeres embarazadas
            } else if (afiliacion.equalsIgnoreCase("PC") || afiliacion.equalsIgnoreCase("prepagada")) { // si el paciente está afiliado a un plan complementario o prepagado
                listaEspera.add(paciente);
                // agregar al final de la lista
            } else { // si el paciente no tiene ninguna condición especial y no está afiliado a un plan complementario o prepagado
                listaEspera.add(paciente); // agregar al final de la lista
            }

            System.out.println("Su número de turno es: " + (listaEspera.indexOf(paciente) + 1)); // mostrar al paciente su número de turno en la lista de espera
            System.out.println(" ");
        }
    }
}
