public class RectangularGrid {
	public long countRectangles(int width, int height) {
		if (width <= 0 || height <= 0)
			return -1;
		long rects = 0;
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				long a = height - r, b = width - c;
				rects += (a * b - (a < b ? a : b));
			}
		}
		return rects;
	}
}