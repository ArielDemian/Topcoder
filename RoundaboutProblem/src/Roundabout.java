public class Roundabout {
	public int clearUpTime(String north, String east, String south, String west) {
		if (north == null || east == null || south == null || west == null)
			return 0;
		String[] dir = new String[4], predir = new String[4];
		dir[0] = "-" + south;
		dir[1] = "-" + east;
		dir[2] = "-" + north;
		dir[3] = "-" + west;
		predir[0] = "-" + south;
		predir[1] = "-" + east;
		predir[2] = "-" + north;
		predir[3] = "-" + west;
		int steps = 0;
		boolean block;
		while (!dir[0].matches("^-*$") || !dir[1].matches("^-*$") || !dir[2].matches("^-*$") || !dir[3].matches("^-*$")) {
			for (int i = 0; i < dir.length; i++) {
				if (predir[i].charAt(0) == 'S' && i == 0) {
					dir[i] = "-" + predir[i].substring(1);
					//predir[i] = "" + dir[i];
				}
				if (predir[i].charAt(0) == 'E' && i == 1) {
					dir[i] = "-" + predir[i].substring(1);
					//predir[i] = "" + dir[i];
				}
				if (predir[i].charAt(0) == 'N' && i == 2) {
					dir[i] = "-" + predir[i].substring(1);
					//predir[i] = "" + dir[i];
				}
				if (predir[i].charAt(0) == 'W' && i == 3) {
					dir[i] = "-" + predir[i].substring(1);
					//predir[i] = "" + dir[i];
				}
			}
			turn(dir);
			for (int i = 0; i < dir.length; i++) {
				if (predir[i].length() > 1) {
					if (predir[i].charAt(1) == '-') {
						dir[i] = forward(dir[i]);
					} else if (predir[prev(i)].charAt(0) == '-' && (predir[prev(i)].length() == 1 || predir[prev(i)].charAt(1) == '-')) {
						dir[i] = predir[i].substring(1);
					} else
						dir[i] = forward(dir[i]);
				}
			}
			block = true;
			for (int i = 0; i < dir.length && block; i++) {
				if (predir[i].length() == 1 || predir[i].charAt(1) == '-') {
					block = false;
				}
			}
			if (block) {
				if (predir[1].charAt(0) == '-') {
					dir[2] = predir[2].substring(1);
				}
			}
			for (int i = 0; i < dir.length; i++)
				predir[i] = "" + dir[i];
			steps++;
		}
		return steps;
	}

	private static int prev(int pos) {
		if (pos == 0)
			return 3;
		else
			return pos - 1;
	}

	private static String forward(String s) {
		for (int i = 2; i < s.length(); i++) {
			if (s.charAt(i) != '-' && s.charAt(i - 1) == '-') {
				s = s.substring(0, i - 1) + s.substring(i);
				return s;
			}
		}
		return s;
	}

	private static void turn(String[] dir) {
		char a, b = dir[0].charAt(0);
		for (int i = 0; i < dir.length; i++) {
			a = dir[(i + 1) % dir.length].charAt(0);
			dir[(i + 1) % dir.length] = b + dir[(i + 1) % dir.length].substring(1);
			b = a;
		}
	}
}