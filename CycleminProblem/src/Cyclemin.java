public class Cyclemin {
	public String bestmod(String s, int k) {
		String t = s, min = s, temp;
		for (int i = 0; i < s.length(); i++) {
			temp = t;
			for (int j = 0; j < k; j++) {
				t = t.replaceFirst("[^a]", "a");
			}
			if (min.compareTo(t) > 0)
				min = t;
			t = temp.substring(1) + temp.charAt(0);
		}
		return min;
	}
}