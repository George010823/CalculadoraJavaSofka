import java.util.Scanner;

public class CalculadoraXConsola {
	
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
    	
    	boolean validador = true;
        double numero1 = obtenerNumero();
        char operador = obtenerOperador();
        double numero2 = obtenerNumero();
        double result = calc(numero1,numero2,operador);
        
        System.out.println("El resultado de la operación: "+result);
        
        while(validador == true) {
        	operador = obtenerOperador();
            numero2 = obtenerNumero();
            result = calc(result,numero2,operador);
            
            System.out.println("El resultado de la operación: "+result);
        }
    }
    

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
    
    public static double calc(double num1, double num2, char operador){
        double result;        
        while (true) {
        	switch (operador){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '%':
                result = num1%num2;
                break;
            case '/':
            	result = num1/num2;
            	if(Double.isInfinite(result)) {
            		result = num1/1;
            		System.out.println("No se puede realizar division por cero.");
            		System.out.println("Debe seguir trabajando con el ultimo resultado obtenido.");
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