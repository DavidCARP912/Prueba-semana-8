/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

 
import java.util.Scanner;
import java.util.ArrayList;

public class RestaurantedeDeybi {

    static double[] preciosComida = new double[3]; 
    static double[] preciosExtra = new double[3];  
    static ArrayList<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el precio de la comida economica:");
        preciosComida[0] = scanner.nextDouble();
        System.out.println("Ingrese el precio de la comida regular:");
        preciosComida[1] = scanner.nextDouble();
        System.out.println("Ingrese el precio de la comida premium:");
        preciosComida[2] = scanner.nextDouble();
        System.out.println("Ingrese el costo extra de tortillas:");
        preciosExtra[0] = scanner.nextDouble();
        System.out.println("Ingrese el costo extra de tajadas:");
        preciosExtra[1] = scanner.nextDouble();
        System.out.println("Ingrese el costo extra papas:");
        preciosExtra[2] = scanner.nextDouble();
        scanner.nextLine();

        while (true) {
            System.out.println("Desea ingresar un nuevo pedido (si/no)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                break;
            }

            System.out.println("Nombre completo:");
            String nombreCliente = scanner.nextLine();
            System.out.println("Direccion:");
            String direccionCliente = scanner.nextLine();
            System.out.println("Numero de telefono:");
            String telefonoCliente = scanner.nextLine();
            System.out.println("Tipo de comida (economica, regular, premium):");
            String tipoComida = scanner.nextLine();
            System.out.println("Tipo de extra (tortillas, tajadas, papas):");
            String tipoExtra = scanner.nextLine();
            System.out.println("Es cliente frecuente (si/no)");
            boolean esFrecuente = scanner.nextLine().equalsIgnoreCase("si");
            System.out.println("Es cliente de la tercera edad (si/no)");
            boolean esTerceraEdad = scanner.nextLine().equalsIgnoreCase("si");

            Pedido pedido = new Pedido(nombreCliente, direccionCliente, telefonoCliente, tipoComida, tipoExtra, esFrecuente, esTerceraEdad);
            double total = calcularTotal(pedido);
            pedido.encargo();
            System.out.println("Total a pagar: Lps. " + total);
            pedidos.add(pedido);
        }

        ventasdelDia();
        scanner.close();
    }

    static double calcularTotal(Pedido pedido) {
        double total = 0;

        if (pedido.comida.equalsIgnoreCase("economica")) {
            total += preciosComida[0];
        } else if (pedido.comida.equalsIgnoreCase("regular")) {
            total += preciosComida[1];
        } else if (pedido.comida.equalsIgnoreCase("premium")) {
            total += preciosComida[2];
        }

        if (pedido.extra.equalsIgnoreCase("tortillas")) {
            total += preciosExtra[0];
        } else if (pedido.extra.equalsIgnoreCase("tajadas")) {
            total += preciosExtra[1];
        } else if (pedido.extra.equalsIgnoreCase("papas")) {
            total += preciosExtra[2];
        }

        if (pedido.frecuente) {
            total *= 0.85;
        } else if (pedido.tercera) {
            total *= 0.75;
        }
        return total;
    }

    static void ventasdelDia() {
        double totalVentas = 0;
        System.out.println("\nResumen de ventas del dia:");
        for (Pedido pedido : pedidos) {
            totalVentas += calcularTotal(pedido);
        }
        System.out.println("Total de ventas: Lps. " + totalVentas);
    }
}

class Pedido {
    String nombre;
    String direccion;
    String telefono;
    String comida;
    String extra;
    boolean frecuente;
    boolean tercera;

    Pedido(String nombreCliente, String direccionCliente, String telefonoCliente, String tipoComida, String tipoExtra, boolean esFrecuente, boolean esTerceraEdad) {
        nombre = nombreCliente;
        direccion = direccionCliente;
        telefono = telefonoCliente;
        comida = tipoComida;
        extra = tipoExtra;
        frecuente = esFrecuente;
        tercera = esTerceraEdad;
    }

    void encargo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Direccion: " + direccion);
        System.out.println("Telefono: " + telefono);
        System.out.println("Tipo de Comida: " + comida);
        System.out.println("Extra: " + extra);
        System.out.println("Cliente Frecuente: " + (frecuente ? "Si" : "No"));
        System.out.println("Cliente de la Tercera Edad: " + (tercera ? "Si" : "No"));
    }
}
