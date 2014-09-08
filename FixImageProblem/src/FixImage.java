import java.util.LinkedList;
import java.util.Queue;

//Thanks to https://github.com/TomConerly for the hint for the solution
//SRM 396 DIV 1 - 500
public class FixImage {
	private int h, w;

	public String[] originalImage(String[] alteredImage) {
		h = alteredImage.length;
		w = alteredImage[0].length();
		int i, j, c;
		Node[][] m = new Node[h][w];
		for (i = 0; i < h; i++) {
			for (j = 0; j < w; j++) {
				m[i][j] = new Node(i, j, alteredImage[i].charAt(j));
			}
		}
		c = 0;
		for (i = 0; i < h; i++) {
			for (j = 0; j < w; j++) {
				if (m[i][j].type == '#' && m[i][j].comp < 0) {
					addComp(m, i, j, c);
					c++;
				}
			}
		}
		c = 0;
		boolean changed;
		out: for (i = 0; i < h; i++) {
			for (j = 0; j < w; j++) {
				if (m[i][j].type == '#') {
					changed = false;
					for (c = 1; c < Math.max(h - i, w - j) || i - c >= 0 || j - c >= 0; c++) {
						if (i - c >= 0 && m[i - c][j].type == '#' && m[i - c][j].comp == m[i][j].comp && m[i - c + 1][j].type == '.') {
							fill(i, j, i - c, j, m);
							changed = true;
						}
						if (i + c < h && m[i + c][j].type == '#' && m[i + c][j].comp == m[i][j].comp && m[i + c - 1][j].type == '.') {
							fill(i, j, i + c, j, m);
							changed = true;
						}
						if (j - c >= 0 && m[i][j - c].type == '#' && m[i][j - c].comp == m[i][j].comp && m[i][j - c + 1].type == '.') {
							fill(i, j, i, j - c, m);
							changed = true;
						}
						if (j + c < w && m[i][j + c].type == '#' && m[i][j + c].comp == m[i][j].comp && m[i][j + c - 1].type == '.') {
							fill(i, j, i, j + c, m);
							changed = true;
						}
						if (changed) {
							unVisit(m);
							addComp(m, i, j, m[i][j].comp);
							i = -1;
							continue out;
						}
					}
				}
			}
		}
		return buildResult(m);
	}

	private String[] buildResult(Node[][] m) {
		String[] ret = new String[h];
		int i, j;
		for (i = 0; i < h; i++) {
			ret[i] = "";
			for (j = 0; j < w; j++) {
				ret[i] += "" + m[i][j].type;
			}
		}
		return ret;
	}

	private void unVisit(Node[][] m) {
		int i, j;
		for (i = 0; i < h; i++) {
			for (j = 0; j < w; j++) {
				m[i][j].visited = false;
			}
		}
	}

	private void fill(int i, int j, int r, int c, Node[][] m) {
		int y;
		if (i == r) {
			for (y = 1; y <= Math.abs(j - c); y++) {
				m[i][j + (j < c ? y : -y)].type = '#';
				m[i][j + (j < c ? y : -y)].comp = m[i][j].comp;
			}
			return;
		}
		if (j == c) {
			for (y = 1; y <= Math.abs(i - r); y++) {
				m[i + (i < r ? y : -y)][j].type = '#';
				m[i + (i < r ? y : -y)][j].comp = m[i][j].comp;
			}
			return;
		}
		System.out.println("ERROR");
		return;
	}

	private void addComp(Node[][] m, int i, int j, int comp) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(m[i][j]);
		m[i][j].comp = comp;
		m[i][j].visited = true;
		Node t;
		while (!q.isEmpty()) {
			t = q.poll();
			if (t.r - 1 >= 0 && m[t.r - 1][t.c].type == '#' && !m[t.r - 1][t.c].visited) {
				q.add(m[t.r - 1][t.c]);
				m[t.r - 1][t.c].comp = comp;
				m[t.r - 1][t.c].visited = true;
			}
			if (t.r + 1 < h && m[t.r + 1][t.c].type == '#' && !m[t.r + 1][t.c].visited) {
				q.add(m[t.r + 1][t.c]);
				m[t.r + 1][t.c].comp = comp;
				m[t.r + 1][t.c].visited = true;
			}
			if (t.c - 1 >= 0 && m[t.r][t.c - 1].type == '#' && !m[t.r][t.c - 1].visited) {
				q.add(m[t.r][t.c - 1]);
				m[t.r][t.c - 1].comp = comp;
				m[t.r][t.c - 1].visited = true;
			}
			if (t.c + 1 < w && m[t.r][t.c + 1].type == '#' && !m[t.r][t.c + 1].visited) {
				q.add(m[t.r][t.c + 1]);
				m[t.r][t.c + 1].comp = comp;
				m[t.r][t.c + 1].visited = true;
			}
		}
	}
}

class Node {
	int r, c, comp;
	boolean visited;
	char type;

	public Node(int r, int c, char type) {
		this.r = r;
		this.c = c;
		this.type = type;
		comp = -1;
		visited = false;
	}
}