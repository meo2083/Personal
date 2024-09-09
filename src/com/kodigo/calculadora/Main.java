package com.kodigo.calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase donde se encuentra la interfaz de usuario para realizar operaciones de calculadora.
 * @author edwin_rivas
 * @version 1.0
 */
public class Main {

    /**
     * Sirve para leer opción seleccionada por el usuario y números a procesar
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método para mostrar menú de opciones
     */
    public static void mostrarMenu()
    {
        System.out.println("---------------MENU DE OPCIONES---------------");
        System.out.println("1.  SUMAR");
        System.out.println("2.  RESTAR");
        System.out.println("3.  MULTIPLICAR");
        System.out.println("4.  DIVIDIR");
        System.out.println("5.  POTENCIA");
        System.out.println("6.  RAIZ CUADRADA");
        System.out.println("0.  SALIR");
    }

    /**
     * Lee opción de menú que el usuario seleccione
     * @return Operación seleccionada por el usuario
     */
    public static int leerOpcionDeUsuario()
    {
        int opcion = -1; // Valor por defecto para indicar una opción no válida
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                entradaValida = true; // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                // Captura la excepción si el usuario no introduce un número entero
                System.out.println("Error: Debes introducir un número entero.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
        return opcion;
    }

    /**
     * Método utilizado para leer número ingresado por el usuario
     * @param indice Indice de número introducido (número 1 ó número 2)
     * @return El número introducido por el usuario
     */
    public static Numero leerNumero(int indice)
    {
        Numero numero = null; // Valor por defecto
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                if(indice == -1)
                {
                    System.out.print("Indroduzca un número: ");
                }
                else {
                    System.out.print("Introduzca número " + indice+" :");
                }
                numero = new Numero(scanner.nextDouble());
                entradaValida = true; // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                // Captura la excepción si el usuario no introduce un número
                System.out.println("Error: Debes introducir un número.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
        return numero;
    }

    /**
     * Procesa números ingresados y opción seleccionada por el usario para calcular y mostrar el resultado
     * @param opcion Operación que el usuario seleccionó
     * @throws IllegalArgumentException si el usario no seleccionó una opción entre 0 y 6
     */
    public static void procesarOpcionDeUsuario(int opcion) throws IllegalArgumentException
    {
        if(opcion >=0 && opcion <=6)
       {
           Operacion operacion = new Operacion(opcion);
           if(opcion != 6)
           {
                Numero numero1 = leerNumero(1);
                Numero numero2 = leerNumero(2);
                Calculadora calculadora = new Calculadora(numero1, numero2, operacion);
                try {
                    calculadora.Calcular();
                }catch (ArithmeticException e)
                {
                    System.out.println(e.getMessage());
                }
           }else{
               Numero numero1 = leerNumero(-1);
               Calculadora calculadora = new Calculadora(numero1, null, operacion);
               try {
                   calculadora.Calcular();
               }catch (ArithmeticException e)
               {
                   System.out.println(e.getMessage());
               }
           }
       }else {
            throw new IllegalArgumentException("Opción no válida");
        }

    }

    /**
     * Método que se utiliza al iniciar el programa
     * @param args arreglo de cadenas que contiene los argumentos de línea de comandos que se pasan al programa cuando se ejecuta
     */
    public static void main(String[] args) {
        //Mostrar menú con bucle infinito y romperlo con un break cuando el usuario seleccione opción de Salir
        while(true) {
            mostrarMenu();
            int opcion = leerOpcionDeUsuario();
            if(opcion == Operacion.SALIR)
            {
                System.out.println("Saliendo de la aplicación .....");
                break;
            }
            try {
                procesarOpcionDeUsuario(opcion);
            }catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}