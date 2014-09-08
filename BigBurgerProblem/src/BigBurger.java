public class BigBurger {
	public int maxWait(int[] arrival, int[] service) {
		if (arrival.length != service.length)
			return -1;
		int maxWait = 0;
		int i, tServed = 0;
		for (i = 0; i < arrival.length; i++) {
			if (arrival[i] < 0 || service[i] < 0)
				return -1;
			if (i > 0 && arrival[i] < arrival[i - 1])
				return -1;
			if (i == 0) {
				tServed = arrival[0];
			} else {
				tServed = (tServed + service[i - 1] > arrival[i] ? tServed + service[i - 1] : arrival[i]);
				if (tServed - arrival[i] > maxWait)
					maxWait = tServed - arrival[i];
			}
		}
		return maxWait;
	}
}
