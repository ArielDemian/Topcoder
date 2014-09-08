public class NonRepeat {
	public int count(char[][] c) {
		if (c == null)
			return -1;
		if (c.length <= 1)
			return c.length;
		int[] index = new int[c.length];
		char[] comb = new char[c.length];
		boolean end = true;
		int count = 0;
		for (int i = 0; i < c.length; i++) {
			index[i] = 0;
		}
		while (end) {
			for (int i = 0; i < c.length; i++) {
				comb[i] = c[i][index[i]];
			}
			if (!hasDouble(comb)) {
				count++;
			}
			end = inc(index, c);
		}
		return count;
	}

	private static boolean inc(int[] index, char[][] c) {
		int i = 0;
		while (true) {
			if (index[i] >= c[i].length - 1) {
				i++;
				if (i >= index.length)
					return false;
			} else {
				index[i]++;
				for (int y = 0; y < i; y++)
					index[y] = 0;
				return true;
			}
		}
	}

	private static boolean hasDouble(char[] c) {
		for (int i = 0; i < c.length - 1; i++) {
			for (int y = i + 1; y < c.length; y++) {
				if (c[i] == c[y])
					return true;
			}
		}
		return false;
	}
}