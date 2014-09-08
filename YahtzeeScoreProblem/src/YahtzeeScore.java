public class YahtzeeScore {
	public int maxPoints(int[] toss) {
		int max = 0, sum;
		for (int i = 1; i < 7; i++) {
			sum = 0;
			for (int y = 0; y < toss.length; y++) {
				if (toss[y] == i)
					sum += i;
			}
			if (max < sum)
				max = sum;
		}
		return max;
	}
}
