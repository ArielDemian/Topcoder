public class PeopleCircle {
	public String order(int numMales, int numFemales, int k) {
		String result = "";
		if (numMales == 0) {
			for (int i = 0; i < numFemales; i++)
				result += "F";
			return result;
		}
		if (numFemales == 0) {
			for (int i = 0; i < numMales; i++)
				result += "M";
			return result;
		}
		int tot = numFemales + numMales;
		char[] c = new char[tot];
		for (int i = 0; i < tot; i++)
			c[i] = 'X';
		int a, y = 0;
		k--;
		for (int i = 0; i < numFemales; i++) {
			a = k;
			while (a > 0) {
				if (c[y] == 'X') {
					a--;
					y = (y + 1) % tot;
				}
				while (c[y] != 'X')
					y = (y + 1) % tot;
			}
			c[y] = 'F';
			while (c[y] != 'X')
				y = (y + 1) % tot;
		}
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'X')
				c[i] = 'M';
			result += c[i];
		}
		return result;
	}
}