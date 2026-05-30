package evaluable_entornos_3er_trimestre;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test3Test {

	@Test
	public void testDolarEuro() {
		System.out.println("Dólar a Euro");
		double d = 10.5;
		Test3 instance = new Test3();
		double expResult = 12.34;
		double result = instance.dolarEuro(d);
		assertEquals(expResult, result, 0.01);
	}

	@Test
	public void testEuroDolar() {
		System.out.println("Euro a Dólar");
		double e = 20.30;
		Test3 instance = new Test3();
		double expResult = 17.25;
		double result = instance.euroDolar(e);
		assertEquals(expResult, result, 0.01);
	}

}
