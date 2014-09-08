import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PenLift {
	/*
	 * A fairly well known theorem states that to go over all of the edges in a
	 * connected graph requires numOfOddVertices/2 total paths. This is related
	 * to Euler's famous theorem that a graph has an Eulerian walk if and only if
	 * the number of odd vertices is less than or equal to 2. So, now how does
	 * this apply? Well, if we look at the drawing we are trying to make as a
	 * graph, where intersections and endpoints are vertices, and segments are
	 * edges, then we are trying to go over all of the edges in this graph n
	 * times. This is the same as having n edges between each pair of adjacent
	 * vertices. So, once we construct the graph, we should first split it into a
	 * number of connected components, and then compute the number of odd
	 * vertices in each component. The total number of paths required will be the
	 * sum over all components(min(1,numberOfOddVerticesInComponent/2)). Since we
	 * get to start anywhere, the actual result will be one less than this.
	 * Finding the connected components and the number of odd vertices is pretty
	 * simple graph theory and can be done with a depth first search. The tricky
	 * part is building the graph.
	 * http://community.topcoder.com/tc?module=Static&
	 * d1=match_editorials&d2=srm144
	 */
	public int numTimes(String[] segments, int n) {
		List<Segment> s = new ArrayList<Segment>();
		List<Node> nodes = new ArrayList<Node>();
		int i = 0;
		for (i = 0; i < segments.length; i++) {
			String[] xy = segments[i].split(" ");
			s.add(new Segment(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]), Integer.parseInt(xy[2]), Integer.parseInt(xy[3])));
		}
		fixOverlap(s);
		addNodes(nodes, s);
		int oddGradeVertices, penLifts = 0;
		for (i = setComponents(nodes, s) - 1; i >= 0; i--) {
			oddGradeVertices = 0;
			for (Node u : nodes) {
				if (u.comp == i && (u.getSegments().size() * n) % 2 != 0) {
					oddGradeVertices++;
				}
			}
			if (oddGradeVertices <= 2)
				penLifts++;
			else
				penLifts += oddGradeVertices / 2;
		}
		return penLifts - 1;
	}

	private static void fixOverlap(List<Segment> s) {
		int i = 0, j = 0;
		Segment seg;
		out: while (i < s.size()) {
			j = i + 1;
			while (j < s.size()) {
				if (s.get(i).getM() == s.get(j).getM() && s.get(i).getQ() == s.get(j).getQ()) {
					if (s.get(i).getM() == Double.MAX_VALUE && s.get(i).getQ() == Double.MIN_VALUE) {
						if (s.get(i).getX1() != s.get(j).getX1()) {
							j++;
							continue;
						}
						if (s.get(i).getY1() <= s.get(j).getY1() && s.get(i).getY2() >= s.get(j).getY2()) {
							s.remove(j);
							i = 0;
							continue out;
						}
						if (s.get(i).getY1() <= s.get(j).getY1() && s.get(i).getY2() <= s.get(j).getY2() && s.get(i).getY2() >= s.get(j).getY1()) {
							seg = new Segment(s.get(i).getX1(), s.get(i).getY1(), s.get(j).getX2(), s.get(j).getY2());
							s.remove(j);
							s.remove(i);
							s.add(seg);
							i = 0;
							continue out;
						}
						if (s.get(i).getY1() >= s.get(j).getY1() && s.get(i).getY2() >= s.get(j).getY2() && s.get(i).getY1() <= s.get(j).getY2()) {
							seg = new Segment(s.get(j).getX1(), s.get(j).getY1(), s.get(i).getX2(), s.get(i).getY2());
							s.remove(j);
							s.remove(i);
							s.add(seg);
							i = 0;
							continue out;
						}
						if (s.get(i).getY1() >= s.get(j).getY1() && s.get(i).getY2() <= s.get(j).getY2()) {
							s.remove(i);
							i = 0;
							continue out;
						}
						j++;
						continue;
					}
					if (s.get(i).getX1() <= s.get(j).getX1() && s.get(i).getX2() >= s.get(j).getX2()) {
						s.remove(j);
						i = 0;
						continue out;
					}
					if (s.get(i).getX1() <= s.get(j).getX1() && s.get(i).getX2() <= s.get(j).getX2() && s.get(i).getX2() >= s.get(j).getX1()) {
						seg = new Segment(s.get(i).getX1(), s.get(i).getY1(), s.get(j).getX2(), s.get(j).getY2());
						s.remove(j);
						s.remove(i);
						s.add(seg);
						i = 0;
						continue out;
					}
					if (s.get(i).getX1() >= s.get(j).getX1() && s.get(i).getX2() >= s.get(j).getX2() && s.get(i).getX1() <= s.get(j).getX2()) {
						seg = new Segment(s.get(j).getX1(), s.get(j).getY1(), s.get(i).getX2(), s.get(i).getY2());
						s.remove(j);
						s.remove(i);
						s.add(seg);
						i = 0;
						continue out;
					}
					if (s.get(i).getX1() >= s.get(j).getX1() && s.get(i).getX2() <= s.get(j).getX2()) {
						s.remove(i);
						i = 0;
						continue out;
					}
				}
				j++;
			}
			i++;
		}
	}

	private static void addNodes(List<Node> n, List<Segment> s) {
		Node u;
		int i, j, k;
		for (i = 0; i < s.size(); i++) {
			u = new Node(s.get(i).getX1(), s.get(i).getY1());
			j = Collections.binarySearch(n, u);
			if (j < 0) {
				u.getSegments().add(s.get(i));
				s.get(i).a = u;
				n.add(Math.abs(j + 1), u);
			} else {
				s.get(i).a = n.get(j);
				n.get(j).getSegments().add(s.get(i));
			}
			u = new Node(s.get(i).getX2(), s.get(i).getY2());
			j = Collections.binarySearch(n, u);
			if (j < 0) {
				u.getSegments().add(s.get(i));
				s.get(i).b = u;
				n.add(Math.abs(j + 1), u);
			} else {
				s.get(i).b = n.get(j);
				n.get(j).getSegments().add(s.get(i));
			}
		}
		i = 0;
		double x, y;
		out: while (i < s.size()) {
			j = i + 1;
			while (j < s.size()) {
				if (s.get(i).getM() == s.get(j).getM()) {
					j++;
					continue;
				}
				if (s.get(i).getM() == Double.MAX_VALUE && s.get(i).getQ() == Double.MIN_VALUE) {
					x = s.get(i).getX1();
					y = s.get(j).getM() * x + s.get(j).getQ();
				} else if (s.get(j).getM() == Double.MAX_VALUE && s.get(j).getQ() == Double.MIN_VALUE) {
					x = s.get(j).getX1();
					y = s.get(i).getM() * x + s.get(i).getQ();
				} else {
					x = (s.get(j).getQ() - s.get(i).getQ()) / (s.get(i).getM() - s.get(j).getM());
					y = s.get(i).getM() * x + s.get(i).getQ();
				}
				if (s.get(i).getX1() > x || s.get(i).getX2() < x || s.get(j).getX1() > x || s.get(j).getX2() < x) {
					j++;
					continue;
				}
				if (s.get(i).getM() == Double.MAX_VALUE && s.get(i).getQ() == Double.MIN_VALUE) {
					if (s.get(i).getY1() > y || s.get(i).getY2() < y) {
						j++;
						continue;
					}
				}
				if (s.get(j).getM() == Double.MAX_VALUE && s.get(j).getQ() == Double.MIN_VALUE) {
					if (s.get(j).getY1() > y || s.get(j).getY2() < y) {
						j++;
						continue;
					}
				}
				u = new Node(x, y);
				k = Collections.binarySearch(n, u);
				if (k < 0) {
					n.add(Math.abs(k + 1), u);
					if (!s.get(i).a.getSegments().remove(s.get(i)) || !s.get(i).b.getSegments().remove(s.get(i)) || !s.get(j).a.getSegments().remove(s.get(j)) || !s.get(j).b.getSegments().remove(s.get(j))) {
						System.out.println("ERROR: could not delete segment from node");
					}
					Segment seg1 = new Segment(x, y, s.get(i).getX1(), s.get(i).getY1());
					u.getSegments().add(seg1);
					s.get(i).a.getSegments().add(seg1);
					seg1.a = s.get(i).a;
					seg1.b = u;
					Segment seg2 = new Segment(x, y, s.get(i).getX2(), s.get(i).getY2());
					u.getSegments().add(seg2);
					s.get(i).b.getSegments().add(seg2);
					seg2.a = u;
					seg2.b = s.get(i).b;
					Segment seg3 = new Segment(x, y, s.get(j).getX1(), s.get(j).getY1());
					u.getSegments().add(seg3);
					s.get(j).a.getSegments().add(seg3);
					seg3.a = s.get(j).a;
					seg3.b = u;
					Segment seg4 = new Segment(x, y, s.get(j).getX2(), s.get(j).getY2());
					u.getSegments().add(seg4);
					s.get(j).b.getSegments().add(seg4);
					seg4.a = u;
					seg4.b = s.get(j).b;
					s.remove(j);
					s.remove(i);
					s.add(seg1);
					s.add(seg2);
					s.add(seg3);
					s.add(seg4);
					i = 0;
					continue out;
				} else {
					boolean fi = false, fj = false;
					for (Segment segm : n.get(k).getSegments()) {
						if (segm.getX1() == s.get(i).getX1() && segm.getY1() == s.get(i).getY1() && segm.getX2() == s.get(i).getX2() && segm.getY2() == s.get(i).getY2())
							fi = true;
						if (segm.getX1() == s.get(j).getX1() && segm.getY1() == s.get(j).getY1() && segm.getX2() == s.get(j).getX2() && segm.getY2() == s.get(j).getY2())
							fj = true;
						if (fi && fj)
							break;
					}
					if (!fj) {
						i = j;
					}
					if (!fi || !fj) {
						Segment seg1 = new Segment(n.get(k).x, n.get(k).y, s.get(i).getX1(), s.get(i).getY1());
						n.get(k).getSegments().add(seg1);
						s.get(i).a.getSegments().remove(s.get(i));
						s.get(i).a.getSegments().add(seg1);
						seg1.a = s.get(i).a;
						seg1.b = n.get(k);
						Segment seg2 = new Segment(n.get(k).x, n.get(k).y, s.get(i).getX2(), s.get(i).getY2());
						n.get(k).getSegments().add(seg2);
						s.get(i).b.getSegments().remove(s.get(i));
						s.get(i).b.getSegments().add(seg2);
						seg2.a = n.get(k);
						seg2.b = s.get(i).b;
						s.remove(i);
						s.add(seg1);
						s.add(seg2);
						i = 0;
						continue out;
					}
				}
				j++;
			}
			i++;
		}
	}

	private static int setComponents(List<Node> n, List<Segment> s) {
		int i, k = 0;
		Queue<Node> q = new LinkedList<Node>();
		Node u, m;
		for (i = 0; i < n.size(); i++) {
			if (n.get(i).comp >= 0)
				continue;
			n.get(i).v = true;
			n.get(i).comp = k;
			q.add(n.get(i));
			while (!q.isEmpty()) {
				u = q.poll();
				for (Segment seg : u.getSegments()) {
					if (seg.a.equals(u)) {
						m = seg.b;
					} else {
						m = seg.a;
					}
					if (!m.v) {
						m.comp = k;
						m.v = true;
						q.add(m);
					}
				}
			}
			k++;
		}
		return k;
	}
}

