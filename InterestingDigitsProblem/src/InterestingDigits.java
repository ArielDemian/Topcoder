import java.util.LinkedList;
import java.util.List;

// SRM 150 DIV 1 - 250
public class InterestingDigits {
	public int[] digits(int base) {
		List<Integer> li = new LinkedList<Integer>();
		if (base <= 2) {
			int[] empty = {};
			return empty;
		}
		int i, m, p;
		long sum;
		loop: for (i = 2; i < base; i++) {
			m = 2;
			do {
				p = i * m;
				sum = sumConv(base, p);
				if (sum % i != 0) {
					continue loop;
				}
				m++;
			} while (("" + p).length() < 4);
			li.add(i);
		}
		int[] result = new int[li.size()];
		for (i = 0; i < li.size(); i++) {
			result[i] = li.get(i);
		}
		return result;
	}

	private static long sumConv(int base, int p) {
		long result = 0;
		while (p > 0) {
			result = (p % base) + result;
			p /= base;
		}
		return result;
	}
}