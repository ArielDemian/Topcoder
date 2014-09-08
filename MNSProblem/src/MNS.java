public class MNS {
	public int combos(int[] numbers) {
		if (numbers.length != 9)
			return -1;
		int n = numbers[0], i;
		int[] pres = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, v = new int[numbers.length];
		boolean same = true;
		for (i = 0; i < numbers.length; i++) {
			if (numbers[i] > 9 || numbers[i] < 0)
				return -1;
			else {
				pres[numbers[i]]++;
			}
			if (same && n != numbers[i]) {
				same = false;
			}
			v[i] = -1;
		}
		if (same)
			return 1;
		int a = comb(pres, 0, 1, v, 0);
		return a;
	}

	private static int comb(int[] pres, int i, int z, int[] v, int last) {
		if (i >= pres.length)
			if (z > 1)
				return 0;
			else
				return sumVer(v);
		if (z > pres[i])
			return comb(pres, i + 1, 1, v, last);
		int c = 0;
		int y;
		for (y = (z > 1 ? last + 1 : 0); y < v.length; y++) {
			if (v[y] == -1) {
				v[y] = i;
				c += comb(pres, i, z + 1, v, y);
				v[y] = -1;
			}
		}
		return c;
	}

	private static int sumVer(int[] v) {
		int s = v[0] + v[1] + v[2];
		if (s != v[3] + v[4] + v[5])
			return 0;
		if (s != v[6] + v[7] + v[8])
			return 0;
		if (s != v[0] + v[3] + v[6])
			return 0;
		if (s != v[1] + v[4] + v[7])
			return 0;
		if (s != v[2] + v[5] + v[8])
			return 0;
		return 1;
	}
}