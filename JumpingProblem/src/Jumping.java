// SRM 633 DIV 2 - 500
public class Jumping {
	private static final String able = "Able", notAble = "Not able";

	public String ableToGet(int x, int y, int[] jumpLengths) {
		long r1 = jumpLengths[0], r2 = jumpLengths[0];
		int i;
		for (i = 1; i < jumpLengths.length; i++) {
			if (jumpLengths[i] <= r2) {
				r1 -= jumpLengths[i];
				if (r1 < 0)
					r1 = 0;
				r2 += jumpLengths[i];
			} else {
				r1 = Math.abs(jumpLengths[i] - r2);
				r2 += jumpLengths[i];
			}
		}
		double d = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		if (d >= r1 && d <= r2)
			return able;
		else
			return notAble;
	}
}