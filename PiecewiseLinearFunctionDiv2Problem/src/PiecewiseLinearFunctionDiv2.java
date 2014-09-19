// SRM 586 DIV 2 - 500
public class PiecewiseLinearFunctionDiv2 {
	public int[] countSolutions(int[] Y, int[] query) {
		int i, j, c;
		int[] res = new int[query.length];
		for (i = 0; i < query.length; i++) {
			c = 0;
			for (j = 0; j < Y.length - 1; j++) {
				if (query[i] == Y[j] && Y[j] == Y[j + 1]) {
					c = -1;
					break;
				} else if (query[i] < Y[j] && query[i] >= Y[j + 1] || query[i] > Y[j] && query[i] <= Y[j + 1]) {
					c++;
				}
			}
			if (c >= 0 && query[i] == Y[0])
				c++;
			res[i] = c;
		}
		return res;
	}
}