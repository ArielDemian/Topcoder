import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProblemWritingTest {
	private ProblemWriting p;

	@Before
	public void setUp() throws Exception {
		p = new ProblemWriting();
	}

	@Test
	public void test0() {
		String dotForm = "3+5";
		String expected = "";
		assertEquals(expected, p.myCheckData(dotForm));
	}

	@Test
	public void test1() {
		String dotForm = "9..+.5...*....3";
		String expected = "";
		assertEquals(expected, p.myCheckData(dotForm));
	}

	@Test
	public void test2() {
		String dotForm = "5.3+4";
		String expected = "dotForm is not in dot notation, check character 2.";
		assertEquals(expected, p.myCheckData(dotForm));
	}

	@Test
	public void test3() {
		String dotForm = "9*9*9*9*9*9*9*9*9*9*9*9*9*9";
		String expected = "dotForm must contain between 1 and 25 characters, inclusive.";
		assertEquals(expected, p.myCheckData(dotForm));
	}

	@Test
	public void test4() {
		String dotForm = "3.........../...........4";
		String expected = "";
		assertEquals(expected, p.myCheckData(dotForm));
	}

	@Test
	public void test5() {
		String dotForm = "1.+..................";
		String expected = "dotForm is not in dot notation, check character 21.";
		assertEquals(expected, p.myCheckData(dotForm));
	}

	@Test
	public void test6() {
		String dotForm = "9+6.";
		String expected = "dotForm is not in dot notation, check character 4.";
		assertEquals(expected, p.myCheckData(dotForm));
	}

	@Test
	public void test7() {
		String dotForm = "5..........+..5++";
		String expected = "dotForm is not in dot notation, check character 16.";
		assertEquals(expected, p.myCheckData(dotForm));
	}
}