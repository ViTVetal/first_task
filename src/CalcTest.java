import static org.junit.Assert.*;

import org.junit.Test;


public class CalcTest {

	@Test
	public void testadd() {
		Calc Test_object = new Calc();
		double first = 5;
		double second = 5;
		String task = "+";
		Test_object.fill_command(first, second);
		double result = Test_object.read(task);
		assertEquals(Double.doubleToLongBits(10), Double.doubleToLongBits(result));
	}
	@Test
	public void testsub() {
		Calc Test_object = new Calc();
		double first = 5;
		double second = 5;
		String task = "-";
		Test_object.fill_command(first, second);
		double result = Test_object.read(task);
		assertEquals(Double.doubleToLongBits(0), Double.doubleToLongBits(result));
	}
	@Test
	public void testmult() {
		Calc Test_object = new Calc();
		double first = 5;
		double second = 5;
		String task = "*";
		Test_object.fill_command(first, second);
		double result = Test_object.read(task);
		assertEquals(Double.doubleToLongBits(25), Double.doubleToLongBits(result));
	}
	@Test
	public void testdiv() {
		Calc Test_object = new Calc();
		double first = 5;
		double second = 5;
		String task = "/";
		Test_object.fill_command(first, second);
		double result = Test_object.read(task);
		assertEquals(Double.doubleToLongBits(1), Double.doubleToLongBits(result));
	}
	@Test
	public void testfact() {
		Calc Test_object = new Calc();
		double first = 5;
		String task = "!";
		Test_object.fill_command(first);
		double result = Test_object.read(task);
		assertEquals(Double.doubleToLongBits(120), Double.doubleToLongBits(result));
	}
	@Test
	public void testsin() {
		Calc Test_object = new Calc();
		double first = 0;
		String task = "sin";
		Test_object.fill_command(first);
		double result = Test_object.read(task);
		assertEquals(Double.doubleToLongBits(0), Double.doubleToLongBits(result));
	}
	@Test
	public void testcos() {
		Calc Test_object = new Calc();
		double first = 0;
		String task = "cos";
		Test_object.fill_command(first);
		double result = Test_object.read(task);
		assertEquals(Double.doubleToLongBits(1), Double.doubleToLongBits(result));
	}
	@Test
	public void testsqrt() {
		Calc Test_object = new Calc();
		double first = 9;
		String task = "sqrt";
		Test_object.fill_command(first);
		double result = Test_object.read(task);
		assertEquals(Double.doubleToLongBits(3), Double.doubleToLongBits(result));
	}
	@Test
	public void testdegr() {
		Calc Test_object = new Calc();
		double first = 3;
		double second = 3;
		String task = "^";
		Test_object.fill_command(first, second);
		double result = Test_object.read(task);
		assertEquals(Double.doubleToLongBits(27), Double.doubleToLongBits(result));
	}
}
