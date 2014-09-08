import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StoneRemovingTest {
	private StoneRemoving s;

	@Before
	public void setUp() throws Exception {
		s = new StoneRemoving();
	}

	@Test
	public void test0() {
		int n = 8;
		int k = 5;
		int m = 3;
		int expected = 1;
		assertEquals(expected, s.stoneLeft(n, k, m));
	}
	
	@Test
	public void test1() {
		int n = 100;
		int k = 9999;
		int m = 98;
		int expected = 93;
		assertEquals(expected, s.stoneLeft(n, k, m));
	}
	
	@Test
	public void test2() {
		int n = 10000;
		int k = 10000;
		int m = 10000;
		int expected = 2019;
		assertEquals(expected, s.stoneLeft(n, k, m));
	}
}