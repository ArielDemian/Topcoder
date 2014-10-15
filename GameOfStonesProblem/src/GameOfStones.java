// SRM 636 DIV 2 - 250
public class GameOfStones {
	public int count(int[] stones) {
		boolean equal = true;
		int i, tot = 0, n = stones.length, c = 0;
		for (i = 0; i < n; i++) {
			tot += stones[i];
			if (equal && i > 0 && stones[i] != stones[i - 1])
				equal = false;
		}
		if (equal)
			return 0;
		if (tot % n != 0)
			return -1;
		tot /= n;
		for (i = 0; i < n; i++) {
			if ((tot - stones[i]) % 2 != 0)
				return -1;
			if (stones[i] < tot) {
				c += (tot - stones[i]) / 2;
			}
		}
		return c;
	}
}