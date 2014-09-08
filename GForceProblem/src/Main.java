public class Main {
	public static void main(String[] args) {
		GForce g = new GForce();
		/*int[] accel0 = { 1500, 1500, 500, 2000 };
		int[] time0 = { 0, 100, 150, 225 };
		System.out.println(g.avgAccel(100, accel0, time0));*/
		int[] accel1 = {0, 5, 5, 0, 6};
		int[] time1 = {0, 5, 15, 25, 31};
		System.out.println(g.avgAccel(26, accel1, time1));
	}
}
