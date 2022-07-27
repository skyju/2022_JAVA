package classJAVA;

public class TestCard {
	public static void main(String[] args) {
		Card c1 = new Card("하트", 7, 10, 20);
		Card c2 = new Card("다이아", 1, 40, 80);

		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}
}
