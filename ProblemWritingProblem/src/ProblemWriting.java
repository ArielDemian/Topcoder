// SRM 152 DIV 2 - 1000
public class ProblemWriting {
	private static String error = "dotForm is not in dot notation, check character ";

	public String myCheckData(String dotForm) {
		if (dotForm.length() == 0 || dotForm.length() > 25)
			return "dotForm must contain between 1 and 25 characters, inclusive.";
		String s = dotForm;
		int prevLength = dotForm.length(), i;
		char phase;
		while (s.length() > 0) {
			if (s.length() == 1) {
				if (s.charAt(0) >= '0' && s.charAt(0) <= '9')
					return "";
				else
					return error + (dotForm.length() - 1) + ".";
			}
			s = s.replaceFirst("^[0-9]\\.*[+\\-*/]\\.*", "");
			if (s.length() == prevLength) {
				phase = 'n';
				out: for (i = dotForm.length() - s.length(); i < dotForm.length(); i++) {
					switch (phase) {
					case 'n':
						if (dotForm.charAt(i) < '0' || dotForm.charAt(i) > '9')
							return error + i + ".";
						phase = 'd';
						break;
					case 'd':
						if (dotForm.charAt(i) == '+' || dotForm.charAt(i) == '-' || dotForm.charAt(i) == '*' || dotForm.charAt(i) == '/') {
							phase = 'o';
						} else if (dotForm.charAt(i) != '.')
							return error + i + ".";
						break;
					case 'o':
						if (dotForm.charAt(i) >= '0' && dotForm.charAt(i) <= '9')
							break out;
						else if (dotForm.charAt(i) != '.')
							return error + i + ".";
						break;
					}
				}
				return error + i + ".";
			}
			prevLength = s.length();
		}
		return error + (dotForm.length()) + ".";
	}
}