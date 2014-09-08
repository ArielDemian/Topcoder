import java.util.List;
import java.util.LinkedList;

public class StoneRemoving {
	public int stoneLeft(int n, int k, int m) {
		int i, lastIndex;
		List<Integer> ls = new LinkedList<Integer>();
		for (i = 1; i <= n; i++) {
			ls.add(i);
		}
		ls.remove(m - 1);
		lastIndex = m - 1;
		while (ls.size() > 1) {
			i = (lastIndex + k - 1) % ls.size();
			ls.remove(i);
			lastIndex = i;
		}
		return ls.get(0);
	}
}
// http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4140