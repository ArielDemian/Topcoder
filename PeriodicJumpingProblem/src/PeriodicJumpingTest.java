import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PeriodicJumpingTest {
	private PeriodicJumping p;

	@Before
	public void setUp() throws Exception {
		p = new PeriodicJumping();
	}

	@Test
	public void test0() {
		int x = 15;
		int[] jumpLengths = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int expected = 5;
		assertEquals(expected, p.minimalTime(x, jumpLengths));
	}

	@Test
	public void test1() {
		int x = 5;
		int[] jumpLengths = { 5 };
		int expected = 1;
		assertEquals(expected, p.minimalTime(x, jumpLengths));
	}

	@Test
	public void test2() {
		int x = 1;
		int[] jumpLengths = { 10 };
		int expected = 2;
		assertEquals(expected, p.minimalTime(x, jumpLengths));
	}

	@Test
	public void test3() {
		int x = -10;
		int[] jumpLengths = { 2, 3, 4, 500, 6, 7, 8 };
		int expected = 11;
		assertEquals(expected, p.minimalTime(x, jumpLengths));
	}

	@Test
	public void test4() {
		int x = -1000000000;
		int[] jumpLengths = { 1 };
		int expected = 1000000000;
		assertEquals(expected, p.minimalTime(x, jumpLengths));
	}

	@Test
	public void test5() {
		int x = 0;
		int[] jumpLengths = { 19911120 };
		int expected = 0;
		assertEquals(expected, p.minimalTime(x, jumpLengths));
	}
	
	@Test
	public void test6() {
		int x = 9;
		int[] jumpLengths = {772315883, 948801907, 98119050, 332167024, 90543450, 984872854, 38742565, 925804740, 773648065, 747538803, 418344074, 82024644, 908911712, 900413060, 567506548, 328888170, 679620977, 134381153, 917548834, 579233405, 989349349, 706906090, 52516266, 293093511, 11048303, 745411998, 531770467, 720217823, 140798884, 207817129, 33522981, 971002846, 890522096, 990265718, 358225050, 766726420, 355198127, 424365730, 331750579, 96129537, 64599184, 238258575, 455658049, 443945039, 21293907, 591926314, 803118293, 715681892, 979576220, 382647791};
		int expected = 4;
		assertEquals(expected, p.minimalTime(x, jumpLengths));
	}
}