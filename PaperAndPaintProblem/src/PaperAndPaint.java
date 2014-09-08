import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// SRM 441 DIV 1 - 1000
public class PaperAndPaint {
	public long computeArea(int width, int height, int[] xfold, int[] cnt, int[] x1, int[] y1, int[] x2, int[] y2) {
		List<Element> le = new ArrayList<Element>();
		long k = xfold.length, j, x, y, cx, cy, smallHeight;
		int i, index;
		if (cnt.length != k || x1.length != k || y1.length != k || x2.length != k || y2.length != k)
			return -1;
		for (i = 0; i < k; i++) {
			for (x = x1[i]; x < x2[i]; x++) {
				cx = xfold[i] - x - 1;
				for (y = y1[i]; y < y2[i]; y++) {
					for (j = 0; j < cnt[i] + 1; j++) {
						smallHeight = height / (cnt[i] + 1);
						cy = (smallHeight) * j + (j % 2 == 0 ? y : smallHeight - 1 - y);
						if (xfold[i] + x < width) {
							Element e = new Element(xfold[i] + x, cy);
							index = Collections.binarySearch(le, e);
							if (index < 0) {
								le.add((index * -1) - 1, e);
							}
						}
						if (cx >= 0) {
							Element e = new Element(cx, cy);
							index = Collections.binarySearch(le, e);
							if (index < 0) {
								le.add((index * -1) - 1, e);
							}
						}
					}
				}
			}
		}
		BigInteger bi = BigInteger.valueOf(width * height);
		bi = bi.subtract(BigInteger.valueOf(le.size()));
		return bi.longValue();
	}
}

class Element implements Comparable<Element> {
	public long x, y;

	public Element(long x, long y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Element e) {
		if (this.x > e.x || this.y > e.y && this.x == e.x)
			return 1;
		if (this.x < e.x || this.y < e.y)
			return -1;
		return 0;
	}
}