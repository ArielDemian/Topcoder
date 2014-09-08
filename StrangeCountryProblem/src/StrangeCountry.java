import java.util.Stack;

//Topcoder SRM 441 DIV 1-500
public class StrangeCountry {
	public int transform(String[] g) {
		int i, f = 0, j, addLinks = 0, nrNodesComp;
		for (i = 0; i < g.length; i++) {
			if (g[i].length() != g.length)
				return -1;
			for (j = 0; j < g[i].length(); j++) {
				if (i == j) {
					if (g[i].charAt(j) == 'Y')
						return -1;
					else
						continue;
				}
				if (g[i].charAt(j) != g[j].charAt(i))
					return -1;
			}
		}
		Stack<Integer> s = new Stack<Integer>();
		int[] n = new int[g.length];
		for (i = 0; i < g.length; i++) {
			if (n[i] == 0) {
				f++;
				nrNodesComp = 1;
				n[i] = f;
				s.push(i);
				while (!s.isEmpty()) {
					int node = s.pop();
					for (j = 0; j < g[node].length(); j++) {
						if (g[node].charAt(j) == 'Y') {
							g[node] = g[node].substring(0, j) + "N" + g[node].substring(j + 1);
							g[j] = g[j].substring(0, node) + "N" + g[j].substring(node + 1);
							if (n[j] == 0) {
								s.push(j);
								nrNodesComp++;
								n[j] = f;
							} else {
								addLinks++;
							}
						}
					}
				}
				if (nrNodesComp <= 1)
					return -1;
			}
		}
		if (f == 1)
			return 0;
		if (addLinks < f - 1)
			return -1;
		else
			return f - 1;
	}
}