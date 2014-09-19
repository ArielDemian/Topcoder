import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TeamsSelectionTest {
	private TeamsSelection ts;

	@Before
	public void setUp() throws Exception {
		ts = new TeamsSelection();
	}

	@Test
	public void test0() {
		int[] preference1 = { 1, 2, 3, 4 };
		int[] preference2 = { 1, 2, 3, 4 };
		String expected = "1212";
		assertEquals(expected, ts.simulate(preference1, preference2));
	}
}