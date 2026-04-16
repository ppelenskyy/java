package colecciones_ejercicio;

public class GestionColecciones implements ComprobarNumero {
	
	protected void switchPrincipal(){
		EstructuraMenu e;
		int opcion;	
		do {
			opcion = mostrarMenuTipos();
			switch (opcion) {
				case 1: {
					e = new Conjunto();
					e.switchMenu();
					break;
				}
				case 2: {
					e = new Lista();
					e.switchMenu();
					break;
				}
				case 3: {
					e = new Diccionario();
					e.switchMenu();
					break;
				}
				case 4: {
					e = new Cola();
					e.switchMenu();
					break;
				}
				case 5: {
					e = new Pila();
					e.switchMenu();
					break;
				}
				case 0: {
					System.out.println("\n--- HASTA PRONTO ---");
					break;
				}
				default: {
					System.out.println("\nElegir entre 0-5");
					break;
				}
			}
		} while (opcion != 0);
	}
	
	protected int mostrarMenuTipos() {
		System.out.printf(""" 
		
		┌───────────────────────────────────────────────────────────┐
		│            MENÚ DE ELECCIÓN DE TIPO DE COLECCIÓN          │
		├───────────────────────────────────────────────────────────┤
		│ [1] - Set   (HashSet)                                     │
		│ [2] - List  (ArrayList)                                   │
		│ [3] - Map   (HashMap)                                     │
		│ [4] - Queue (PriorityQueue)                               │
		│ [5] - Deque                                               │
		│───────────────────────────────────────────────────────────│
		│ [0] - Salir                                               │ 
		└───────────────────────────────────────────────────────────┘
		""");
		System.out.print("Entrada: ");
		return comprobarInt();
	}
}
