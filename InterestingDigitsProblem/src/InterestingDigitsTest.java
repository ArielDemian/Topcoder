import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InterestingDigitsTest {
	private InterestingDigits id;

	@Before
	public void setUp() throws Exception {
		id = new InterestingDigits();
	}

	@Test
	public void test0() {
		int base = 10;
		int[] expect = { 3, 9 };
		int[] actual = id.digits(base);
		assertArrayEquals(expect, actual);
	}

	@Test
	public void test1() {
		int base = 3;
		int[] expect = { 2 };
		int[] actual = id.digits(base);
		assertArrayEquals(expect, actual);
	}

	@Test
	public void test2() {
		int base = 9;
		int[] expect = { 2, 4, 8 };
		int[] actual = id.digits(base);
		assertArrayEquals(expect, actual);
	}

	@Test
	public void test3() {
		int base = 26;
		int[] expect = { 5, 25 };
		int[] actual = id.digits(base);
		assertArrayEquals(expect, actual);
	}

	@Test
	public void test4() {
		int base = 30;
		int[] expect = { 29 };
		int[] actual = id.digits(base);
		assertArrayEquals(expect, actual);
	}

}
