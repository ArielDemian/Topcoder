import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PiecewiseLinearFunctionDiv2Test {
	private PiecewiseLinearFunctionDiv2 p;

	@Before
	public void setUp() throws Exception {
		p = new PiecewiseLinearFunctionDiv2();
	}

	@Test
	public void test0() {
		int[] Y = { 1, 4, -1, 2 };
		int[] query = { -2, -1, 0, 1 };
		int[] expected = { 0, 1, 2, 3 };
		assertArrayEquals(expected, p.countSolutions(Y, query));
	}
}