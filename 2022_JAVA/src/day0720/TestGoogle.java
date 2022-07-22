package day0720;

public class TestGoogle {
	public static void main(String[] args) {
		// 1000~8888 사이의 숫자에서 '8'이 몇회 나왔는가?
		// ex)
		// 1008 ... 1
		// 1018 ... 1
		// 1088 ... 2
		// ..
		// 8888 ... 4

		int count = 0;

		for (int i = 1008; i <= 8888; i++) {
			String s = i + "";
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '8')
					count++;
			}
			/*
			int tmp = i;
			while (tmp > 0) { // 자리값
				int num = tmp % 10;
				tmp /= 10;
				if (num == 8)
					count++;
			}
			*/
		}
		System.out.println(count);
	}
}
