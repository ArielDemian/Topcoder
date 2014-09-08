import java.math.BigDecimal;

public class ExerciseMachine {
	public int getPercentages(String time) {
		if (time == null || time.length() != 8)
			return -1;
		BigDecimal perc, sum = new BigDecimal(0), s;
		String[] t = time.split(":");
		s = new BigDecimal(Integer.parseInt(t[0]) * 60 * 60 + Integer.parseInt(t[1]) * 60 + Integer.parseInt(t[2]));
		perc = s.divide(new BigDecimal(100));
		while (sum.compareTo(s) < 0) {
			sum = sum.add(perc);
			if (sum.compareTo(new BigDecimal(sum.intValue())) == 0) {
				break;
			}
		}
		if (sum.compareTo(s) >= 0) {
			return 0;
		} else {
			return s.divide(sum).compareTo(new BigDecimal(s.divide(sum).intValue())) == 0 ? s.divide(sum).intValue() - 1 : s.divide(sum).intValue();
		}
	}
}