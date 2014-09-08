public class Main {
	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		String[] a = { "100 100 100" }, b = { "0,0:0", "0,2:5", "0,1:10" };
		System.out.println(vm.motorUse(a, b));
		String[] c = { "100 200 300", "600 500 400" }, d = { "0,0:0", "1,1:10", "1,2:20", "0,1:21", "1,0:22", "0,2:35" };
		System.out.println(vm.motorUse(c, d));
	}
}
