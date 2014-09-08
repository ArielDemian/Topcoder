import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PricingTest {
	private Pricing pr;

	@Before
	public void setUp() throws Exception {
		pr = new Pricing();
	}

	@Test
	public void test0() {
		int[] price = { 9, 1, 5, 5, 5, 5, 4, 8, 80 };
		assertEquals(120, pr.maxSales(price));
	}

	@Test
	public void test1() {
		int[] price = { 17, 50, 2 };
		assertEquals(69, pr.maxSales(price));
	}

	@Test
	public void test2() {
		int[] price = { 130, 110, 90, 13, 6, 5, 4, 3, 0 };
		assertEquals(346, pr.maxSales(price));
	}

	@Test
	public void test3() {
		int[] price = { 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1 };
		assertEquals(80, pr.maxSales(price));
	}
}
