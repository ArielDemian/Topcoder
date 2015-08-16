public class Coversta {
	public int place(String[] a, int[] x, int[] y) {
		int[][] val = new int[a.length][a[0].length()];
		int imax = 0, jmax = 0, res = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length(); j++) {
				for (int k = 0; k < x.length; k++) {
					if (i + x[k] < a.length && i + x[k] >= 0 && j + y[k] < a[0].length() && j + y[k] >= 0) {
						val[i][j] += Character.getNumericValue(a[i + x[k]].charAt(j + y[k]));
					}
				}
				if (val[imax][jmax] < val[i][j]) {
					imax = i;
					jmax = j;
				}
			}
		}

		res += val[imax][jmax];
		val[imax][jmax] = 0;

		for (int k = 0; k < x.length; k++) {
			if (imax + x[k] < a.length && imax + x[k] >= 0 && jmax + y[k] < a[0].length() && jmax + y[k] >= 0) {
				for (int c = 0; c < x.length; c++) {
					if (c != k && imax + x[k] - x[c] < a.length && imax + x[k] - x[c] >= 0 && jmax + y[k] - y[c] < a[0].length() && jmax + y[k] - y[c] >= 0) {
						val[imax + x[k] - x[c]][jmax + y[k] - y[c]] -= Character.getNumericValue(a[imax + x[k]].charAt(jmax + y[k]));
					}
				}
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length(); j++) {
				if (val[imax][jmax] < val[i][j]) {
					imax = i;
					jmax = j;
				}
			}
		}

		res += val[imax][jmax];

		return res;
	}
}

//SRM 660 DIV 1 250