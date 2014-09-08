import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CollisionTest {
	private Collision c;

	@Before
	public void setUp() throws Exception {
		c = new Collision();
	}

	@Test
	public void test0() {
		int[] assignments = { 20, 20 };
		int ids = 1000;
		double expected = 0.2113618990410422;
		assertEquals(expected, c.probability(assignments, ids), 1e-9);
	}

	@Test
	public void test1() {
		int[] assignments = { 123, 456 };
		int ids = 123456;
		double expected = 0.3769052883184334;
		assertEquals(expected, c.probability(assignments, ids), 1e-9);
	}

	@Test
	public void test2() {
		int[] assignments = { 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000 };
		int ids = 2147483647;
		double expected = 0.0069090268185510555;
		assertEquals(expected, c.probability(assignments, ids), 1e-9);
	}

	@Test
	public void test3() {
		int[] assignments = { 1005, 1005 };
		int ids = 1000;
		double expected = 0.0;
		assertEquals(expected, c.probability(assignments, ids), 1e-9);
	}
}