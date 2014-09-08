import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuildingBridgesTest {
	private BuildingBridges bb;

	@Before
	public void setUp() throws Exception {
		bb = new BuildingBridges();
	}

	@Test
	public void test0() {
		double[] a = { 2, 5, 8, 10 };
		double[] b = { 6, 4, 1, 2 };
		int expected = 2;
		assertEquals(expected, bb.connect(a, b));
	}

	@Test
	public void test1() {
		double[] a = { 88, 54, 94, 78, 99, 53, 30, 41, 12, 92, 29, 71, 67, 18, 6, 7, 69, 55, 28, 38, 61, 73, 85, 43, 81, 21, 40, 93, 57, 11 };
		double[] b = { 6, 69, 3, 7, 63, 68, 19, 46, 44, 87, 23, 41, 91, 31, 61, 2, 8, 74, 33, 37, 4, 43, 83, 32, 28, 14, 17, 55, 75, 30 };
		int expected = 12;
		assertEquals(expected, bb.connect(a, b));
	}
}
