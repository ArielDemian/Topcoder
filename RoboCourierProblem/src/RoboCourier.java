import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class RoboCourier {
	public List<Node> g;

	public int timeToDeliver(String[] path) {
		List<Node> g = new ArrayList<Node>();
		Node n1 = new Node(0, 0, 0), n2, origin = n1;
		n1.dist = 0;
		g.add(n1);
		n1.first = true;
		addCircleNodes(g, n1);
		int i, pos, z = 0;
		long x = 0;
		double y = 0;
		for (i = 0; i < path.length; i++) {
			if (!path[i].matches("^[FLR]*$"))
				return -1;
			for (int j = 0; j < path[i].length(); j++) {
				switch (path[i].charAt(j)) {
				case 'L':
					z = (z == 0 ? 5 : z - 1);
					n2 = new Node(x, y, z);
					pos = Collections.binarySearch(g, n2);
					if (pos < 0) {
						System.out.println("ERROR: left turn without node");
					} else
						n1 = g.get(pos);
					break;
				case 'R':
					z = (z + 1) % 6;
					n2 = new Node(x, y, z);
					pos = Collections.binarySearch(g, n2);
					if (pos < 0) {
						System.out.println("ERROR: right turn without node");
					} else
						n1 = g.get(pos);
					break;
				case 'F':
					switch (z) {
					case 0:
						x = n1.x;
						y = n1.y + 1;
						break;
					case 1:
						x = n1.x + 1;
						y = n1.y + 0.5;
						break;
					case 2:
						x = n1.x + 1;
						y = n1.y - 0.5;
						break;
					case 3:
						x = n1.x;
						y = n1.y - 1;
						break;
					case 4:
						x = n1.x - 1;
						y = n1.y - 0.5;
						break;
					case 5:
						x = n1.x - 1;
						y = n1.y + 0.5;
						break;
					}
					n2 = new Node(x, y, z);
					n1 = move(g, n1, n2);
					break;
				}
			}
		}
		for (Node u : g) {
			if (u.x == n1.x && u.y == n1.y)
				u.last = true;
		}
		addShortcuts(g);
		return calcDist(g, origin);
	}

	private static Node move(List<Node> g, Node n1, Node n2) {
		int pos = Collections.binarySearch(g, n2);
		boolean f = false;
		Node v;
		Object[] o;
		if (pos >= 0) {
			n2 = g.get(pos);
			for (Object[] ob : n1.getNeighbours()) {
				v = (Node) ob[1];
				if (v.x == n2.x && v.y == n2.y && v.z == n2.z) {
					f = true;
				}
			}
		} else {
			g.add(Math.abs(pos + 1), n2);
			addCircleNodes(g, n2);
		}
		if (!f) {
			o = new Object[2];
			o[0] = (int) 4;
			o[1] = n2;
			n1.getNeighbours().add(o);
			o = new Object[2];
			o[0] = (int) 4;
			pos = Collections.binarySearch(g, new Node(n1.x, n1.y, (n1.z + 3) % 6));
			o[1] = g.get(pos);
			pos = Collections.binarySearch(g, new Node(n2.x, n2.y, (n2.z + 3) % 6));
			g.get(pos).getNeighbours().add(o);
		}
		return n2;
	}

	private static void addCircleNodes(List<Node> g, Node n) {
		int i, pos, z = n.z;
		Object[] o;
		Node u, v = n;
		for (i = (z + 1) % 6; i != z; i = (i + 1) % 6) {
			u = new Node(n.x, n.y, i);
			u.first = n.first;
			pos = Collections.binarySearch(g, u);
			if (pos < 0) {
				o = new Object[2];
				o[0] = 3;
				o[1] = u;
				v.getNeighbours().add(o);
				o = new Object[2];
				o[0] = 3;
				o[1] = v;
				u.getNeighbours().add(o);
				g.add(Math.abs(pos + 1), u);
				v = u;
			} else {
				System.out.println("ERROR: this node shouldn't exist");
			}
		}
		o = new Object[2];
		o[0] = 3;
		o[1] = n;
		v.getNeighbours().add(o);
		o = new Object[2];
		o[0] = 3;
		o[1] = v;
		n.getNeighbours().add(o);
	}

	private static void addShortcuts(List<Node> g) {
		long x;
		double y;
		int z, pos, c;
		Object[] o;
		Node n2, prev, v;
		boolean f;
		for (Node n1 : g) {
			x = n1.x;
			y = n1.y;
			z = n1.z;
			c = 0;
			prev = null;
			while (true) {
				switch (z) {
				case 0:
					y++;
					break;
				case 1:
					x++;
					y += 0.5;
					break;
				case 2:
					x++;
					y -= 0.5;
					break;
				case 3:
					y--;
					break;
				case 4:
					x--;
					y -= 0.5;
					break;
				case 5:
					x--;
					y += 0.5;
					break;
				}
				n2 = new Node(x, y, z);
				pos = Collections.binarySearch(g, n2);
				if (pos < 0) {
					break;
				} else {
					if (prev == null)
						prev = n1;
					f = false;
					for (Object[] a : prev.getNeighbours()) {
						v = (Node) a[1];
						if (v.x == x && v.y == y && v.z == z){
							f = true;
							break;
						}
					}
					if (!f)
						break;
					c++;
					n2 = g.get(pos);
					prev = n2;
					if (c > 2) {
						o = new Object[2];
						o[0] = (int) 2 * c + 4;
						o[1] = n2;
						n1.getNeighbours().add(o);
					}
				}
			}
		}
	}

	private int calcDist(List<Node> g, Node n) {
		List<Node> q = new LinkedList<Node>();
		DistComparator comp = new DistComparator();
		Node u, v;
		int w, pos;
		q.add(n);
		while (!q.isEmpty()) {
			u = q.remove(0);
			for (Object[] o : u.getNeighbours()) {
				w = (int) o[0];
				v = (Node) o[1];
				if (v.dist == Integer.MAX_VALUE) {
					v.dist = u.dist + w;
					pos = Collections.binarySearch(q, v, comp);
					v.prev = u;
					q.add((pos < 0 ? Math.abs(pos + 1) : pos), v);
				} else if (u.dist + w < v.dist) {
					v.dist = u.dist + w;
					v.prev = u;
					if (!q.remove(v)) {
						System.out.println("ERROR: the node should be in the list.");
						return -1;
					} else {
						pos = Collections.binarySearch(q, v, comp);
						q.add((pos < 0 ? Math.abs(pos + 1) : pos), v);
					}
				}
			}
		}
		int minDist = Integer.MAX_VALUE;
		for (Node a : g)
			if (a.last && a.dist < minDist)
				minDist = a.dist;
		this.g = g;
		return minDist;
	}
}

class DistComparator implements Comparator<Node> {

	public int compare(Node n1, Node n2) {
		if (n1.dist > n2.dist)
			return 1;
		if (n1.dist < n2.dist)
			return -1;
		return 0;
	}

}

class Node implements Comparable<Node> {
	private List<Object[]> neighbours;
	public double y;
	public long x;
	public int dist, z;
	public boolean visited;
	public boolean first, last;
	public Node prev;

	public Node(long x, double y) {
		this(x, y, 0);
	}

	public Node(long x, double y, int z) {
		neighbours = new LinkedList<Object[]>();
		this.x = x;
		this.y = y;
		this.z = z;
		dist = Integer.MAX_VALUE;
		visited = false;
		first = false;
		last = false;
		this.prev = null;
	}

	public List<Object[]> getNeighbours() {
		return this.neighbours;
	}

	public int compareTo(Node n) {
		if (this.x > n.x)
			return 1;
		if (this.x < n.x)
			return -1;
		if (this.y > n.y)
			return 1;
		if (this.y < n.y)
			return -1;
		if (this.z > n.z)
			return 1;
		if (this.z < n.z)
			return -1;
		return 0;
	}
}