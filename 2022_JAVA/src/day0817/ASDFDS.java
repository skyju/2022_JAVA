package day0817;

public class ASDFDS {
	public static void main(String[] args) {
		System.out.println(Math.pow(5, 2));
		int mul = 1;
		for (int i = 0; i < 2; i++)
			mul *= 5;
		System.out.println(mul);
		System.out.println(5 * 5);
		System.out.println(myPow(5, 2));
	}

	public static int myPow(int N, int ex) {
		int mul = 1;
		for (int i = 0; i < ex; i++) {
			mul *= N;
		}
		return (int) mul;
	}
}
