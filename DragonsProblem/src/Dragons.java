import java.math.BigInteger;

public class Dragons {
	private BigInteger one, zero;

	public Dragons() {
		this.zero = new BigInteger("0");
		this.one = new BigInteger("1");
	}

	public String snaug(int[] initialFood, int rounds) {
		String[] foo = new String[initialFood.length];
		String[] prev = new String[initialFood.length];
		BigInteger[] frac;
		int i, y, a;
		for (i = 0; i < prev.length; i++) {
			prev[i] = "" + initialFood[i];
			foo[i] = "" + initialFood[i];
		}
		for (i = 0; i < rounds; i++) {
			for (y = 0; y < foo.length; y++) {
				frac = take(prev, y);
				if (frac[1].compareTo(one) == 0) {
					foo[y] = "" + frac[0];
				} else {
					foo[y] = frac[0] + "/" + frac[1];
				}
			}
			for (a = 0; a < foo.length; a++)
				prev[a] = foo[a];
		}
		return foo[2];
	}

	private BigInteger[] take(String[] prev, int drag) {
		int not;
		BigInteger n, d;
		String[] nd;
		BigInteger[] res = new BigInteger[2];
		res[0] = new BigInteger("0");
		res[1] = new BigInteger("1");
		if (drag % 2 == 0)
			not = drag + 1;
		else
			not = drag - 1;
		for (int i = 0; i < prev.length; i++) {
			if (i == not || i == drag)
				continue;
			nd = prev[i].split("/");
			if (nd.length == 2)
				d = new BigInteger(nd[1]);
			else
				d = new BigInteger("1");
			n = new BigInteger(nd[0]);
			res = addFract(res[0], res[1], n, d.multiply(new BigInteger("4")));
		}
		return res;
	}

	private BigInteger[] addFract(BigInteger n1, BigInteger d1, BigInteger n2, BigInteger d2) {
		if (d1 == d2) {
			return simplify(n1.add(n2), d1);
		} else {
			return simplify(n1.multiply(d2).add(n2.multiply(d1)), d1.multiply(d2));
		}
	}

	private BigInteger[] simplify(BigInteger n, BigInteger d) {
		BigInteger gcf = grtCommFact(n, d);
		BigInteger[] result = new BigInteger[2];
		BigInteger one = new BigInteger("1");
		while (gcf.compareTo(one) > 0) {
			n = n.divide(gcf);
			d = d.divide(gcf);
			gcf = grtCommFact(n, d);
		}
		result[0] = n;
		result[1] = d;
		return result;
	}

	private BigInteger grtCommFact(BigInteger n, BigInteger d) {
		if (d.compareTo(zero) == 0)
			return n;
		return grtCommFact(d, n.mod(d));
	}
}