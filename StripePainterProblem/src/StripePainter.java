public class StripePainter {
	// SRM 150 DIV 1 - 500
	public int minStrokes(String stripes) {
		char[] s = stripes.toCharArray();
		int n = stripes.length(), i, j, k;
		int[][] d = new int[n][n];
		for (i = 0; i < n; i++) {
			fill(d[i], Integer.MAX_VALUE);
			d[i][i] = 1;
		}
		for (j = 1; j < n; j++) {
			for (i = j - 1; i >= 0; i--) {
				for (k = i; k < j; k++) {
					d[i][j] = min(d[i][j], d[i][k] + d[k + 1][j] - (s[i] == s[j] ? 1 : 0));
				}
			}
		}
		return d[0][n - 1];
	}

	private static void fill(int[] d, int n) {
		for (int i = 0; i < d.length; i++)
			d[i] = n;
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
	}
}