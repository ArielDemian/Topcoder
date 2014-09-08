public class Knapsack {
	public int fill(int[] s, int[] v, int c) {
		int n = s.length, i, j;
		if (v.length != n)
			return -1;
		int[][] m = new int[n][c + 1];
		for (i = s[0]; i <= c; i++)
			m[0][i] = v[0];
		for (i = 1; i < n; i++) {
			for (j = 1; j <= c; j++) {
				if (j - s[i] >= 0)
					m[i][j] = max(m[i - 1][j], m[i - 1][j - s[i]] + v[i]);
				else
					m[i][j] = m[i - 1][j];
			}
		}
		return m[m.length - 1][m[0].length - 1];
	}

	private static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}
}