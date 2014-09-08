import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// SRM 630 DIV 1 - 250
public class Egalitarianism3 {
	public int maxCities(int n, int[] a, int[] b, int[] len) {
		if (n == 1)
			return 1;
		if (n == 2 || n == 3)
			return 2;
		long[][] d = new long[n][n], g = new long[n][n];
		List<BitSet> lbs = new LinkedList<BitSet>();
		BitSet bs;
		int i, j, y, k, c, next;
		for (i = 0; i < a.length; i++) {
			d[a[i] - 1][b[i] - 1] = len[i];
			d[b[i] - 1][a[i] - 1] = len[i];
			g[a[i] - 1][b[i] - 1] = len[i];
			g[b[i] - 1][a[i] - 1] = len[i];
		}
		for (i = 0; i < n; i++) {
			for (j = i + 1; j < n; j++) {
				if (d[i][j] == 0)
					visit(g, d, i);
			}
		}
		for (i = 0; i < n; i++) {
			for (j = i + 1; j < n; j++) {
				for (y = j + 1; y < n; y++) {
					if (d[i][j] == d[i][y] && d[i][j] == d[j][y]) {
						bs = null;
						for (BitSet l : lbs) {
							if (l.get(y))
								continue;
							if (l.get(i) && l.get(j)) {
								boolean f = true;
								c = 0;
								while ((next = l.nextSetBit(c)) >= 0) {
									if (d[y][next] != d[i][j]) {
										f = false;
										break;
									}
									c = next + 1;
								}
								if (f) {
									l.set(y);
									bs = l;
								}
							}
						}
						if (bs == null) {
							bs = new BitSet();
							bs.set(i);
							bs.set(j);
							bs.set(y);
							lbs.add(bs);
						}
					}
				}
			}
		}
		k = 2;
		for (BitSet l : lbs) {
			if (l.cardinality() > k) {
				k = l.cardinality();
			}
		}
		return k;
	}

	private static void visit(long[][] g, long[][] d, int t) {
		int u, i;
		Queue<Integer> q = new LinkedList<Integer>();
		BitSet v = new BitSet();
		v.set(t);
		q.add(t);
		while (!q.isEmpty()) {
			u = q.poll();
			for (i = 0; i < d.length; i++) {
				if (i == u)
					continue;
				if (!v.get(i) && g[u][i] > 0) {
					q.add(i);
					v.set(i);
					d[t][i] = d[t][u] + d[u][i];
					d[i][t] = d[t][i];
				}
			}
		}
	}
}