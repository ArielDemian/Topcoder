public class RecurrenceMachine {
	private static final int max = 1000000006;

	public String calculate(int k, int j) {
		long n = (long) k * (long) j;
		if (n < 1)
			return "error";
		long RRi2 = 3;
		long PPi2 = 0;
		long RRi1 = 3 + 3 * PPi2;
		long PPi1 = 5 * 1;
		if (n == 1)
			return RRi1 + "##" + (RRi2 + 2 * PPi2) + "##" + PPi1;
		Long PPi = (long) 0, RRi = (long) 0, temp;
		int i;
		for (i = 2; i <= n; i++) {
			temp = RRi2 + 2 * PPi2;
			PPi = 5 * temp;
			if (PPi >= max)
				PPi %= max;
			RRi = temp + PPi2 + 3 * PPi1;
			if (RRi >= max)
				RRi %= max;
			RRi2 = RRi1;
			PPi2 = PPi1;
			RRi1 = RRi;
			PPi1 = PPi;
		}
		return RRi + "##" + (RRi2 + 2 * PPi2) % max + "##" + PPi1;
	}
}