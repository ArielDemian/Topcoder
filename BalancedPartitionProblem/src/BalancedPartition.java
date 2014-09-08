public class BalancedPartition {
	// You have a set of n integers each in the range 0 ... K. Partition these
	// integers into two subsets such that you minimize |S1 - S2|, where S1 and
	// S2 denote the sums of the elements in each of the two subsets.
	private Knapsack k;

	public BalancedPartition() {
		k = new Knapsack();
	}

	public int partition(int[] v) {
		int n = v.length, i;
		int sum = 0, s1, s2;
		for (i = 0; i < n; i++)
			sum += v[i];
		s1 = k.fill(v, v, sum / 2);
		s2 = sum - s1;
		return Math.abs(s2 - s1);
	}
}