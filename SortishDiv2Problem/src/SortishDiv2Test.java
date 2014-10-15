import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SortishDiv2Test {
	private SortishDiv2 s;

	@Before
	public void setUp() throws Exception {
		s = new SortishDiv2();
	}

	@Test
	public void test0() {
		int sortedness = 5;
		int[] seq = { 4, 0, 0, 2, 0 };
		int expected = 2;
		assertEquals(expected, s.ways(sortedness, seq));
	}
}