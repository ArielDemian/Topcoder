import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EditDistanceTest {
	private EditDistance e;

	@Before
	public void setUp() throws Exception {
		int ci = 1, cd = 1, cr = 1;
		e = new EditDistance(ci, cd, cr);
	}

	@Test
	public void test0() {
		String A = "cane";
		String B = "banche";
		int expected = 3;
		assertEquals(expected, e.edit(A, B));
	}
	
	@Test
	public void test1() {
		String A = "cat";
		String B = "mat";
		int expected = 1;
		assertEquals(expected, e.edit(A, B));
	}
	
	@Test
	public void test2() {
		String B = "did you mean";
		String A = "dd u meant";
		int expected = 1;
		assertEquals(expected, e.edit(A, B));
	}

}
