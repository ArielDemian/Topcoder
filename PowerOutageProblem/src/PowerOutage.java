import java.util.LinkedList;
import java.util.List;

// SRM 144 DIV 2 - 1100
public class PowerOutage {
	public int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength) {
		int n = fromJunction.length;
		if (toJunction.length != n && ductLength.length != n)
			return -1;
		Node t = new Node(0, 0);
		build(t, fromJunction, toJunction, ductLength);
		return visit(t);
	}

	private static void build(Node t, int[] fromJunction, int[] toJunction, int[] ductLength) {
		Node n;
		int tToVisit = 0;
		for (int i = 0; i < fromJunction.length; i++) {
			if (t.x == fromJunction[i]) {
				n = new Node(toJunction[i], ductLength[i]);
				build(n, fromJunction, toJunction, ductLength);
				t.getSons().add(n);
			}
		}
		for (Node u : t.getSons()) {
			tToVisit += u.tToVisit + u.w * 2;
			if (u.longestT + u.w > t.longestT)
				t.longestT = u.longestT + u.w;
		}
		t.tToVisit = tToVisit;
	}

	private static int visit(Node t) {
		int timeToVisit = 0, maxLongest = 0, time;
		Node maxNode = null;
		for (Node n : t.getSons()) {
			time = n.tToVisit + n.w * 2;
			timeToVisit += time;
			if (n.longestT + n.w > maxLongest || maxNode == null) {
				maxLongest = n.longestT + n.w;
				maxNode = n;
			}
		}
		if (maxNode != null) {
			timeToVisit -= (maxNode.w * 2 + maxNode.tToVisit);
			timeToVisit += maxNode.w + visit(maxNode);
		}
		return timeToVisit;
	}
}

class Node {
	public int x, w, longestT, tToVisit;
	private List<Node> sons;

	public Node(int x, int w) {
		this.x = x;
		sons = new LinkedList<Node>();
		longestT = 0;
		tToVisit = 0;
		this.w = w;
	}

	public List<Node> getSons() {
		return this.sons;
	}
}