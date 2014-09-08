import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BalancedPartitionTest {
	private BalancedPartition b;

	@Before
	public void setUp() throws Exception {
		b = new BalancedPartition();
	}

	@Test
	public void test() {
		int[] v = { 28, 5, 16, 4, 8, 3, 9, 14, 22, 6 };
		int expected = 0;
		assertEquals(expected, b.partition(v));
	}
}
