package day0805;

public class Test_Prime {
	public static void main(String[] args) {

		int num[] = new int[4];
		num[0] = Integer.MAX_VALUE;
		num[1] = Integer.MAX_VALUE;
		num[2] = Integer.MAX_VALUE;
		num[3] = Integer.MAX_VALUE;

		// 1.
		long beforeTime = System.currentTimeMillis();
		for (int t = 0; t < num.length; t++) {
			boolean isPrime = true;
			for (int i = 2; i < num[t]; i++) {
				if (num[t] % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		long afterTime = System.currentTimeMillis();
		System.out.println("1 시간 : " + (afterTime - beforeTime) / 1000);

		// 2.
		beforeTime = System.currentTimeMillis();
		for (int t = 0; t < num.length; t++) {
			boolean isPrime = true;
			int sqrt = (int) Math.sqrt(num[t]);
			for (int i = 2; i < sqrt; i++) {
				if (num[t] % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		afterTime = System.currentTimeMillis();
		System.out.println("2 시간 : " + (afterTime - beforeTime) / 1000);

		// 3.
		beforeTime = System.currentTimeMillis();
		for (int t = 0; t < num.length; t++) {
			boolean isPrime = true;
			if (num[t] != 2) {
				int sqrt = (int) Math.sqrt(num[t]);
				for (int i = 2; i < sqrt; i += 2) {
					if (num[t] % i == 0) {
						isPrime = false;
						break;
					}
				}
			} else
				isPrime = true;
		}
		afterTime = System.currentTimeMillis();
		System.out.println("2 시간 : " + (afterTime - beforeTime) / 1000);

		// 4.
		beforeTime = System.currentTimeMillis();
		for (int t = 0; t < num.length; t++) {
			boolean isPrime = true;
			for (int i = 2; i <= num[t] / i; i++) {
				if (num[t] % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		afterTime = System.currentTimeMillis();
		System.out.println("2 시간 : " + (afterTime - beforeTime) / 1000);
	}
}
