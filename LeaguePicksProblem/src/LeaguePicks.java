import java.util.LinkedList;
import java.util.List;

// SRM 152 DIV 2 - 500
public class LeaguePicks {
	public int[] returnPicks(int position, int friends, int picks) {
		int i, pos = 1;
		boolean forward = true;
		List<Integer> li = new LinkedList<Integer>();
		for (i = 1; i <= picks; i++) {
			if (pos == position) {
				li.add(i);
			}
			if (forward) {
				if (pos == friends) {
					forward = false;
				} else
					pos++;
			} else if (pos == 1) {
				forward = true;
			} else
				pos--;
		}
		int[] r = new int[li.size()];
		for (i = 0; i < r.length; i++) {
			r[i] = li.get(i);
		}
		return r;
	}
}