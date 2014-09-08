public class Masterbrain {
	public int possibleSecrets(String[] guesses, String[] results) {
		int l = guesses[0].length();
		char[][] p = new char[2401][l + results.length];
		int[][] r = new int[results.length][2];
		for (int i = 0; i < results.length; i++) {
			r[i][0] = Character.getNumericValue(results[i].charAt(0));
			r[i][1] = Character.getNumericValue(results[i].charAt(3));
		}
		int i = 0;
		for (char a = '1'; a <= '7'; a++)
			for (char b = '1'; b <= '7'; b++)
				for (char c = '1'; c <= '7'; c++)
					for (char d = '1'; d <= '7'; d++) {
						p[i][0] = a;
						p[i][1] = b;
						p[i][2] = c;
						p[i][3] = d;
						for (int y = 4; y < l + results.length; y++) {
							p[i][y] = 'p';
						}
						i++;
					}
		for (i = 0; i < results.length; i++) {
			for (int c = 0; c < p.length; c++) {
				for (int y = 0; y < results.length; y++) {
					if (p[c][l + i] != 'n' && !possible(p[c], guesses[y], r[y][0], r[y][1], !(i == y))) {
						p[c][l + i] = 'n';
					}
				}
			}
		}
		i = 0;
		boolean poss;
		for (int a = 0; a < p.length; a++) {
			poss = false;
			for (int b = l; b < l + results.length; b++) {
				if (p[a][b] != 'n') {
					poss = true;
				}
			}
			if (poss) {
				i++;
			}
		}
		return i;
	}

	private static boolean possible(char[] s, String comb, int b, int w, boolean truth) {
		int myb = 0, myw = 0;
		int i;
		char[] secret = new char[s.length];
		for (i = 0; i < s.length; i++)
			secret[i] = s[i];
		for (i = 0; i < comb.length(); i++) {
			if (secret[i] == comb.charAt(i)) {
				myb++;
				comb = comb.substring(0, i) + "x" + comb.substring(i + 1, comb.length());
				secret[i] = 'x';
			}
		}
		if (myb < comb.length()) {
			for (i = 0; i < comb.length(); i++) {
				int a = containsChar(secret, comb.charAt(i));
				if (comb.charAt(i) != 'x' && a >= 0) {
					myw++;
					secret[a] = 'x';
					comb = comb.substring(0, i) + "x" + comb.substring(i + 1, comb.length());
				}
			}
		}
		if (truth) {
			if (myb == b && myw == w) {
				return true;
			}
		} else {
			if (myb != b || myw != w) {
				return true;
			}
		}
		return false;
	}

	private static int containsChar(char[] s, char c) {
		for (int i = 0; i < s.length; i++)
			if (s[i] == c)
				return i;
		return -1;
	}
}