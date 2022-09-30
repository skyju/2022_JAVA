package day0930;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1463_1로만들기_Silver3_곽민주_104ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 < N < 10^6
		int[] dp = new int[N + 1];

		dp[0] = dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
		}
		System.out.println(dp[N]);
	}

}
