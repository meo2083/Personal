package com.kodigo.calculadora;

/**
 * Clase que realiza operación de suma,resta,multiplicación,división,potencia entre 2 números y la raíz cuadrada de un número.
 * <p>Realiza la operación que selecciona el usuario de un menú de opciones.</p>
 * @author edwin_rivas
 * @version 1.0
 */
public class Calculadora {

    /**
     * Primer número para operación de calculadora. Se asegura con final para que no pueda cambiar después de ser inicializada
     */
    private final Numero numero1;
    /**
     * Segundo número para operación de calculadora. Se asegura con final para que no pueda cambiar después de ser inicializada
     */
    private final Numero numero2;
    /**
     * Operación que debe realizar la calculadora. Se asegura con final para que no pueda cambiar después de ser inicializada
     */
    private final Operacion operacion;

    /**
     * Inicializa una nueva calculadora con los números a procesar y operación seleccionada
     * @param numero1 Primer número
     * @param numero2 Segundo número. En el caso de operación de raíz cuadrada no se toma en cuenta, pero si debe pasar un valor (se está pasando null)
     * @param operacion Operación seleccionada por el usuario
     */
    public Calculadora(Numero numero1, Numero numero2, Operacion operacion)
    {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacion = operacion;
    }

    /**
     * Método que reliza el cálculo de operación según opción seleccionada por el usuario e imprime su resultado
     * @throws ArithmeticException Si en la operación de división el denominador es 0 o si en la operación de raíz cuadrada el número es negativo
     * @throws IllegalArgumentException Para operación de potencia en los casos que la base es negativa o 0 y el exponente una fracción, también cuando la combinación de base y exponente puede causar un desbordamiento
     */
    public void Calcular() throws ArithmeticException,IllegalArgumentException
    {
        Numero resultado = new Numero(0.0);
        if(operacion.getValor() == Operacion.RAIZ_CUADRADA)
        {
            if(numero1.getValor() < 0)
            {
                throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo");
            }
            resultado.setValor(Math.sqrt(numero1.getValor()));
        }
        else if(operacion.getValor() == Operacion.POTENCIA)
        {
            // Comprobar si la base es cero y el exponente es negativo
            if (numero1.getValor() == 0 && numero2.getValor() < 0) {
                throw new IllegalArgumentException("La base no puede ser cero cuando el exponente es negativo.");
            }

            // Comprobar si la base es negativa y el exponente es fraccionario
            if (numero1.getValor() < 0 && (numero2.getValor() % 1 != 0)) {
                throw new IllegalArgumentException("La base no puede ser negativa cuando el exponente es una fracción.");
            }

            // Comprobar si la base y el exponente pueden llevar a un desbordamiento
            if (isPotentialOverflow(numero1.getValor(), numero2.getValor())) {
                throw new IllegalArgumentException("La combinación de base y exponente puede causar desbordamiento.");
            }
            resultado.setValor(Math.pow(numero1.getValor(), numero2.getValor()));
        }
        else if(operacion.getValor() == Operacion.SUMA){
            resultado.setValor(numero1.getValor() + numero2.getValor());
        }
        else if(operacion.getValor() == Operacion.RESTA){
            resultado.setValor(numero1.getValor() - numero2.getValor());
        }
        else if(operacion.getValor() == Operacion.MULTIPLICACION){
            resultado.setValor(numero1.getValor() * numero2.getValor());
        }
        else if(operacion.getValor() == Operacion.DIVISION){
            //Validar que no se pueda dividir por cero
            if(numero2.getValor() == 0)
            {
                throw new ArithmeticException("No se puede dividir por cero");
            }
            resultado.setValor(numero1.getValor() / numero2.getValor());
        }
        System.out.println("Resultado: "+resultado.getValor());
    }

    /**
     * Método para verificar si hay desbordamiento al elevar un número a una potencia
     * @param base es la base
     * @param exponent el el exponente
     * @return true si producirá desbordamiento y false en caso contrario
     */
    private boolean isPotentialOverflow(double base, double exponent) {
        // Definir umbrales para evitar desbordamientos
        double MAX_VALUE = Double.MAX_VALUE;

        // Probar el cálculo en una escala reducida y ver si puede exceder los límites
        double scaledBase = Math.min(base, Math.cbrt(MAX_VALUE));
        double scaledExponent = Math.min(exponent, 1000.0);

        double testResult = Math.pow(scaledBase, scaledExponent);

        // Verificar si el resultado de testResult puede ser infinito
        return Double.isInfinite(testResult);
    }
}
