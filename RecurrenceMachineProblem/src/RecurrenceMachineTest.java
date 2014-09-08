import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RecurrenceMachineTest {
	private RecurrenceMachine rm;

	@Before
	public void setUp() throws Exception {
		rm = new RecurrenceMachine();
	}

	/*@Test
	public void test0() {
		int k = 2;
		int j = 3;
		String expected = "3873##2908##3690";
		assertEquals(expected, rm.calculate(k, j));
	}

	@Test
	public void test1() {
		int k = 4;
		int j = 2;
		String expected = "58563##44023##56265";
		assertEquals(expected, rm.calculate(k, j));
	}

	@Test
	public void test2() {
		int k = 2;
		int j = 6;
		String expected = "13467918##10129978##12993165";
		assertEquals(expected, rm.calculate(k, j));
	}*/

	@Test
	public void test3() {
		int k = 999999;
		int j = 1000000;
		String expected = "13467918##10129978##12993165";
		assertEquals(expected, rm.calculate(k, j));
	}
}