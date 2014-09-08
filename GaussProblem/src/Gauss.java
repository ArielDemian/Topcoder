import java.util.LinkedList;
import java.util.Queue;

//SRM 151 DIV 1 - 1000
public class Gauss {
	public String[] whichSums(String target) {
		long n = Long.parseLong(target), i, base;
		Queue<String> sums = new LinkedList<String>();
		for (i = 2; s(i) <= n; i++) {
			if ((n - s(i)) % i == 0) {
				base = (n - s(i)) / i;
				sums.add("[" + (base + 1) + ", " + (base + i) + "]");
			}
		}
		String[] r = new String[sums.size()];
		for (int j = sums.size() - 1; j >= 0; j--) {
			r[j] = sums.poll();
		}
		return r;
	}

	private static long s(long n) {
		return n * (n + 1) / 2;
	}
}