package clase_persona;

public class Persona {
	// Atributos o propiedades.
	protected final char HOMBRE = 'H', MUJER = 'M';
	protected final String DNI = "00000000X";
	protected final char SEXO = HOMBRE;
	protected char sexo;
	protected int edad;
	protected double peso, altura;
	protected String nombre, dni;
	
	// Constructores.
	protected Persona() {
		dni = DNI;
		sexo = SEXO;
	}
	
	protected Persona(String nombre, int edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = comprobarSexo(sexo);
		dni = DNI;
	}
	
	protected Persona(String nombre, int edad, String dni, char sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.sexo = comprobarSexo(sexo);
		this.peso = peso;
		this.altura = altura;
	}
	// Set.
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected void setEdad(int edad) {
		this.edad = edad;
	}

	protected void setSexo(char sexo) {
		comprobarSexo(sexo);
	}

	protected void setPeso(double peso) {
		this.peso = peso;
	}

	protected void setAltura(double altura) {
		this.altura = altura;
	}
	
	// Métodos.
	/* · calcularIMC(): calculara si la persona esta en su peso ideal (peso en kg/(altura^2  en m)), 
	 *  · si esta fórmula devuelve un valor menor que 20, la función devuelve un -1, 
	 *  · si devuelve un número entre 20 y 25 (incluidos), significa que esta por debajo de su peso ideal la función devuelve un 0  y 
	 * 	· si devuelve un valor mayor que 25 significa que tiene sobrepeso, la función devuelve un 1. 
	 */
	protected int calcularIMC() {
		double result;
		
		result = peso/(altura*altura);
		
		if (peso == 0 || altura == 0) return -2;
		else if (result < 20) return -1;
		else if (result >= 20 && result <= 25) return 0;
		else return 1;
		
	}
	
	// · esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
	protected boolean esMayorDeEdad() {
		if (edad > 17) return true; 
		else return false;
	}
	
 
	/* · comprobarSexo(char sexo): comprueba que el sexo introducido es correcto. 
	 *	· Si no es correcto, sera H. 
	 *  · No sera visible al exterior.
	 */
	private char comprobarSexo(char sexo) {
		if (sexo == 'M') return MUJER;
		else if (sexo == 'H') return HOMBRE;
		else return HOMBRE;
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------
	// METODOS ADICIONALES
	//----------------------------------------------------------------------------------------------------------------------------------
	
	// Método para mostrar toda la información.
	protected void mostrarTodo() {		
		System.out.println("Nombre: "+nombre+" edad: "+edad+" años DNI: "+dni+" sexo: "+sexo+" peso: "+peso+" kg altura: "+altura+" m.");
	}
	
	// Método para mostar imc.
	protected void mostrarImc() {		
		if (calcularIMC() == 0) System.out.println(nombre+" tiene - Peso ideal.");
		else if (calcularIMC() == 1) System.out.println(nombre+" tiene - Sobrepeso.");
		else if (calcularIMC() == -2) System.out.println(nombre+" error - valor de peso o altura = 0.");
		else System.out.println(nombre+" tiene - Bajo peso.");
	}
	
	// Método para mostrar si es mayor de edad.
	protected void mostrarMayorDeEdad() {
		String mayorEdad;
			
		mayorEdad = esMayorDeEdad()?"Mayor de edad.":"menor de edad.";
		System.out.println(nombre+" con edad: "+edad+" años es "+mayorEdad);
	}
	
	// Método para separar visualmente en la consola.
	protected void separar() {
		System.out.println("\n_______________________________________________________________________________");
	}

}
