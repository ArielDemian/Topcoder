import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StripePainterTest {
	private StripePainter sp;

	@Before
	public void setUp() throws Exception {
		sp = new StripePainter();
	}

	@Test
	public void test0() {
		String stripes = "RGBGR";
		int expected = 3;
		assertEquals(expected, sp.minStrokes(stripes));
	}

	@Test
	public void test1() {
		String stripes = "RGRG";
		int expected = 3;
		assertEquals(expected, sp.minStrokes(stripes));
	}

	@Test
	public void test2() {
		String stripes = "ABACADA";
		int expected = 4;
		assertEquals(expected, sp.minStrokes(stripes));
	}

	@Test
	public void test3() {
		String stripes = "AABBCCDDCCBBAABBCCDD";
		int expected = 7;
		assertEquals(expected, sp.minStrokes(stripes));
	}

	@Test
	public void test4() {
		String stripes = "BECBBDDEEBABDCADEAAEABCACBDBEECDEDEACACCBEDABEDADD";
		int expected = 26;
		assertEquals(expected, sp.minStrokes(stripes));
	}

}