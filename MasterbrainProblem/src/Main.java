public class Main {
	public static void main(String[] args){
	Masterbrain m=new Masterbrain();
	String[] g={"1575"};
	String[] r={"4b 0w"};
	System.out.println(m.possibleSecrets(g, r));
	String[] a={"1234"};
	String[] b={"0b 4w"};
	System.out.println(m.possibleSecrets(a, b));
	String[] c={"6172","6162","3617"};
	String[] d={"3b 0w","2b 1w","0b 3w"};
	System.out.println(m.possibleSecrets(c, d));
	String[] e={"1513","5654","4564","1377","1671","1342"};
	String[] f={"1b 0w","0b 1w","1b 0w","1b 0w","0b 1w","0b 1w"};
	System.out.println(m.possibleSecrets(e, f));
	String[] h={"2611", "1371", "7417", "2647", "3735", "4272", "2442", "3443", "1252", "3353"};
	String[] i={"0b 2w","0b 2w","0b 1w","0b 2w","1b 0w","1b 0w","1b 0w","0b 1w","1b 1w","0b 1w"};
	System.out.println(m.possibleSecrets(h, i));
	}
}
