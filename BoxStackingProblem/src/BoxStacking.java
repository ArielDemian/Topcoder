import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class BoxStacking {
	// You are given a set of n types of rectangular 3-D boxes, where the i^th
	// box has height h(i), width w(i) and depth d(i) (all real numbers). You
	// want to create a stack of boxes which is as tall as possible, but you can
	// only stack a box on top of another box if the dimensions of the 2-D base
	// of the lower box are each strictly larger than those of the 2-D base of
	// the higher box. Of course, you can rotate a box so that any side functions
	// as its base. It is also allowable to use multiple instances of the same
	// type of box.
	public double stack(double[] h, double[] w, double[] d) {
		int n = h.length, i, j;
		if (w.length != n || d.length != n)
			return -1;
		BigDecimal[][] bd = new BigDecimal[n * 3][4]; // h-d-w
		j = 0;
		for (i = 0; i < n; i++) {
			bd[j][0] = BigDecimal.valueOf(h[i]);
			if (d[i] >= w[i]) {
				bd[j][1] = BigDecimal.valueOf(d[i]);
				bd[j][2] = BigDecimal.valueOf(w[i]);
			} else {
				bd[j][1] = BigDecimal.valueOf(w[i]);
				bd[j][2] = BigDecimal.valueOf(d[i]);
			}
			j++;
			bd[j][0] = BigDecimal.valueOf(w[i]);
			if (d[i] >= h[i]) {
				bd[j][1] = BigDecimal.valueOf(d[i]);
				bd[j][2] = BigDecimal.valueOf(h[i]);
			} else {
				bd[j][1] = BigDecimal.valueOf(h[i]);
				bd[j][2] = BigDecimal.valueOf(d[i]);
			}
			j++;
			bd[j][0] = BigDecimal.valueOf(d[i]);
			if (h[i] >= w[i]) {
				bd[j][1] = BigDecimal.valueOf(h[i]);
				bd[j][2] = BigDecimal.valueOf(w[i]);
			} else {
				bd[j][1] = BigDecimal.valueOf(w[i]);
				bd[j][2] = BigDecimal.valueOf(h[i]);
			}
			j++;
		}
		Arrays.sort(bd, new BaseAreaComparator());
		bd[0][3] = bd[0][0];
		for (j = 1; j < bd.length; j++) {
			bd[j][3] = BigDecimal.valueOf(0);
			for (i = j - 1; i >= 0; i--) {
				if (bd[i][1].compareTo(bd[j][1]) > 0 && bd[i][2].compareTo(bd[j][2]) > 0 && bd[i][3].add(bd[j][0]).compareTo(bd[j][3]) > 0) {
					bd[j][3] = bd[i][3].add(bd[j][0]);
				}
			}
		}
		i = 0;
		BigDecimal result = bd[0][3];
		for (i = 1; i < bd.length; i++)
			if (bd[i][3].compareTo(result) > 0) {
				result = bd[i][3];
			}
		return result.doubleValue();
	}
}

class BaseAreaComparator implements Comparator<BigDecimal[]> {
	@Override
	public int compare(BigDecimal[] a, BigDecimal[] b) {
		return -1 * a[1].multiply(a[2]).compareTo(b[1].multiply(b[2]));
	}
}

// http://people.cs.clemson.edu/~bcdean/dp_practice/