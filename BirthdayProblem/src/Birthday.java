import java.util.Arrays;

public class Birthday {
	public String getNext(String date, String[] birthdays) {
		Arrays.sort(birthdays);
		for (int i = 0; i < birthdays.length; i++)
			if (date.compareTo(birthdays[i]) < 0)
				return birthdays[i].substring(0, 5);
		return birthdays[0].substring(0, 5);
	}
}