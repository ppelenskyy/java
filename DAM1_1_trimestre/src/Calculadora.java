/* 2.-
 * Debes de crear una calculadora. La aplicación mostrará un menú con las
 * operaciones que puede realizar (sumar, restar, multiplicar, dividir y resto).
 * También debe pedir al usuario que introduzca los dos números. Para la operación
 * de restar debemos de comprobar que reste el número mayor menos el menor, es
 * decir que si el usuario introduce, por ejemplo, 5 y 7 deberá hacer 7-5, no puede
 * dar un número negativo. Para la operación división el divisor no podrá ser cero, en
 * dicho caso le mostrará un mensaje diciendo que no se puede hacer la división.
 */

import java.util.Scanner;

public class Calculadora {
	
    public static void main(String[] args) {
        // Asignar objeto
	    Scanner sc = new Scanner(System.in);
	
	    // Creación de variables
	    String operacion;
	    double num1, num2, resultado = 0;
	
	    // Operaciones
        System.out.print("Introduzca el primer nuemro: ");
        num1 = sc.nextDouble();
        System.out.print("Introduzca el segundo nuemro: ");
        num2 = sc.nextDouble();
        
        // Limpiar el buffer
        sc.nextLine();
        
        // Menú
	    System.out.println("---Menu operaciones---");
	    System.out.println("1- +");
	    System.out.println("2- -");
	    System.out.println("3- *");
	    System.out.println("4- /");
	    System.out.println("5- %");
        
	    operacion = sc.nextLine();
	    
	    // Operaciones y Resultados   
        if (operacion.equals("1") || operacion.equals("+")) {
        	resultado = num1 + num2;
            System.out.println("El resultado es: "+resultado);
        }
        
        else if (operacion.equals("2") || operacion.equals("-")) {
        	if (num2 > num1) {
        		resultado = num2 - num1;
                System.out.println("El resultado es: "+resultado);
        	}
        	else {
        	    resultado = num1 - num2;
                System.out.println("El resultado es: "+resultado);   
        	}		
        } 
        
        else if (operacion.equals("3") || operacion.equals("*")) {
        	resultado = num1 * num2;
            System.out.println("El resultado es: "+resultado);   
        }
        
        else if (operacion.equals("4") || operacion.equals("/")){
        	if (num1 == 0 || num2 == 0) {
        	System.out.println("No se puede dividir entre 0");
        	}
        	else {
            resultado = num1 / num2;
            System.out.println("El resultado es: "+resultado);
        	}
        }
        
        else if (operacion.equals("5") || operacion.equals("%")) {
        	resultado = num1 % num2;
            System.out.println("El resultado es: "+resultado);
        }
        
        else {
        	System.out.println("Selección incorrecta");
        }
        sc.close();
    }   
}