class Segment {
	private double x1, y1, x2, y2, m, q;
	public Node a, b;

	public Segment(double x1, double y1, double x2, double y2) {
		if (x1 < x2 || x1 == x2 && y1 < y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		} else {
			this.x1 = x2;
			this.x2 = x1;
			this.y1 = y2;
			this.y2 = y1;
		}
		a = null;
		b = null;
		calculate();
	}

	public void setX1(double x1) {
		this.x1 = x1;
		calculate();
	}

	public void setY1(double y1) {
		this.y1 = y1;
		calculate();
	}

	public void setX2(double x2) {
		this.x2 = x2;
		calculate();
	}

	public void setY2(double y2) {
		this.y2 = y2;
		calculate();
	}

	public double getX1() {
		return x1;
	}

	public double getY1() {
		return y1;
	}

	public double getX2() {
		return x2;
	}

	public double getY2() {
		return y2;
	}

	public double getM() {
		return m;
	}

	public double getQ() {
		return q;
	}

	private void calculate() {
		if (this.x1 != this.x2) {
			this.m = (this.y1 - this.y2) / (this.x1 - this.x2);
			this.q = this.y1 - this.m * this.x1;
		} else {
			this.m = Double.MAX_VALUE;
			this.q = Double.MIN_VALUE;
		}
	}
}

class Node implements Comparable<Node> {
	public double x, y;
	public int comp;
	public boolean v;
	private List<Segment> segments;

	public Node(double x, double y) {
		this.x = x;
		this.y = y;
		this.comp = -1;
		this.v = false;
		segments = new LinkedList<Segment>();
	}

	public int compareTo(Node n) {
		if (x > n.x)
			return 1;
		if (x < n.x)
			return -1;
		if (y > n.y)
			return 1;
		if (y < n.y)
			return -1;
		return 0;
	}

	public List<Segment> getSegments() {
		return this.segments;
	}
}