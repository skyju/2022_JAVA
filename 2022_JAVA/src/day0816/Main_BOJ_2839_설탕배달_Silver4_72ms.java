package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2839_설탕배달_Silver4_72ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		while (true) {
			if (N % 5 == 0) {
				ans += N / 5;
				System.out.println(ans);
				break;
			} else {
				N -= 3;
				ans++;
				if (N < 0) {
					System.out.println(-1);
					break;
				}
			}
		}
	}
}