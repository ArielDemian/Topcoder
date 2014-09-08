public class EditDistance {
	// Given two text strings A of length n and B of length m, you want to
	// transform A into B with a minimum number of operations of the following
	// types: delete a character from A, insert a character into A, or change
	// some character in A into a new character. The minimal number of such
	// operations required to transform A into B is called the edit distance
	// between A and B.
	private int ci, cd, cr;

	public EditDistance(int ci, int cd, int cr) {
		this.ci = ci;
		this.cd = cd;
		this.cr = cr;
	}

	public int edit(String A, String B) {
		int n = A.length(), m = B.length(), i, j;
		int[][] t = new int[n + 1][m + 1];
		t[0][0] = 0;
		for (i = 1; i <= (n > m ? n : m); i++) {
			if (i <= n) {
				t[i][0] = cd + (i - 1 >= 0 ? t[i - 1][0] : 0);
			}
			if (i <= m) {
				t[0][i] = ci + (i - 1 >= 0 ? t[0][i - 1] : 0);
			}
		}
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= m; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					t[i][j] = t[i - 1][j - 1];
				} else {
					t[i][j] = min(cd + t[i - 1][j], ci + t[i][j - 1], cr + t[i - 1][j - 1]);
				}
			}
		}
		return t[n][m];
	}

	private static int min(int a, int b, int c) {
		int d;
		if (a < b)
			d = a;
		else
			d = b;
		if (d < c)
			return d;
		else
			return c;
	}
}