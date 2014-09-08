package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryCodeTest {
	private BinaryCode b;

	@Before
	public void setUp() throws Exception {
		b = new BinaryCode();
	}

	@Test
	public void test00() {
		String message = "123210122";
		String[] expected = { "011100011", "NONE" };
		assertArrayEquals(expected, b.decode(message));
	}

	@Test
	public void test01() {
		String message = "11";
		String[] expected = { "01", "10" };
		assertArrayEquals(expected, b.decode(message));
	}

	@Test
	public void test02() {
		String message = "22111";
		String[] expected = { "NONE", "11001" };
		assertArrayEquals(expected, b.decode(message));
	}

	@Test
	public void test03() {
		String message = "123210120";
		String[] expected = { "NONE", "NONE" };
		assertArrayEquals(expected, b.decode(message));
	}

	@Test
	public void test04() {
		String message = "3";
		String[] expected = { "NONE", "NONE" };
		assertArrayEquals(expected, b.decode(message));
	}

	@Test
	public void test05() {
		String message = "12221112222221112221111111112221111";
		String[] expected = { "01101001101101001101001001001101001", "10110010110110010110010010010110010" };
		assertArrayEquals(expected, b.decode(message));
	}

	@Test
	public void test06() {
		String message = "1";
		String[] expected = { "NONE", "1" };
		assertArrayEquals(expected, b.decode(message));
	}

	@Test
	public void test07() {
		String message = "2";
		String[] expected = { "NONE", "NONE" };
		assertArrayEquals(expected, b.decode(message));
	}
	
	@Test
	public void test08() {
		String message = "12";
		String[] expected = { "NONE", "NONE" };
		assertArrayEquals(expected, b.decode(message));
	}
	
	@Test
	public void test09() {
		String message = "21";
		String[] expected = { "NONE", "NONE" };
		assertArrayEquals(expected, b.decode(message));
	}
	
	@Test
	public void test10() {
		String message = "13";
		String[] expected = { "NONE", "NONE" };
		assertArrayEquals(expected, b.decode(message));
	}
}
