import java.math.BigDecimal;
import java.math.RoundingMode;

// SRM 149 DIV 1 - 1000
public class GForce {
	public double avgAccel(int period, int[] accel, int[] time) {
		int i;
		BigDecimal pace = new BigDecimal(262144), m, b, tz1, tz, az1, az;
		BigDecimal y, periodDec = new BigDecimal(period);
		BigDecimal maxAccel = new BigDecimal(0), periodAccel, sliceAccel = new BigDecimal(0);
		BigDecimal[] areas = new BigDecimal[time.length - 1];
		pace = new BigDecimal(period).divide(pace, 32, RoundingMode.HALF_DOWN);
		for (i = 1; i < time.length; i++) {
			sliceAccel = new BigDecimal((time[i] - time[i - 1]) * (accel[i] + accel[i - 1]));
			areas[i - 1] = sliceAccel.divide(new BigDecimal(2), 32, RoundingMode.HALF_DOWN);
		}
		for (y = new BigDecimal(time[0]); y.compareTo(new BigDecimal(time[time.length - 1] - period)) <= 0; y = y.add(pace)) {
			periodAccel = new BigDecimal(0);
			for (int z = 0; z < areas.length; z++) {
				tz = new BigDecimal(time[z]);
				tz1 = new BigDecimal(time[z + 1]);
				if (y.compareTo(tz) <= 0 && y.add(periodDec).compareTo(tz1) >= 0) {
					periodAccel = periodAccel.add(areas[z]);
					continue;
				}
				az = new BigDecimal(accel[z]);
				az1 = new BigDecimal(accel[z + 1]);
				m = new BigDecimal(accel[z + 1] - accel[z]);
				m = m.divide(new BigDecimal(time[z + 1] - time[z]), 32, RoundingMode.HALF_DOWN);
				b = az.subtract(m.multiply(tz));
				if (y.compareTo(tz) >= 0 && y.add(periodDec).compareTo(tz1) <= 0) {
					periodAccel = periodAccel.add(m.multiply(y).add(b).add(m.multiply(y.add(periodDec)).add(b)).divide(new BigDecimal(2), 32, RoundingMode.HALF_DOWN).multiply(periodDec));
					continue;
				}
				if (y.compareTo(tz) >= 0 && y.compareTo(tz1) < 0 && y.add(periodDec).compareTo(tz1) >= 0) {
					periodAccel = periodAccel.add(m.multiply(y).add(b).add(az1).divide(new BigDecimal(2), 32, RoundingMode.HALF_DOWN).multiply(tz1.subtract(y)));
					continue;
				}
				if (y.add(periodDec).compareTo(tz1) <= 0 && y.add(periodDec).compareTo(tz) > 0 && y.compareTo(tz) <= 0) {
					periodAccel = periodAccel.add(m.multiply(y.add(periodDec)).add(b).add(az).divide(new BigDecimal(2), 32, RoundingMode.HALF_DOWN).multiply(y.add(periodDec).subtract(tz)));
					continue;
				}
			}
			periodAccel = periodAccel.divide(periodDec, 32, RoundingMode.HALF_DOWN);
			if (y.compareTo(new BigDecimal(750)) == 0)
				System.out.println(periodAccel);
			if (maxAccel.compareTo(periodAccel) < 0)
				maxAccel = periodAccel;
		}
		return maxAccel.doubleValue();
	}
}
