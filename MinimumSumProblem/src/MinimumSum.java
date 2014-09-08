public class MinimumSum {
	public long sum(long[] v) {
		int i, j, y;
		long min;
		long sum = 0, f = 0;
		for (i = 0; i < v.length; i++) {
			min = v[i];
			for (j = i; j < v.length; j++) {
				if (min > v[j])
					min = v[j];
				for (y = i; y <= j; y++) {
					f += Math.abs(min - v[y]);
				}
				sum += f;
				f = 0;
			}
		}
		return sum;
	}
}