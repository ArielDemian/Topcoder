import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// SMR 149 DIV 2 - 1000
public class Pricing {
	private static final int groups = 4;

	public int maxSales(int[] price) {
		int result = 0;
		if (price.length <= groups) {
			for (int p : price)
				result += p;
		} else {
			Arrays.sort(price);
			List<Integer> li = new LinkedList<Integer>();
			for (int i = 0; i < price.length; i++) {
				if (li.size() >= 1 && li.get(li.size() - 1) == price[i])
					continue;
				else {
					li.add(price[i]);
				}
			}
			int p[] = new int[4];
			if (li.size() < 4) {
				int y = 0;
				for (int i = li.size() - 1; i >= 0; i--) {
					p[y] = li.get(i);
					y++;
					if (y >= groups)
						break;
				}
				return calculatePrices(p, price);
			} else {
				int sum;
				for (int i = li.size() - 1; i >= 3; i--) {
					p[0] = li.get(i);
					for (int j = i - 1; j >= 2; j--) {
						p[1] = li.get(j);
						for (int y = j - 1; y >= 1; y--) {
							p[2] = li.get(y);
							for (int z = y - 1; z >= 0; z--) {
								p[3] = li.get(z);
								sum = calculatePrices(p, price);
								if (result < sum)
									result = sum;
							}
						}
					}
				}
			}
		}
		return result;
	}

	private static int calculatePrices(int[] p, int[] price) {
		int i = 0, result = 0, j;
		for (j = price.length - 1; j >= 0; j--) {
			if (price[j] >= p[i])
				result += p[i];
			else {
				i++;
				if (i >= groups)
					break;
				j++;
			}
		}
		return result;
	}
}