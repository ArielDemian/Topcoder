public class Main {

	public static void main(String[] args) {
		NonRepeat nr = new NonRepeat();
		char[][] c = { { 'A', 'B', 'C' }, { 'D' }, { 'F', 'B' } };
		System.out.println(nr.count(c));
	}

}
