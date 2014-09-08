public class CircleGame {
	public int cardsLeft(String deck) {
		boolean change = true;
		int i;
		while (change) {
			change = false;
			for (i = 0; i < deck.length(); i++) {
				if (deck.charAt(i) == 'K') {
					deck = deck.substring(0, i) + deck.substring(i + 1);
					change = true;
				} else if (points(deck.charAt(i)) + points(deck.charAt((i + 1) % deck.length())) == 13) {
					if (i + 1 == deck.length()) {
						deck = deck.substring(1, i);
						change = true;
					} else {
						deck = deck.substring(0, i) + deck.substring(i + 2, deck.length());
						change = true;
					}
				}
			}
		}
		return deck.length();
	}

	private static int points(char c) {
		if (c >= '1' && c <= '9')
			return Integer.parseInt("" + c);
		switch (c) {
		case 'A':
			return 1;
		case 'T':
			return 10;
		case 'J':
			return 11;
		case 'Q':
			return 12;
		default:
			return Integer.MIN_VALUE;
		}
	}
}