import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TargetTest {
	private Target t;

	@Before
	public void setUp() throws Exception {
		t = new Target();
	}

	@Test
	public void test0() {
		int n = 5;
		String[] expected = { "#####", "#   #", "# # #", "#   #", "#####" };
		assertArrayEquals(expected, t.draw(n));
	}

	@Test
	public void test1() {
		int n = 17;
		String[] expected = { "#################", "#               #", "# ############# #", "# #           # #", "# # ######### # #", "# # #       # # #", "# # # ##### # # #", "# # # #   # # # #", "# # # # # # # # #", "# # # #   # # # #", "# # # ##### # # #", "# # #       # # #", "# # ######### # #", "# #           # #", "# ############# #", "#               #", "#################" };
		assertArrayEquals(expected, t.draw(n));
	}
}