public class Privateparty {
	public double getExactExp(int[] a) {
		double res = 0;
		boolean hate;
		int[][] val = { { 0, 1, 2, 3 }, { 0, 1, 3, 2 }, { 0, 2, 1, 3 }, { 0, 2, 3, 1 }, { 0, 3, 1, 2 }, { 0, 3, 2, 1 }, { 1, 0, 2, 3 }, { 1, 0, 3, 2 }, { 1, 2, 0, 3 }, { 1, 2, 3, 0 }, { 1, 3, 0, 2 }, { 1, 3, 2, 0 }, { 2, 0, 1, 3 }, { 2, 0, 3, 1 }, { 2, 1, 0, 3 }, { 2, 1, 3, 0 }, { 2, 3, 0, 1 }, { 2, 3, 1, 0 }, { 3, 0, 1, 2 }, { 3, 0, 2, 1 }, { 3, 1, 0, 2 }, { 3, 1, 2, 0 }, { 3, 2, 0, 1 }, { 3, 2, 1, 0, } };
		for (int i = 0; i < val.length; i++) {
			for (int j = 0; j < val[i].length; j++) {
				hate = false;
				for (int k = 0; k < j; k++) {
					if (val[i][k] == a[val[i][j]]) {
						hate = true;
						break;
					}
				}
				if (!hate)
					res++;
			}
		}
		return res / 24.0;
	}

	public double getexp(int[] a) {
		double res = 0;
		int k = 0, i, n = a.length;
		for (i = 0; i < a.length; i++) {
			if (a[i] == i)
				k++;
		}
		for (i = n - 1; i >= 0; i--) {
			res += i * (n - k);
		}
		res = res / (n * (n - 1));
		res += k;
		return res;
	}
}

//SRM 660 DIV 1 500