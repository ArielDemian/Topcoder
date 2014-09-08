public class CCipher {
	public String decode(String cipherText, int shift) {
		if (cipherText == null || cipherText.length() == 0 || shift <= 0)
			return cipherText;
		char[] c = cipherText.toCharArray();
		int i;
		String result = "";
		for (i = 0; i < cipherText.length(); i++) {
			c[i] = prev(c[i], shift);
			result += c[i];
		}
		return result;
	}

	private static char prev(char c, int n) {
		c -= n;
		if (c < 'A')
			c += 26;
		return c;
	}
}
