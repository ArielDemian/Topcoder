public class CoinStrategyGame {
	// Consider a row of n coins of values v(1) ... v(n), where n is even. We
	// play a game against an opponent by alternating turns. In each turn, a
	// player selects either the first or last coin from the row, removes it from
	// the row permanently, and receives the value of the coin. Determine the
	// maximum possible amount of money we can definitely win if we move first.
	public int win(int[] v) {
		int n = v.length, i, j;
		int[][] d = new int[n][n];
		for (i = 0; i < n; i++) {
			d[i][i] = v[i];
			if (i < n - 1)
				d[i][i + 1] = max(v[i], v[i + 1]);
		}
		for (j = 2; j < n; j++) {
			for (i = j - 2; i >= 0; i--) {
				d[i][j] = max(v[i] + min(d[i + 1][j - 1], d[i + 2][j]), v[j] + min(d[i][j - 2], d[i + 1][j - 1]));
			}
		}
		return d[0][n - 1];
	}

	private static int min(int a, int b) {
		if (a < b)
			return a;
		else
			return b;
	}

	private static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}
}