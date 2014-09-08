import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PowerOutageTest {
	private PowerOutage p;

	@Before
	public void setUp() throws Exception {
		p = new PowerOutage();
	}

	@Test
	public void test0() {
		int[] fromJunction = { 0 };
		int[] toJunction = { 1 };
		int[] ductLength = { 10 };
		int expected = 10;
		assertEquals(expected, p.estimateTimeOut(fromJunction, toJunction, ductLength));
	}

	@Test
	public void test1() {
		int[] fromJunction = { 0, 1, 0 };
		int[] toJunction = { 1, 2, 3 };
		int[] ductLength = { 10, 10, 10 };
		int expected = 40;
		assertEquals(expected, p.estimateTimeOut(fromJunction, toJunction, ductLength));
	}

	@Test
	public void test2() {
		int[] fromJunction = { 0, 0, 0, 1, 4 };
		int[] toJunction = { 1, 3, 4, 2, 5 };
		int[] ductLength = { 10, 10, 100, 10, 5 };
		int expected = 165;
		assertEquals(expected, p.estimateTimeOut(fromJunction, toJunction, ductLength));
	}

	@Test
	public void test3() {
		int[] fromJunction = { 0, 0, 0, 1, 4, 4, 6, 7, 7, 7, 20 };
		int[] toJunction = { 1, 3, 4, 2, 5, 6, 7, 20, 9, 10, 31 };
		int[] ductLength = { 10, 10, 100, 10, 5, 1, 1, 100, 1, 1, 5 };
		int expected = 281;
		assertEquals(expected, p.estimateTimeOut(fromJunction, toJunction, ductLength));
	}

	@Test
	public void test4() {
		int[] fromJunction = { 0, 0, 0, 0, 0 };
		int[] toJunction = { 1, 2, 3, 4, 5 };
		int[] ductLength = { 100, 200, 300, 400, 500 };
		int expected = 2500;
		assertEquals(expected, p.estimateTimeOut(fromJunction, toJunction, ductLength));
	}

	@Test
	public void test5() {
		int[] fromJunction = { 0, 0, 1, 1, 0, 1, 5, 3, 5, 2, 1, 4, 10, 6, 5, 1, 4, 4, 14, 15, 0, 15 };
		int[] toJunction = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
		int[] ductLength = { 376211, 1482872, 1905579, 1145345, 438770, 998746, 1459100, 1878278, 219472, 959127, 1267487, 1347437, 936337, 854433, 684756, 1060117, 1881497, 446829, 1659636, 1807314, 1890011, 901122 };
		int expected = 47040884;
		assertEquals(expected, p.estimateTimeOut(fromJunction, toJunction, ductLength));
	}
}
