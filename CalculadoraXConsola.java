import java.util.Scanner;
/**
 * Programación de una calculadora por consola donde se puede seguir realizando la ooperacion que se 
 * desee con el resultado obtenido
 * @author Jorge Gomez
 *
 */
public class CalculadoraXConsola {
	/**
	 * Se instancia la clase scanner para la captura de datos por consola
	 */
    static Scanner scanner = new Scanner(System.in);
    /**
     * Declaracion de la clase principal main para la ejecución del programa
     * 
     */
    public static void main(String[] args) {
    	/**
    	 * Declaración de variables.
    	 * @params validador variable booleana para que la calculadora trabaje de forma continua.
    	 * @params numero1 Primer operando de la calculadora.
    	 * @params numero2 Segundo operando de la calculadora.
    	 * @params operador variable que indica la operación a realizar entro los operandos.
    	 * @params result Variable que almacena el ultimo valor para seguir operando con ella.
    	 */
    	boolean validador = true;
        double numero1 = obtenerNumero();
        char operador = obtenerOperador();
        double numero2 = obtenerNumero();
        double result = calc(numero1,numero2,operador);
        
        System.out.println("El resultado de la operación: "+result);
        /**
         * Ciclo que permite que la calculadora trabaje continuamente. Y mostrar su resultado.
         */
        while(validador == true) {
        	operador = obtenerOperador();
            numero2 = obtenerNumero();
            result = calc(result,numero2,operador);
            
            System.out.println("El resultado de la operación: "+result);
        }
    }
    
/**
 * Obtener los números digitados por el usuario y valida que si sea un número.
 * @return El número digitado.
 */
    public static double obtenerNumero(){
        System.out.println("Introduzca un número:");
        double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
        } else {
            System.out.println("Te has equivocado al introducir el número. Inténtalo de nuevo.");
            scanner.next();//recursividad
            num = obtenerNumero();
        }
        return num;
    }
    /**
     * Obtener el operador digitado por el usuario validando qeu sea el primer caracter de la cadena.
     * @return De ser valido el simbolo para realizar la operación.
     */
    public static char obtenerOperador(){
        System.out.println("Introduzca el operador:");
        char operador;
        if(scanner.hasNext()){
        	operador = scanner.next().charAt(0);
        } else {
            System.out.println("Ha cometido un error al entrar en la operación. Inténtalo de nuevo.");
            scanner.next();//recursividad
            operador = obtenerOperador();
        }
        return operador;
    }
    /**
     * Metodo y Ciclo que validan el tipo de operación a realizar, realiza la operación y devuleve el resultado.
     * @param num1 Primer operando de la calculadora.
     * @param num2 Segundo operando de la calculadora.
     * @param operador simbolo para realizar la operación.
     * @return
     */
    public static double calc(double num1, double num2, char operador){
        double result;        
        while (true) {
        	/**
        	 * Seún el simbolo de operador entrgado, selecciona uno de los casos expuestos y realiza la operación.
        	 */
        	switch (operador){
        	/**
        	 * Este caso realiza la suma.
        	 */
            case '+':
                result = num1+num2;
                break;
                /**
            	 * Este caso realiza la resta.
            	 */
            case '-':
                result = num1-num2;
                break;
                /**
            	 * Este caso realiza la multiplicación.
            	 */
            case '*':
                result = num1*num2;
                break;
                /**
            	 * Este caso realiza el modulo de la division.
            	 */
            case '%':
                result = num1%num2;
                break;
                /**
                 * @throws Lanza un mensaje cuando se intenta dividir por cero
                 * Este caso realiza la division.
                 */
            case '/':
            	result = num1/num2;
            	if(Double.isInfinite(result)) {
            		throw new ArithmeticException("No se puede realizar division por cero.");
            	}
            	break;
            default:
                System.out.println("La operación no se reconoce. Repite la entrada.");
                result = calc(num1, num2, obtenerOperador());//recursividad
        	}
        return result;
        }
        
    }
}