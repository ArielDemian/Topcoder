import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MailArchivingTest {
	private MailArchiving m;

	@Before
	public void setUp() throws Exception {
		m = new MailArchiving();
	}

	@Test
	public void test0() {
		String[] destFolders = { "Deleted messages", "Saved messages", "Deleted messages" };
		int expected = 2;
		assertEquals(expected, m.minSelections(destFolders));
	}

	@Test
	public void test1() {
		String[] destFolders = { "Folder A", "Folder B", "Folder C", "Folder D", "Folder E", "Folder F" };
		int expected = 6;
		assertEquals(expected, m.minSelections(destFolders));
	}

	@Test
	public void test2() {
		String[] destFolders = { "FOLDER", "folder" };
		int expected = 2;
		assertEquals(expected, m.minSelections(destFolders));
	}

	@Test
	public void test3() {
		String[] destFolders = { "a", "b", "a", "c", "a", "a", "b", "a", "c", "d", "a" };
		int expected = 6;
		assertEquals(expected, m.minSelections(destFolders));
	}

	@Test
	public void test4() {
		String[] destFolders = { "a", "b", "b", "c", "d", "e", "d", "e", "d", "e", "c", "c", "a", "a", "a", "f", "g", "g", "f", "a", "h", "h", "i", "j", "i", "j", "a", "a", "k", "k", "l", "m", "k", "l", "m", "a", "o", "o", "p", "a" };
		int expected = 20;
		assertEquals(expected, m.minSelections(destFolders));
	}

}