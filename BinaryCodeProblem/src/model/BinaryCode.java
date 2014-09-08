package model;

// SRM 144 DIV 2 - 550
public class BinaryCode {
	private static final String none = "NONE";

	public String[] decode(String message) {
		String[] result = new String[2];
		if (message.length() == 1) {
			if (message.equals("0")) {
				result[0] = "0";
				result[1] = none;
			} else if (message.equals("1")) {
				result[0] = none;
				result[1] = "1";
			} else {
				result[0] = none;
				result[1] = none;
			}
			return result;
		}
		int[] P, Q = new int[message.length() + 2];
		int i, d;
		for (i = 0; i < message.length(); i++)
			Q[i + 1] = Integer.parseInt("" + message.charAt(i));
		for (d = 1; d < Q.length; d += message.length() - 1) {
			switch (Q[d]) {
			case 2:
				Q[(d == 1 ? 0 : d + 1)] = 1;
				break;
			case 3:
				result[0] = none;
				result[1] = none;
				return result;
			}
		}
		out: for (d = 0; d < 2; d++) {
			result[d] = "";
			P = new int[message.length() + 2];
			P[1] = d;
			for (i = 1; i < Q.length - 1; i++) {
				P[i + 1] = Q[i] - (P[i] + P[i - 1]);
				if (P[i + 1] != 0 && P[i + 1] != 1) {
					result[d] = none;
					continue out;
				}
				result[d] += "" + P[i];
			}
			if (P[P.length - 1] != 0)
				result[d] = none;
		}
		return result;
	}
}