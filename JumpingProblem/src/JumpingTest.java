import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JumpingTest {
	private Jumping j;

	@Before
	public void setUp() throws Exception {
		j = new Jumping();
	}

	@Test
	public void test0() {
		int x = 5;
		int y = 4;
		int[] jumpLengths = { 2, 5 };
		String expected = "Able";
		assertEquals(expected, j.ableToGet(x, y, jumpLengths));
	}

	@Test
	public void test1() {
		int x = 3;
		int y = 4;
		int[] jumpLengths = { 4 };
		String expected = "Not able";
		assertEquals(expected, j.ableToGet(x, y, jumpLengths));
	}

	@Test
	public void test2() {
		int x = 3;
		int y = 4;
		int[] jumpLengths = { 6 };
		String expected = "Not able";
		assertEquals(expected, j.ableToGet(x, y, jumpLengths));
	}

	@Test
	public void test3() {
		int x = 0;
		int y = 1;
		int[] jumpLengths = { 100, 100 };
		String expected = "Able";
		assertEquals(expected, j.ableToGet(x, y, jumpLengths));
	}

	@Test
	public void test4() {
		int x = 300;
		int y = 400;
		int[] jumpLengths = { 500 };
		String expected = "Able";
		assertEquals(expected, j.ableToGet(x, y, jumpLengths));
	}

	@Test
	public void test5() {
		int x = 11;
		int y = 12;
		int[] jumpLengths = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String expected = "Able";
		assertEquals(expected, j.ableToGet(x, y, jumpLengths));
	}

	@Test
	public void test6() {
		int x = 11;
		int y = 12;
		int[] jumpLengths = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 100 };
		String expected = "Not able";
		assertEquals(expected, j.ableToGet(x, y, jumpLengths));
	}
}