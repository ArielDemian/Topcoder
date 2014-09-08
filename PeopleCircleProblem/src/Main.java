public class Main {
	public static void main(String[] args) {
		PeopleCircle pc = new PeopleCircle();
		System.out.println(pc.order(5, 3, 2));
		System.out.println(pc.order(7, 3, 1));
		System.out.println(pc.order(25, 25, 1000));
		System.out.println(pc.order(5, 5, 3));
		System.out.println(pc.order(1, 0, 245));
	}
}