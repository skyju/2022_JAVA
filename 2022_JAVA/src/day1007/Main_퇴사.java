package day1007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_퇴사 {

	// N일 동안 최대한 많은 상담 비용을 얻을 것
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // N일
		int[] Ti = new int[N + 1];
		int[] Pi = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Ti[i] = Integer.parseInt(st.nextToken()); // 걸리는 시간
			Pi[i] = Integer.parseInt(st.nextToken()); // 받을 수 있는 비용
		}

		int[] dp = new int[N + 1];
		int result = 0;
		for (int i = 0; i < N + 1; i++) { // 모든 날에 대하여 dp 진행
			for (int j = 0; j < i; j++) { // 이전까지의 날들과 비교하며 살펴보면서
				dp[i] = Math.max(dp[i], dp[j]); // 더 큰 값으로 갱신
				if (j + Ti[j] == i) // 지금 날짜가 이전 날짜 + 걸리는 시간 해서 종료일이면
					dp[i] = Math.max(dp[i], dp[j] + Pi[j]); // 더 큰값으로 갱신!
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
