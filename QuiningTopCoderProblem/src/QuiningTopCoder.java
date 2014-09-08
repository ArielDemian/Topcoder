import java.util.Stack;

// SRM 152 DIV 1 - 500
public class QuiningTopCoder {
	private static final int min = -1000000000, max = 1000000000;

	public String testCode(String source) {
		int ip = 0, d = 1, n = source.length(), a, b, cycle = 0;
		boolean f = false, j = false;
		Stack<Integer> s = new Stack<Integer>();
		String print = "";
		loop: while (true) {
			switch (source.charAt(ip)) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				s.push(Integer.parseInt("" + source.charAt(ip)));
				break;
			case '$':
				if (!s.isEmpty())
					s.pop();
				break;
			case ':':
				a = (s.isEmpty() ? 0 : s.pop());
				if (a < min || a > max)
					return "OVERFLOW " + cycle;
				s.push(a);
				s.push(a);
				break;
			case 'W':
				a = (s.isEmpty() ? 0 : s.pop());
				b = (s.isEmpty() ? 0 : s.pop());
				if (a < min || a > max)
					return "OVERFLOW " + cycle;
				s.push(a);
				if (b < min || b > max)
					return "OVERFLOW " + cycle;
				s.push(b);
				break;
			case ',':
				a = (s.isEmpty() ? 0 : s.pop());
				print += source.charAt(Math.abs(a) % n);
				if (!source.startsWith(print))
					return "MISMATCH " + cycle;
				if (source.equals(print))
					return "QUINES " + cycle;
				break;
			case '+':
				a = (s.isEmpty() ? 0 : s.pop());
				b = (s.isEmpty() ? 0 : s.pop());
				a += b;
				if (a < min || a > max)
					return "OVERFLOW " + cycle;
				s.push(a);
				break;
			case '-':
				a = (s.isEmpty() ? 0 : s.pop());
				b = (s.isEmpty() ? 0 : s.pop());
				a -= b;
				if (a < min || a > max)
					return "OVERFLOW " + cycle;
				s.push(a);
				break;
			case '#':
				d *= 2;
				f = true;
				break;
			case 'R':
				d *= -1;
				break;
			case 'S':
				a = (s.isEmpty() ? 0 : s.pop());
				if (a > 0)
					s.push(1);
				else
					s.push(-1);
				break;
			case '_':
				a = (s.isEmpty() ? 0 : s.pop());
				d = a % n;
				break;
			case 'J':
				ip = Math.abs(s.isEmpty() ? 0 : s.pop()) % n;
				j = true;
				break;
			case '@':
				return "BADEND " + cycle;
			default:
				break loop;
			}
			if (j)
				j = false;
			else
				ip = (3 * n + ip + d) % n;
			if (f) {
				f = false;
				d /= 2;
			}
			cycle++;
			if (cycle > 80000)
				return "TIMEOUT";
		}
		return "";
	}
}
