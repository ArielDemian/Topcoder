import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DotNotationTest {
	private DotNotation d;

	@Before
	public void setUp() throws Exception {
		d = new DotNotation();
	}

	@Test
	public void test1() {
		String dotForm = "9+5*3";
		int expected = 2;
		assertEquals(expected, d.countAmbiguity(dotForm));
	}

	@Test
	public void test2() {
		String dotForm = "9+5.*3";
		int expected = 1;
		assertEquals(expected, d.countAmbiguity(dotForm));
	}

	@Test
	public void test3() {
		String dotForm = "1+2.*.3+4";
		int expected = 1;
		assertEquals(expected, d.countAmbiguity(dotForm));
	}

	@Test
	public void test4() {
		String dotForm = "9*8+7*6-5+4*3/2./9";
		int expected = 99;
		assertEquals(expected, d.countAmbiguity(dotForm));
	}

	@Test
	public void test5() {
		String dotForm = "1+...2....*.8..+7";
		int expected = 0;
		assertEquals(expected, d.countAmbiguity(dotForm));
	}

	@Test
	public void test6() {
		String dotForm = "9*9*9*9*9*9*9*9*9*9*9";
		int expected = 0;
		assertEquals(expected, d.countAmbiguity(dotForm));
	}

	@Test
	public void test7() {
		String dotForm = "1+2*3/4+5*6/7*8+9-2..*3";
		int expected = 79;
		assertEquals(expected, d.countAmbiguity(dotForm));
	}

	@Test
	public void test8() {
		String dotForm = "1+2*3+4*5-6*7+8*9+1*2+3*4";
		int expected = 20853;
		assertEquals(expected, d.countAmbiguity(dotForm));
	}
}