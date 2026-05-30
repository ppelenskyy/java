package colecciones_ejercicio;

public abstract class EstructuraMenu implements ComprobarNumero{
	
	protected abstract int mostrarMenu();
	protected abstract boolean addParticipante();
	protected abstract void mostrarTodosParticipantes();
	protected abstract boolean buscarParticipante();
	protected abstract boolean eliminarParticipante();
	protected abstract int numeroDeParticipantes();
	
	protected void switchMenu() {
		int opcion;
		boolean estado;
		do {
			opcion = mostrarMenu();
			switch(opcion) {
				case 1: {	
					estado = addParticipante();
					if (estado) {
						System.out.println("\n¡Participante añadido correctamente!");
						break;
					} 
					System.out.println("\n¡Participante no añadido!");
					break;
				}
				case 2: {
					mostrarTodosParticipantes();
					break;
				}
				case 3: {
					estado = buscarParticipante();
					if (estado) {
						System.out.println("\n¡Participante encontrado!");
						break;
					} 
					System.out.println("\n¡Participante no encontrado!");
					break;
				}
				case 4: {
					estado = eliminarParticipante();
					if (estado) {
						System.out.println("\n¡Participante eliminado correctamente!");
						break;
					} 
					System.out.println("\n¡Participante no encontrado!");
					break;
				}
				case 5: {
					int participantes = numeroDeParticipantes();
					if (participantes == 0) {
						System.out.println("\n¡No hay participantes almacenados!");
						break;
					}
					System.out.printf("\nNúmero de participantes: %d%n",participantes);
					break;
				}
				case 0: {
					System.out.println("\nVolviendo al menú principal...");
					break;
				}
				default: {
					System.out.println("\nElegir entre 0-5");
					break;
				}	
			}
		} while (opcion != 0);
	}
	
}
