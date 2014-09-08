import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GaussTest {
	private Gauss g;

	@Before
	public void setUp() throws Exception {
		g = new Gauss();
	}

	@Test
	public void test0() {
		String target = "42";
		String[] expected = { "[3, 9]", "[9, 12]", "[13, 15]" };
		assertArrayEquals(expected, g.whichSums(target));
	}

	@Test
	public void test1() {
		String target = "55";
		String[] expected = { "[1, 10]", "[9, 13]", "[27, 28]" };
		assertArrayEquals(expected, g.whichSums(target));
	}

	@Test
	public void test2() {
		String target = "730041";
		String[] expected = { "[9321, 9398]", "[18700, 18738]", "[28066, 28091]", "[56151, 56163]", "[121671, 121676]", "[243346, 243348]", "[365020, 365021]" };
		assertArrayEquals(expected, g.whichSums(target));
	}

	@Test
	public void test3() {
		String target = "99999999997";
		String[] expected = { "[2941176454, 2941176487]", "[5882352933, 5882352949]", "[49999999998, 49999999999]" };
		assertArrayEquals(expected, g.whichSums(target));
	}
}