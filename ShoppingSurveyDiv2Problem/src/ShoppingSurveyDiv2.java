import java.util.BitSet;

// SRM 634 DIV 2 - 500
public class ShoppingSurveyDiv2 {
	public int minValue(int n, int[] s) {
		int m = s.length, i, c = 0, p;
		int[] purchases = new int[n];
		BitSet bs = null;
		for (i = 0; i < m; i++) {
			bs = new BitSet();
			for (int j = 1; j <= s[i]; j++) {
				p = getMin(purchases, bs);
				bs.set(p);
				purchases[p]++;
			}
		}
		for (i = 0; i < n; i++) {
			if (purchases[i] == m)
				c++;
		}
		return c;
	}

	private static int getMin(int[] purchases, BitSet bs) {
		int min = -1;
		for (int i = 0; i < purchases.length; i++) {
			if (!bs.get(i) && (min < 0 || purchases[i] < purchases[min]))
				min = i;
		}
		return min;
	}
}