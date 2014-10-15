import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortishDiv2 {
	private int sortedness;

	public int ways(int sortedness, int[] seq) {
		this.sortedness = sortedness;
		List<Integer> miss = new ArrayList<Integer>();
		int n = seq.length, i;
		for (i = 1; i <= n; i++)
			miss.add(i);
		for (i = 0; i < n; i++) {
			if (seq[i] > 0)
				miss.remove(Collections.binarySearch(miss, seq[i]));
		}
		int calcSortedness = calculateSortedness(seq, sortedness);
		if (calcSortedness < 0)
			return 0;
		return fillMissing(seq, 0, miss, calcSortedness);
	}

	private int fillMissing(int[] seq, int i, List<Integer> miss, int presentSortedness) {
		int j, y;
		boolean f = false;
		for (j = i; j < seq.length; j++) {
			if (seq[j] == 0) {
				f = true;
				break;
			}
		}
		if (f) {
			int ret = 0, calcSortedness, a, z;
			out: for (z = 0; z < miss.size(); z++) {
				a = miss.get(z);
				seq[j] = a;
				miss.remove(z);
				calcSortedness = presentSortedness;
				for (y = 0; y < seq.length; y++) {
					if (y == j || seq[y] == 0)
						continue;
					if (y < j && seq[y] < seq[j])
						calcSortedness++;
					else if (y > j && seq[y] > seq[j])
						calcSortedness++;
					if (calcSortedness > sortedness) {
						miss.add(z, a);
						continue out;
					}
				}
				ret += fillMissing(seq, j + 1, miss, calcSortedness);
				miss.add(z, a);
			}
			seq[j] = 0;
			return ret;
		} else if (presentSortedness == sortedness)
			return 1;
		else
			return 0;
	}

	private int calculateSortedness(int[] seq, int target) {
		int c = 0, i, j;
		for (i = 0; i < seq.length - 1; i++) {
			for (j = i + 1; j < seq.length; j++) {
				if (seq[i] != 0 && seq[j] != 0 && seq[i] < seq[j])
					c++;
				if (c > target)
					return -1;
			}
		}
		return c;
	}
}