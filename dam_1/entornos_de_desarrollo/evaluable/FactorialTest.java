package evaluable_entornos_3er_trimestre;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void testFactorial() {
		System.out.println("Factorial");
		int numero = 3;
		Test1 instance = new Test1();
		int expResult = 6;
		int result = instance.factorial(numero);
		assertEquals(expResult, result);
	}

}
