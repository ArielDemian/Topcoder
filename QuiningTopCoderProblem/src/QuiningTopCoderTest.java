import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QuiningTopCoderTest {
	private QuiningTopCoder q;

	@Before
	public void setUp() throws Exception {
		q = new QuiningTopCoder();
	}

	@Test
	public void test0() {
		String source = ",";
		String expected = "QUINES 0";
		assertEquals(expected, q.testCode(source));
	}
	
	@Test
	public void test4() {
		String source = "0,1+::9W-9W-S1W1W:+2_J_@_@";
		String expected = "BADEND 437";
		assertEquals(expected, q.testCode(source));
	}
}