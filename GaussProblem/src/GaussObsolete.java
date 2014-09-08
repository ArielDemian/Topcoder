import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

//SRM 151 DIV 1 - 1000
public class GaussObsolete {
	public String[] whichSums(String target) {
		if (target.length() == 0 || target.length() == 1 && Long.parseLong(target) <= 1) {
			return new String[0];
		}
		BigInteger n = new BigInteger(target), l = BigInteger.valueOf(1), i = BigInteger.valueOf(0), j = l;
		String print;
		List<String> sums = new LinkedList<String>();
		while (true) {
			if (j.add(j.subtract(l)).compareTo(n) > 0)
				break;
			if (s(j).subtract(s(i)).compareTo(n) == 0) {
				print = "[" + i.add(l) + ", " + j + "]";
				sums.add(print);
				System.out.println(print);
				i = i.add(l);
				continue;
			}
			if (s(j).subtract(s(i)).compareTo(n) > 0) {
				i = i.add(l);
				continue;
			}
			if (s(j).subtract(s(i)).compareTo(n) < 0) {
				j = j.add(l);
				continue;
			}
		}
		return sums.toArray(new String[sums.size()]);
	}

	private static BigInteger s(BigInteger n) {
		return n.multiply(n.add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
	}
}