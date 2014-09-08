// SRM 153 DIV 1 - 450
public class Collision {
	public double probability(int[] assignments, int ids) {
		double d1 = 1, d2 = 1;
		long tot = 0, c = 0;
		int i, j;
		for (i = 0; i < assignments.length; i++) {
			tot += assignments[i];
			if (tot > ids)
				return 0;
			for (j = 0; j < assignments[i]; j++) {
				if (i == 0 && j == 0)
					continue;
				c++;
				d1 *= (double) (ids - c) / (double) ids;
			}
		}
		System.out.println(d1);
		for (i = 0; i < assignments.length - 1; i++) {
			tot -= assignments[i];
			c = 0;
			for (j = 0; j < assignments[i]; j++) {
				d2 *= (double) (ids - tot - c) / (double) (ids - c);
				c++;
			}
		}
		System.out.println(d2);
		return Math.abs(d1 - d2);
	}
}