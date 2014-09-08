public class MailArchiving {
	// SRM 240 DIV 1 - 900
	public int minSelections(String[] destFolders) {
		int n = destFolders.length, i, j, k;
		int[][] d = new int[n][n];
		for (i = 0; i < n; i++)
			for (j = i; j < n; j++) {
				if (i == j)
					d[i][j] = 1;
				else
					d[i][j] = Integer.MAX_VALUE;
			}
		for (j = 1; j < n; j++) {
			for (i = j - 1; i >= 0; i--) {
				for (k = i + 1; k <= j; k++) {
					d[i][j] = min(d[i][j], d[i][k - 1] + d[k][j] - (destFolders[i].equals(destFolders[j]) ? 1 : 0));
				}
			}
		}
		return d[0][n - 1];
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
	}
}