import java.util.LinkedList;
import java.util.List;

public class RunnableMessageMess implements Runnable {
	private static final String impossible = "IMPOSSIBLE!";
	private static final String ambiguous = "AMBIGUOUS!";
	private String[] dictionary;
	private String message;
	private boolean reverse, ready, stop;
	private String result;
	private static RunnableMessageMess m1, m2;
	private Semaphore s;

	public String restore(String[] dictionary, String message) {
		s = new Semaphore(0);
		m1 = new RunnableMessageMess();
		m1.stop = false;
		m1.s = this.s;
		m1.ready = false;
		m1.result = "";
		m1.reverse = false;
		m1.dictionary = dictionary;
		m1.message = message;
		m2 = new RunnableMessageMess();
		m2.stop = false;
		m2.s = this.s;
		m2.ready = false;
		m2.result = "";
		String[] reverseDictionary = new String[dictionary.length];
		for (int i = 0; i < dictionary.length; i++)
			reverseDictionary[i] = reverse(dictionary[i]);
		m2.dictionary = reverseDictionary;
		m2.message = reverse(message);
		m2.reverse = true;
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		t1.start();
		t2.start();
		s.P();
		m1.stop = true;
		m2.stop = true;
		if (m1.ready){
			return m1.result;
		}
		if (m2.ready){
			return m2.result;
		}
		return "";
	}

	public void run() {
		if (message.equals("") || dictionary.length == 0) {
			result = (reverse ? reverse(message) : message);
			ready = true;
			s.V();
			return;
		}
		if (!message.matches("^[A-Z]+$")) {
			ready = true;
			s.V();
			return;
		}
		boolean found;
		int i = 0, j, nRes = 0;
		WordNode WT = new WordNode(null, -1);
		WordNode wn = WT, w = null;
		out: while (!stop) {
			found = false;
			loop: for (j = 0; j < dictionary.length; j++) {
				if (message.substring(i).matches("^" + dictionary[j] + "[A-Z]*")) {
					for (WordNode n : wn.sons) {
						if (n.index == j)
							continue loop;
					}
					found = true;
					wn = new WordNode(wn, j);
					wn.father.sons.add(wn);
					i += dictionary[j].length();
					if (i == message.length()) {
						nRes++;
						if (nRes > 1) {
							result = ambiguous;
							ready = true;
							s.V();
							return;
						}
						w = wn;
						while (w != null) {
							w.flag = '-';
							w = w.father;
						}
						wn = wn.father;
						i -= dictionary[j].length();
					}
					continue out;
				}
			}
			if (!found) {
				if (wn == WT)
					break out;
				else {
					i -= dictionary[wn.index].length();
					wn = wn.father;
				}
			}
		}
		wn = WT;
		out: while (!stop) {
			found = false;
			for (WordNode n : wn.sons) {
				if (n.flag == '-') {
					if (found) {
						result = ambiguous;
						ready = true;
						s.V();
						return;
					}
					found = true;
					w = n;
				}
			}
			if (!found) {
				if (wn == WT) {
					result = impossible;
					ready = true;
					s.V();
					return;
				} else
					break out;
			} else {
				result += dictionary[w.index] + " ";
				wn = w;
			}
		}
		if (stop)
			return;
		result = (reverse ? reverse(result.trim()) : result.trim());
		ready = true;
		s.V();
		return;
	}

	private static String reverse(String str) {
		if ((null == str) || (str.length() <= 1)) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}
}

class WordNode {
	public WordNode father;
	public List<WordNode> sons;
	public int index;
	public char flag;

	public WordNode(WordNode father, int index) {
		this.father = father;
		this.index = index;
		flag = 'X';
		this.sons = new LinkedList<WordNode>();
	}
}

class Semaphore {
	private int value;

	public Semaphore() {
		this.value = 0;
	}

	public Semaphore(int value) {
		this.value = value;
	}

	public synchronized void P() {
		while (value <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		value--;
	}

	public synchronized void V() {
		value++;
		notify();
	}
}