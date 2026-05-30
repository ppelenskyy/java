/*  - Haz una clase llamada Persona que siga las siguientes condiciones:
 *  
 *  - Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura. Si quieres añadir algún atributo puedes hacerlo.
 *    Por defecto, todos los atributos menos el DNI serán valores por defecto según su tipo (0 números, cadena vacía para String, etc.). 
 *    Sexo sera hombre por defecto, usa una constante para ello.
 *  
 *  - Se implantaran varios constructores:
 *  	· Un constructor por defecto.
 *  	· Un constructor con el nombre, edad y sexo, el resto por defecto.
 *  	· Un constructor con todos los atributos como parámetro.
 *  
 *  - Los métodos que se implementaran son:
 *  	· calcularIMC(): calculara si la persona esta en su peso ideal (peso en kg/(altura^2  en m)), 
 *  		· si esta fórmula devuelve un valor menor que 20, la función devuelve un -1, 
 *  		· si devuelve un número entre 20 y 25 (incluidos), significa que esta por debajo de su peso ideal la función devuelve un 0  y 
 *  		· si devuelve un valor mayor que 25 significa que tiene sobrepeso, la función devuelve un 1. 
 *  	  	Te recomiendo que uses constantes para devolver estos valores.
 *  	· esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
 *  	· comprobarSexo(char sexo): comprueba que el sexo introducido es correcto. 
 *  		· Si no es correcto, sera H. 
 *  		· No sera visible al exterior.
 *  
 *  - Métodos set de cada parámetro, excepto de DNI.
 *  
 *  - Ahora, crea una clase ejecutable que haga lo siguiente:
 * 		· Pide por teclado el nombre, la edad, sexo, peso y altura.
 *  	· Crea 3 objetos de la clase anterior, 
 *  		· el primer objeto obtendrá las anteriores variables pedidas por teclado, 
 *  		· el segundo objeto obtendrá todos los anteriores menos el peso y la altura y 
 *  		· el último por defecto, para este último utiliza los métodos set para darle a los atributos un valor.
 *  	· Para cada objeto, deberá comprobar si esta en su peso ideal, tiene sobrepeso o por debajo de su peso ideal con un mensaje.
 *  	· Indicar para cada objeto si es mayor de edad.
 *  	· Por último, mostrar la información de cada objeto.
*/

package clase_persona;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char sexo;
		int edad;
		double peso, altura;
		String nombre;
		
		System.out.println("┌──────────────────────┐");
		System.out.println("│   DATOS DE PERSONA   │");
		System.out.println("└──────────────────────┘");
		System.out.print("  Nombre: ");
		nombre = sc.nextLine().toUpperCase().trim();
		System.out.print("  Edad: ");
		edad = sc.nextInt();
		System.out.print("  Sexo [H/M]: ");
		sexo = sc.next().toUpperCase().charAt(0);
		System.out.print("  Peso: ");
		peso = sc.nextDouble();
		System.out.print("  Altura [metros]: ");
		altura = sc.nextDouble();
		
		// · el primer objeto obtendrá las anteriores variables pedidas por teclado. 
		Persona p1 = new Persona(nombre, edad, sexo);
		p1.setPeso(peso);
		p1.setAltura(altura);
		
		// · el segundo objeto obtendrá todos los anteriores menos el peso y la altura.
		Persona p2 = new Persona(nombre, edad, sexo);
		
		// · el último por defecto, para este último utiliza los métodos set para darle a los atributos un valor.
		Persona p3 = new Persona();
		p3.setNombre("MARTA");
		p3.setEdad(17);
		p3.setSexo('M');
		p3.setPeso(56.7);
		p3.setAltura(1.62);
		
		// · Para cada objeto, deberá comprobar si esta en su peso ideal, tiene sobrepeso o por debajo de su peso ideal con un mensaje.
		p1.separar();
		p1.mostrarImc();	
		p2.mostrarImc();	
		p3.mostrarImc();	
		
		// · Indicar para cada objeto si es mayor de edad.
		p1.separar();
		p1.mostrarMayorDeEdad();
		p2.mostrarMayorDeEdad();
		p3.mostrarMayorDeEdad();

		// · Por último, mostrar la información de cada objeto.nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura.
		p1.separar();
		p1.mostrarTodo();
		p2.mostrarTodo();
		p3.mostrarTodo();

		sc.close();
	}
		
}
