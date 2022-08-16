package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquareNumberTest {
	static int callCnt1, callCnt2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		System.out.println(exp1(x, n));
		System.out.println(callCnt1);
		
		System.out.println(exp2(x, n));
		System.out.println(callCnt2);
	}
	
	// x의 n승
	
	// n만큼 call stack이 쌓인다.
	static long exp1(long x, long n) {
		callCnt1++;
		if (n == 1) return x;
		return x * exp1(x, n - 1);
	}

	// 분할 정복
	static long exp2(long x, long n) {
		callCnt2++;
		if (n == 1) return x;
		long y = exp2(x, n / 2);
		return n % 2 == 0 ? y * y : y * y * x;
	}
}
