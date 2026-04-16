package evaluable_entornos_3er_trimestre;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplicaTest {

	@Test
	public void testMultiplica() {
		System.out.println("Multiplica");
		int a = 2;
		int b = 2;
		Test1 instance = new Test1();
		int expResult = 4;
		int result = instance.multiplica(a, b);
		assertEquals(expResult, result);
	}

}
