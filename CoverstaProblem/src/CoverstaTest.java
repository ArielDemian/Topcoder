import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CoverstaTest {

	private Coversta c;

	@Before
	public void setUp() throws Exception {
		c = new Coversta();
	}

	@Test
	public void test0() {
		String[] a = { "11", "11" };
		int[] x = { 0, 0 };
		int[] y = { 0, 1 };
		int expected = 4;
		assertEquals(expected, c.place(a, x, y));
	}

	@Test
	public void test1() {
		String[] a = { "11", "11" };
		int[] x = { 0, 1 };
		int[] y = { 0, 1 };
		int expected = 3;
		assertEquals(expected, c.place(a, x, y));
	}

	@Test
	public void test2() {
		String[] a = { "15", "61" };
		int[] x = { 0 };
		int[] y = { 0 };
		int expected = 11;
		assertEquals(expected, c.place(a, x, y));
	}

	@Test
	public void test3() {
		String[] a = { "151", "655", "661" };
		int[] x = { 0, 0, -1 };
		int[] y = { 0, 1, 0 };
		int expected = 33;
		assertEquals(expected, c.place(a, x, y));
	}

	@Test
	public void test4() {
		String[] a = { "303", "333", "000" };
		int[] x = { -1, -1 };
		int[] y = { -1, 1 };
		int expected = 12;
		assertEquals(expected, c.place(a, x, y));
	}

	@Test
	public void test5() {
		String[] a = { "0000000", "1010101" };
		int[] x = { -1, -1 };
		int[] y = { -1, 1 };
		int expected = 0;
		assertEquals(expected, c.place(a, x, y));
	}

	@Test
	public void test6() {
		String[] a = { "88", "15", "23", "24", "66", "62" };
		int[] x = { 5, 4, 2, 0, 5, 1, -4, -3, -2 };
		int[] y = { 1, 0, -1, 0, 0, 0, 0, -1, -1 };
		int expected = 42;
		assertEquals(expected, c.place(a, x, y));
	}

}
