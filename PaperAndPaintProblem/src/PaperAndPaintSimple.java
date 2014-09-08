import java.util.BitSet;

// SRM 441 DIV 1 - 1000
public class PaperAndPaintSimple {
	public long computeArea(int width, int height, int[] xfold, int[] cnt, int[] x1, int[] y1, int[] x2, int[] y2) {
		BitSet[] bs = new BitSet[height];
		int k = xfold.length, i, j, x, y, cx, cy, smallHeight;
		if (cnt.length != k || x1.length != k || y1.length != k || x2.length != k || y2.length != k)
			return -1;
		for (i = 0; i < height; i++)
			bs[i] = new BitSet();
		for (i = 0; i < k; i++) {
			for (x = x1[i]; x < x2[i]; x++) {
				cx = xfold[i] - x - 1;
				for (y = y1[i]; y < y2[i]; y++) {
					for (j = 0; j < cnt[i] + 1; j++) {
						smallHeight = height / (cnt[i] + 1);
						cy = (smallHeight) * j + (j % 2 == 0 ? y : smallHeight - 1 - y);
						if (xfold[i] + x < width && !bs[cy].get(xfold[i] + x))
							bs[cy].set(xfold[i] + x);
						if (cx >= 0 && !bs[cy].get(cx))
							bs[cy].set(cx);
					}
				}
			}
		}
		j = 0;
		for (i = 0; i < height; i++) {
			j += width - bs[i].cardinality();
		}
		return j;
	}
}