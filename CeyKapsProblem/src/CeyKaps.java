public class CeyKaps {
	public String decipher(String typed, String[] switches) {
		char[] c = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', };
		char a;
		String[] t;
		int i, y, z;
		for (i = 0; i < switches.length; i++) {
			t = switches[i].split(":");
			if (t[0].equals(t[1]))
				return null;
			loop: for (y = 0; y < c.length; y++) {
				if (c[y] == t[0].charAt(0)) {
					for (z = 0; z < c.length; z++) {
						if (c[z] == t[1].charAt(0)) {
							a = c[y];
							c[y] = c[z];
							c[z] = a;
							break loop;
						}
					}
				}
			}
		}
		for (i = 0; i < typed.length(); i++) {
			typed = typed.substring(0, i) + c[typed.charAt(i) - 'A'] + typed.substring(i + 1, typed.length());
		}
		return typed;
	}
}