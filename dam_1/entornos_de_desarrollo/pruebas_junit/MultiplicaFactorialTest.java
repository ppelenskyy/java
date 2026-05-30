package pruebas_junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplicaFactorialTest {

	@Test
	public void test() {
		System.out.println("Multiplica");
		int a=2;
		int b=2;
		MultiplicaFactorial instance = new MultiplicaFactorial();
		int expResult=4;
		int result=instance.multiplica(a, b);
		assertEquals(expResult, result);
	}

}
