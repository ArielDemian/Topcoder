import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoboCourierTest {
	private RoboCourier r;

	@Before
	public void setUp() throws Exception {
		r = new RoboCourier();
	}

	@Test
	public void test0() {
		String[] path = { "FRRFLLFLLFRRFLF" };
		int expected = 15;
		assertEquals(expected, r.timeToDeliver(path));
	}

	@Test
	public void test1() {
		String[] path = { "RFLLF" };
		int expected = 17;
		assertEquals(expected, r.timeToDeliver(path));
	}

	@Test
	public void test2() {
		String[] path = { "FLFRRFRFRRFLLFRRF" };
		int expected = 0;
		assertEquals(expected, r.timeToDeliver(path));
	}

	@Test
	public void test3() {
		String[] path = { "FFFFFFFFFRRFFFFFFRRFFFFF", "FLLFFFFFFLLFFFFFFRRFFFF" };
		int expected = 44;
		assertEquals(expected, r.timeToDeliver(path));
	}

	@Test
	public void test4() {
		String[] path = { "RFLLFLFLFRFRRFFFRFFRFFRRFLFFRLRRFFLFFLFLLFRFLFLRFF", "RFFLFLFFRFFLLFLLFRFRFLRLFLRRFLRFLFFLFFFLFLFFRLFRLF", "LLFLFLRLRRFLFLFRLFRF" };
		int expected = 24;
		assertEquals(expected, r.timeToDeliver(path));
	}

	@Test
	public void test5() {
		String[] path = { "LLFLFRLRRLRFFLRRRRFFFLRFFRRRLLFLFLLRLRFFLFRRFFFLFL", "RLFFRRLRLRRFFFLLLRFRLLRFFLFRLFRRFRRRFRLRLRLFFLLFLF", "FRFLRFRRLLLRFFRRRLRFLFRRFLFFRLFLFLFRLLLLFRLLRFLLLF", "FFLFRFRRFLLFFLLLFFRLLFLRRFRLFFFRRFFFLLRFFLRFRRRLLR", "FFFRRLLFLLRLFRRLRLLFFFLFLRFFRLRLLFLRLFFLLFFLLFFFRR", "LRFRRFLRRLRRLRFFFLLLLRRLRFFLFRFFRLLRFLFRRFLFLFFLFR", "RFRRLRRFLFFFLLRFLFRRFRFLRLRLLLLFLFFFLFRLLRFRLFRLFR", "LLFLFRLFFFFFFFRRLRLRLLRFLRLRRRRRRRRLFLFLFLRFLFRLFF", "RLFRRLLRRRRFFFRRRLLLLRRLFFLLLLLRFFFFRFRRLRRRFFFLLF", "FFFFLRRLRFLLRRLRLRFRRRRLFLLRFLRRFFFRFRLFFRLLFFRRLL" };
		int expected = 169;
		assertEquals(expected, r.timeToDeliver(path));
	}

	@Test
	public void test6() {
		String[] path = { "RFFFFFRRFRRFLLLF" };
		int expected = 22;
		assertEquals(expected, r.timeToDeliver(path));
	}
}
