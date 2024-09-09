package com.kodigo.calculadora;

/**
 * Clase que representa una operación seleccionada por el usuario
 * @author edwin_rivas
 * @version 1.0
 */
public class Operacion {

    /**
     * Constante que representa opción de menú suma
     */
    public static final int SUMA = 1;
    /**
     * Constante que representa opción de menú resta
     */
    public static final int RESTA = 2;
    /**
     * Constante que representa opción de menú multiplicación
     */
    public static final int MULTIPLICACION = 3;
    /**
     * Constante que representa opción de menú división
     */
    public static final int DIVISION = 4;
    /**
     * Constante que representa opción de menú potencia
     */
    public  static final int POTENCIA = 5;
    /**
     * Constante que representa opción de menú raíz cuadrada
     */
    public static final int RAIZ_CUADRADA = 6;
    /**
     * Constante que representa opción de menú salir
     */
    public static  final int SALIR = 0;

    /**
     * Opción de menú
     */
    private int valor;

    /**
     * Inicializa una nueva operación con su valor
     * @param valor el valor de operación
     */
    public Operacion(int valor)
    {
        this.valor = valor;
    }

    /**
     * Obtiene el valor de operación
     * @return el valor de operación
     */
    public int getValor() {
        return valor;
    }

    /**
     * Establece el nuevo valor de operación
     * @param valor el nuevo valor de operación
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
}
