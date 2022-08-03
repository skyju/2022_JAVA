import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_D2_104ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		// 2차원 누적합 문제

		for (int tc = 1; tc <= T; tc++) {
			int ans = Integer.MIN_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()) - 1;

			int[][] sum = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + Integer.parseInt(st.nextToken()) - sum[i - 1][j - 1];
				}
			}
			
			for (int i = 1; i + M <= N; i++) {
				for (int j = 1; j + M <= N; j++) {
					int tmp = sum[i + M][j + M] - sum[i - 1][j + M] - sum[i + M][j - 1] + sum[i - 1][j - 1];
					if (tmp > ans) ans = tmp;
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
