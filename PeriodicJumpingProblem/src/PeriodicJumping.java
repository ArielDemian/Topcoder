public class PeriodicJumping {
	public int minimalTime(int x, int[] jumpLengths) {
		if (x == 0)
			return 0;
		x = Math.abs(x);
		int r1 = jumpLengths[0], r2 = jumpLengths[0];
		int i = 1 % jumpLengths.length, c = 1;
		while (!(x >= r1 && x <= r2)) {
			c++;
			if (jumpLengths[i] <= r2) {
				r1 -= jumpLengths[i];
				if (r1 < 0)
					r1 = 0;
				r2 += jumpLengths[i];
				if (r2 < 0)
					r2 = Integer.MAX_VALUE;
			} else {
				r1 = Math.abs(jumpLengths[i] - r2);
				r2 += jumpLengths[i];
			}
			i = (i + 1) % jumpLengths.length;
			if (i == 0) {
				int t = x / r2;
				if (t > 1000) {
					r2 *= t;
					c *= t;
				}
			}
		}
		return c;
	}
}