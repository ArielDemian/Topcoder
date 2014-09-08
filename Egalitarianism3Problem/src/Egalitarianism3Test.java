import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Egalitarianism3Test {
	private Egalitarianism3 e;

	@Before
	public void setUp() throws Exception {
		e = new Egalitarianism3();
	}

	@Test
	public void test0() {
		int n = 4;
		int[] a = { 1, 1, 1 };
		int[] b = { 2, 3, 4 };
		int[] len = { 1, 1, 1 };
		int expected = 3;
		assertEquals(expected, e.maxCities(n, a, b, len));
	}

	@Test
	public void test1() {
		int n = 6;
		int[] a = { 1, 2, 3, 2, 3 };
		int[] b = { 2, 3, 4, 5, 6 };
		int[] len = { 2, 1, 3, 2, 3 };
		int expected = 3;
		assertEquals(expected, e.maxCities(n, a, b, len));
	}

	@Test
	public void test2() {
		int n = 10;
		int[] a = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int[] b = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] len = { 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000 };
		int expected = 9;
		assertEquals(expected, e.maxCities(n, a, b, len));
	}

	@Test
	public void test3() {
		int n = 43;
		int[] a = { 7, 19, 7, 21, 10, 14, 25, 40, 14, 2, 10, 14, 7, 30, 18, 23, 30, 26, 17, 5, 30, 16, 30, 7, 7, 14, 25, 5, 31, 40, 14, 24, 13, 17, 9, 7, 42, 25, 2, 30, 43, 30 };
		int[] b = { 9, 13, 40, 19, 3, 6, 31, 30, 24, 28, 33, 27, 1, 23, 8, 2, 5, 42, 26, 17, 15, 20, 25, 36, 14, 38, 12, 22, 37, 16, 18, 41, 32, 39, 10, 29, 35, 21, 34, 43, 4, 11 };
		int[] len = { 10, 10, 6, 1, 7, 6, 8, 6, 2, 6, 7, 4, 1, 4, 5, 2, 4, 5, 5, 3, 1, 2, 2, 4, 5, 5, 2, 4, 10, 3, 10, 8, 4, 7, 10, 5, 1, 1, 7, 9, 5, 8 };
		int expected = 3;
		assertEquals(expected, e.maxCities(n, a, b, len));
	}

	@Test
	public void test4() {
		int n = 39;
		int[] a = { 35, 2, 36, 2, 20, 26, 35, 10, 20, 20, 20, 34, 10, 28, 15, 36, 36, 15, 30, 36, 36, 11, 32, 19, 34, 30, 15, 34, 36, 22, 10, 20, 8, 30, 25, 11, 20, 11 };
		int[] b = { 6, 21, 18, 38, 15, 27, 5, 4, 12, 36, 23, 22, 17, 7, 8, 37, 31, 11, 29, 34, 10, 32, 1, 3, 14, 19, 25, 35, 13, 24, 9, 30, 33, 39, 2, 26, 28, 16 };
		int[] len = { 7, 10, 9, 4, 3, 3, 8, 4, 9, 2, 4, 2, 5, 3, 2, 7, 1, 6, 10, 7, 7, 5, 7, 7, 5, 2, 8, 9, 6, 5, 1, 1, 9, 9, 9, 9, 3, 9 };
		int expected = 4;
		assertEquals(expected, e.maxCities(n, a, b, len));
	}
}
