import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PrivatepartyTest {
	private Privateparty p;

	@Before
	public void setUp() throws Exception {
		p = new Privateparty();
	}

	@Test
	public void test0() {
		int[] a = { 0, 1 };
		double expected = 2.0;
		assertEquals(expected, p.getexp(a), 10 ^ -9);
	}

	@Test
	public void test1() {
		int[] a = { 0, 0 };
		double expected = 1.5;
		assertEquals(expected, p.getexp(a), 10 ^ -9);
	}

	@Test
	public void test2() {
		int[] a = { 0, 1, 1 };
		double expected = 2.5;
		assertEquals(expected, p.getexp(a), 10 ^ -9);
	}

	@Test
	public void test3() {
		int[] a = { 0, 1, 1, 2 };
		double expected = 3.166666666666667;
		assertEquals(expected, p.getexp(a), 10 ^ -9);
	}

	@Test
	public void test4() {
		int[] a = { 3, 2, 1, 0 };
		double expected = 2.0;
		assertEquals(expected, p.getexp(a), 10 ^ -9);
	}

	@Test
	public void test5() {
		int[] a = { 0, 1, 1, 2 };
		double expected = 3.0;
		assertEquals(expected, p.getExactExp(a), 10 ^ -9);
	}

}
