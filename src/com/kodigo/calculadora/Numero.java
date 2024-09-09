package com.kodigo.calculadora;

/**
 * Clase que representa un número real
 * @author edwin_rivas
 * @version 1.0
 */
public class Numero {

    /**
     * Valor del número
     */
    private double valor;

    /**
     * Inicializa un nuevo número con su valor
     * @param valor el valor del número
     */
    public Numero(double valor)
    {
        this.valor = valor;
    }

    /**
     * Obtiene el valor del número
     * @return el valor del número
     */
    public double getValor() {
        return valor;
    }

    /**
     * Establece el valor del número
     * @param valor Establece el nuevo valor del número
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
}
