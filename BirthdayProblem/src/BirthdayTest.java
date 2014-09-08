import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BirthdayTest {
	private Birthday b;

	@Before
	public void setUp() throws Exception {
		b = new Birthday();
	}

	@Test
	public void test() {
		String date = "01/02";
		String[] birthdays = { "02/17 Wernie", "10/12 Stefan", "02/17 MichaelJordan", "10/12 LucianoPavarotti", "05/18 WilhelmSteinitz" };
		String expected = "02/17";
		assertEquals(expected, b.getNext(date, birthdays));
	}
}
