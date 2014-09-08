import java.util.*;

public class Lottery {
	public String[] sortByOdds(String[] rules) {
		List<MyElement> l = new LinkedList<MyElement>();
		if (rules == null || rules.length == 0)
			return rules;
		if (rules.length == 1)
			return rules;
		for (int i = 0; i < rules.length; i++) {
			String s = rules[i];
			String[] tokens = s.split(": ");
			String name = tokens[0];
			tokens = s.replaceFirst(name + ": ", "").split(" ");
			int n = Integer.parseInt(tokens[0]), k = Integer.parseInt(tokens[1]);
			double probability;
			boolean sorted = (tokens[2].equals("T") ? true : false), unique = (tokens[3].equals("T") ? true : false);
			if (sorted) {
				if (unique) {
					probability = f(n) / (f(n - k) * f(k));
				} else {
					probability = f(n + k - 1) / (f(k) * f(n - 1));
				}
			} else {
				if (unique) {
					probability = 1;
					for (int t = 0; t < k; t++)
						probability *= (n - t);
				} else {
					probability = Math.pow(n, k);
				}
			}
			MyElement me = new MyElement(probability, name);
			l.add(me);
		}
		Collections.sort(l);
		rules = new String[l.size()];
		for (int i = 0; i < l.size(); i++) {
			rules[i] = l.get(i).getName();
		}
		return rules;
	}

	private static double f(int n) {
		double fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
}

class MyElement implements Comparable<MyElement> {
	private double value;
	private String name;

	public MyElement(double value, String name) {
		if (name == null)
			name = "";
		this.value = value;
		this.name = name;
	}

	public int compareTo(MyElement m) {
		if (this.value > m.value)
			return 1;
		else if (this.value < m.value)
			return -1;
		else
			return this.name.compareTo(m.name);
	}

	public String getName() {
		return this.name;
	}

	public double getValue() {
		return this.value;
	}
}