// SRM 633 DIV 2 - 250
public class Target {
	public String[] draw(int n) {
		char[][] res = new char[n][n];
		int i, j, xC = n / 2;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (i % 2 == 1 && Math.abs(xC - j) <= Math.abs(xC - i)) {
					res[i][j] = ' ';
				} else if (j % 2 == 1 && Math.abs(xC - i) <= Math.abs(xC - j)) {
					res[i][j] = ' ';
				} else
					res[i][j] = '#';
			}
		}
		String[] arr = new String[n];
		for (i = 0; i < n; i++)
			arr[i] = new String(res[i]);
		return arr;
	}
}