package day0805;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2023_신기한소수_Gold5_000ms {
	
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs("", 0);
		System.out.println(sb.toString());
	}// end of main method.
	
	public static void dfs(String target, int length) {
		if (length == N) {
			sb.append(target).append("\n");
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (isPrime(Integer.parseInt(target + i))) 
				dfs(target + i, length + 1);
		}
	}

	public static boolean isPrime(int m) {
		if (m == 1) return false;
		int end = (int) Math.sqrt(m);
		for (int i = 2; i <= end; i++) {
			if ((m % i) == 0) return false;
		}
		return true;
	}

}// end of Main class.
