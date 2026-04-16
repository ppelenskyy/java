package evaluable_entornos_3er_trimestre;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test2Test {

	@Test
	public void testFahrenheitToCelsius() {
		System.out.println("Fahrenheit a Celsius");
		int f = 32;
		Test2 instance = new Test2();
		int expResult = 0;
		int result = instance.fahrenheitToCelsius(f);
		assertEquals(expResult, result);
	}

	@Test
	public void testCelsiusToFahrenheit() {
		System.out.println("Celsius a Fahrenheit");
		int c = 15;
		Test2 instance = new Test2();
		int expResult = 59;
		int result = instance.celsiusToFahrenheit(c);
		assertEquals(expResult, result);
	}

}
