import java.util.BitSet;

// SRM 586 DIV 2 - 250
public class TeamsSelection {
	public String simulate(int[] preference1, int[] preference2) {
		int n = preference1.length;
		BitSet bs = new BitSet();
		boolean firstCaptain = true;
		int pref[] = null;
		int i1 = 0, i2 = 0, index;
		char[] c = new char[n];
		while (bs.cardinality() < n) {
			if (firstCaptain) {
				pref = preference1;
				index = i1;
			} else {
				pref = preference2;
				index = i2;
			}
			while (index < n) {
				if (!bs.get(pref[index] - 1)) {
					bs.set(pref[index] - 1);
					if (firstCaptain) {
						c[pref[index] - 1] = '1';
						i1 = ++index;
					} else {
						c[pref[index] - 1] = '2';
						i2 = ++index;
					}
					firstCaptain = !firstCaptain;
					break;
				} else
					index++;
			}
		}
		return new String(c);
	}
}