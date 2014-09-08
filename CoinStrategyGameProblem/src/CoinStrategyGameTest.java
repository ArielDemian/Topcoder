import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoinStrategyGameTest {
	private CoinStrategyGame c;

	@Before
	public void setUp() throws Exception {
		c = new CoinStrategyGame();
	}

	@Test
	public void test0() {
		int[] v = { 3, 35, 12, 1, 298, 5 };
		int expected = 313;
		assertEquals(expected, c.win(v));
	}

}
