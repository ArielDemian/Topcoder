import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LeaguePicksTest {
	private LeaguePicks l;

	@Before
	public void setUp() throws Exception {
		l = new LeaguePicks();
	}

	@Test
	public void test0() {
		int[] expected = { 3, 10, 15 };
		assertArrayEquals(expected, l.returnPicks(3, 6, 15));
	}

	@Test
	public void test1() {
		int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		assertArrayEquals(expected, l.returnPicks(1, 1, 10));
	}

	@Test
	public void test2() {
		int[] expected = { 1, 4, 5, 8, 9, 12, 13, 16, 17, 20, 21, 24, 25, 28, 29, 32, 33, 36, 37 };
		assertArrayEquals(expected, l.returnPicks(1, 2, 39));
	}

	@Test
	public void test3() {
		int[] expected = { 5, 18, 27, 40, 49, 62, 71, 84, 93 };
		assertArrayEquals(expected, l.returnPicks(5, 11, 100));
	}
}