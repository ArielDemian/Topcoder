public class Main {
	public static void main(String[] args) {
		RunnableMessageMess m = new RunnableMessageMess();
		String[] p={"A", "BA", "BABA", "AR", "ABA"};
		System.out.println(m.restore(p, "ABABABABABABABABABABABABABABABABABABABABABABABAR"));
		String[] d = {"A", "BA", "BABA", "AR", "ABA", "ABAB"};
		System.out.println(m.restore(d, "ABABABABABABABABABABABABABABABABABABABABABABAR"));
	}
}
