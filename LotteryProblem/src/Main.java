public class Main {
	public static void main(String[] args) {
		Lottery l = new Lottery();
		String[] rules = { "PICK ANY TWO: 10 2 F F", "PICK TWO IN ORDER: 10 2 T F", "PICK TWO DIFFERENT: 10 2 F T", "PICK TWO LIMITED: 10 2 T T" };
		l.sortByOdds(rules);
		for (String s : rules)
			System.out.println(s);
	}
}