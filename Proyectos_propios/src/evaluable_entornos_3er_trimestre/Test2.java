package evaluable_entornos_3er_trimestre;

public class Test2 {

	public int fahrenheitToCelsius(int f) {
		int c = (int) ((f - 32) / 1.8);
		return c;
	}
	
	public int celsiusToFahrenheit(int c) {
		int f = (int) (c * 1.8 + 32);
		return f;
	}
	
}
