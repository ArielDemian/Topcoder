import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoxStackingTest {
	private BoxStacking b;
	private double epsilon;

	@Before
	public void setUp() throws Exception {
		b = new BoxStacking();
		epsilon = 0.0001;
	}

	@Test
	public void test() {
		double[] h = { 4, 1, 4, 10 };
		double[] d = { 6, 2, 5, 12 };
		double[] w = { 7, 3, 6, 32 };
		double expected = 60;
		assertEquals(expected, b.stack(h, w, d), epsilon);
	}

}
