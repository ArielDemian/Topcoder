import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DotNotation {
	private static int min = -2000000000, max = 2000000000;
	private boolean oneValue;
	// TODO: remove count
	private int count;

	public DotNotation() {
		this.oneValue = false;
		count = 0;
	}

	public int countAmbiguity(String dotForm) {
		if (!dotForm.matches("^[0-9](\\.*[+\\-*/]\\.*[0-9])*$"))
			return 0;
		if (dotForm.length() == 1)
			return 1;
		char[] exp = dotForm.toCharArray();
		List<Node> nodes = new ArrayList<Node>();
		Node n = null;
		int c = 0, i;
		for (i = 0; i < exp.length; i++) {
			if (exp[i] >= '0' && exp[i] <= '9') {
				if (n != null)
					n.rightDots = c;
				c = 0;
				n = new Node(exp[i], i);
				nodes.add(n);
				continue;
			}
			if (exp[i] == '.') {
				c++;
				continue;
			}
			n = new Node(exp[i], i);
			n.leftDots = c;
			nodes.add(n);
			c = 0;
		}
		i = verifyOperationsType(nodes);
		if (i == 0)
			return i;
		return generate(nodes);
	}

	private int verifyOperationsType(List<Node> nodes) {
		boolean allPlusMinus = true, allMultDiv = true;
		Node n;
		for (int i = 0; i < nodes.size(); i++) {
			n = nodes.get(i);
			if (n.number && n.value == 0 && i > 0 && nodes.get(i - 1).op == '/')
				return 0;
			if (!n.number) {
				if (n.op == '+' || n.op == '-')
					allMultDiv = false;
				else
					allPlusMinus = false;
			}
		}
		if (allMultDiv || allPlusMinus) {
			oneValue = true;
			return 1;
		} else
			return 2;
	}

	private int generate(List<Node> nodes) {
		List<Long> results = new ArrayList<Long>();
		long result;
		Node t = null, n = null, u = null;
		int nrOps = nodes.size() / 2, i, j, prev;
		int[] permSwaps = new int[nrOps], perms = new int[nrOps];
		boolean valid;
		for (i = 0; i < permSwaps.length; i++) {
			permSwaps[i] = i;
			perms[i] = i;
		}
		while (true) {
			count++;
			valid = true;
			out: for (i = 0; i < nrOps; i++) {
				n = nodes.get(perms[i] * 2 + 1);
				for (j = i - 1; j >= 0; j--) {
					u = nodes.get(perms[j] * 2 + 1);
					if (u.pos > n.pos) {
						if (u.leftDots < n.rightDots) {
							valid = false;
							break out;
						}
					} else {
						if (u.rightDots < n.leftDots) {
							valid = false;
							break out;
						}
					}
				}
			}
			if (valid) {
				for (i = 0; i < nrOps; i++) {
					n = nodes.get(perms[i] * 2 + 1);
					if (i == 0)
						t = n;
					else {
						insertNode(t, n);
					}
				}
				for (i = 0; i < nodes.size(); i++) {
					if (nodes.get(i).number)
						insertNode(t, nodes.get(i));
				}
				try {
					result = calculate(t);
					i = Collections.binarySearch(results, result);
					if (i < 0)
						results.add(Math.abs(i + 1), result);
				} catch (Exception e) {
				}
				if (oneValue)
					return results.size();
			}
			for (i = 0; i < nodes.size(); i++) {
				n = nodes.get(i);
				n.right = null;
				n.left = null;
				n.parent = null;
			}
			i = permSwaps.length - 1;
			while (i >= 0 && permSwaps[i] == perms.length - 1) {
				swap(i, permSwaps[i], perms);
				permSwaps[i] = i;
				i--;
			}
			if (i < 0) {
				System.out.println(count);
				return results.size();
			}
			prev = permSwaps[i];
			swap(i, prev, perms);
			prev++;
			permSwaps[i] = prev;
			swap(i, prev, perms);
		}
	}

	private static void insertNode(Node t, Node ins) {
		if (t.pos < ins.pos) {
			if (t.right == null) {
				t.right = ins;
				ins.parent = t;
			} else
				insertNode(t.right, ins);
		} else {
			if (t.left == null) {
				t.left = ins;
				ins.parent = t;
			} else
				insertNode(t.left, ins);
		}
	}

	private static void swap(int i, int j, int[] perms) {
		if (i == j)
			return;
		int temp = perms[i];
		perms[i] = perms[j];
		perms[j] = temp;
	}

	private static long calculate(Node t) throws Exception {
		if (t.number)
			return t.value;
		long a = calculate(t.left), b = calculate(t.right);
		if (t.op == '/' && b == 0 || a < min || a > max || b < min || b > max)
			throw new Exception();
		switch (t.op) {
		case '+':
			a += b;
			break;
		case '-':
			a -= b;
			break;
		case '*':
			a *= b;
			break;
		case '/':
			a /= b;
			break;
		}
		if (a < min || a > max)
			throw new Exception();
		return a;
	}
}

class Node {
	public boolean number;
	public char op;
	public int value, leftDots, rightDots, pos;
	public Node left, right, parent;

	public Node(char c, int pos) {
		if (c >= '0' && c <= '9') {
			value = Integer.parseInt("" + c);
			number = true;
		} else {
			number = false;
			op = c;
		}
		left = null;
		right = null;
		leftDots = 0;
		rightDots = 0;
		this.pos = pos;
	}
}