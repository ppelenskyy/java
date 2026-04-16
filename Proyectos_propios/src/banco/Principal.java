package banco;

/* Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular y cantidad (puede tener decimales).
 * 
 * El titular será obligatorio y la cantidad es opcional. Crea dos constructores que cumpla lo anterior.
 * 
 * Crea sus métodos get, set y toString.
 * 
 * Tendrá dos métodos especiales:
 * ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
 * retirar(double cantidad): se retira una cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0.
 * 
 * Tarea extra:
 * Como tenemos dos cuentas, comprobar primero el titular para poder ingresar, retirar o ver saldo.
 * Añadir la opción de transferencia bancaria.
 * Añadir la opción de ingresar o eliminar cuentas bancarias.
*/
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// Declaración del Scanner y creación de ArrayList.
		Scanner sc = new Scanner(System.in);
		ArrayList<Cuenta> listaUsuarios = new ArrayList<Cuenta>();
		
		// Declaración de variables.
		short opcion;
		String contraseña;
		
		// Crearión del objeto comun.
		Cuenta user = new Cuenta();
		
		do {
			user.mostrarMenuBanco();
			opcion = (short)user.revisarEntero(sc);
			
			switch(opcion) {
				// 1.- Acceso administradores.
				case 1: {
					System.out.print("Introducir contraseña: ");
					contraseña = sc.nextLine();
					if (user.comprobarAdmin(contraseña)) {
						user.switchAdmin(sc, listaUsuarios, user);
						break;
					}
					break;
				}
				
				// 2.- Acceso usuarios.
				case 2: {
					int indx;
					indx = user.comprobarExisteUser(sc, listaUsuarios);
					if (indx == -1 || indx == -2) break;
					else {
						Cuenta accesUser = listaUsuarios.get(indx);
						accesUser.switchUser(sc, listaUsuarios, accesUser);
						break;
					}
				}
				
				// 0.- Salir.
				case 0: {
					System.out.println("¡Hasta pronto!");
					break;
				}
				
				default: {
					System.out.println("Elegir entre [0-2]");
					break;
				}
			}	
		} while(opcion != 0);
	}

}
