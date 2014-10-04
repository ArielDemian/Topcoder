import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ShoppingSurveyDiv2Test {
	private ShoppingSurveyDiv2 ss;

	@Before
	public void setUp() throws Exception {
		ss = new ShoppingSurveyDiv2();
	}

	@Test
	public void test0() {
		int n = 5;
		int[] s = { 3, 3 };
		int expected = 1;
		assertEquals(expected, ss.minValue(n, s));
	}

	@Test
	public void test1() {
		int n = 100;
		int[] s = { 97 };
		int expected = 97;
		assertEquals(expected, ss.minValue(n, s));
	}

	@Test
	public void test2() {
		int n = 10;
		int[] s = { 9, 9, 9, 9, 9 };
		int expected = 5;
		assertEquals(expected, ss.minValue(n, s));
	}

	@Test
	public void test3() {
		int n = 7;
		int[] s = { 1, 2, 3 };
		int expected = 0;
		assertEquals(expected, ss.minValue(n, s));
	}

	@Test
	public void test4() {
		int n = 5;
		int[] s = { 3, 3, 3 };
		int expected = 0;
		assertEquals(expected, ss.minValue(n, s));
	}
}