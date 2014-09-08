public class VendingMachine {
	public int motorUse(String[] prices, String[] purchases) {
		if (prices == null || purchases == null || prices.length == 0 || prices[0].length() == 0)
			return -1;
		int columns = prices[0].split(" ").length;
		int[][] pr = new int[prices.length][columns];
		for (int i = 0; i < pr.length; i++) {
			String[] pricesString = prices[i].split(" ");
			for (int y = 0; y < pr[0].length; y++) {
				pr[i][y] = Integer.parseInt(pricesString[y]);
			}
		}
		if (purchases.length == 0) {
			return timeToRotate(0, pr)[1];
		}
		int[][] pu = new int[purchases.length][3];
		for (int i = 0; i < purchases.length; i++) {
			String[] purchasesString = purchases[i].split("[,:]");
			for (int y = 0; y < 3; y++) {
				pu[i][y] = Integer.parseInt(purchasesString[y]);
			}
		}
		if (doublePurchase(pu))
			return -1;
		int workSecs = 0, presentColumn, timeLastPurchase = 0;
		int[] a = timeToRotate(0, pr);
		workSecs += a[1];
		presentColumn = a[0];
		for (int i = 0; i < pu.length; i++) {
			if (pu[i][2] - timeLastPurchase >= 5) {
				timeLastPurchase = pu[i][2];
				a = timeToRotate(presentColumn, pr);
				workSecs += a[1];
				presentColumn = a[0];
			}
			workSecs += distanceInCircle(presentColumn, pu[i][1], columns);
			presentColumn = pu[i][1];
			pr[pu[i][0]][pu[i][1]] = 0;
			timeLastPurchase = pu[i][2];
		}
		workSecs += timeToRotate(presentColumn, pr)[1];
		return workSecs;
	}

	private static boolean doublePurchase(int[][] pu) {
		for (int i = 0; i < pu.length; i++)
			for (int y = i + 1; y < pu.length; y++)
				if (pu[i][0] == pu[y][0] && pu[i][1] == pu[y][1])
					return true;
		return false;
	}

	private static int[] timeToRotate(int presentColumn, int[][] prices) {
		int maxPrice = -1, maxColumn = -1;
		int[] result = new int[2];
		for (int i = 0; i < prices[0].length; i++) {
			int columnTotalPrice = 0;
			for (int y = 0; y < prices.length; y++) {
				columnTotalPrice += prices[y][i];
			}
			if (maxPrice < columnTotalPrice) {
				maxColumn = i;
				maxPrice = columnTotalPrice;
			}
		}
		result[0] = maxColumn;
		result[1] = distanceInCircle(presentColumn, maxColumn, prices[0].length);
		return result;
	}

	private static int distanceInCircle(int n1, int n2, int columns) {
		if (n1 == n2)
			return 0;
		if (Math.abs(n1 - n2) > (columns / 2)) {
			if (n1 > n2)
				n2 += columns;
			else
				n1 += columns;
		}
		return Math.abs(n1 - n2);
	}
}