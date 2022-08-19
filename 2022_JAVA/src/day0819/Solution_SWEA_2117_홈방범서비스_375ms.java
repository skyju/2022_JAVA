import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2117_홈방범서비스_375ms {
	
	/**
	 * 한원석님 코드
	 * list -> x배열, y배열 따로 두는게 좋음
	 */

	static int N, M, ans;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			// input
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][N];
			int homecnt = 0;
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < line.length(); j += 2) {
						char c = line.charAt(j);
						map[i][j] = c;
						if (c == '1') homecnt++;
				}
			}

			// logic
			ans = 0;
			x: for (int k = 1; k < N + 2; k++) {
				int runPrice = k * k + (k - 1) * (k - 1);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						priceCalculator(i, j, k, runPrice);
						if (ans == homecnt) break x;
						if (ans == runPrice) continue x;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		} // end of test case
		System.out.println(sb.toString());
	} // end of main

	public static void priceCalculator(int r, int c, int K, int runPrice) {
		int cnt = 0;

		for (int d = 0; d < K; d++) {
			for (int row = -d; row <= d; row++) {
				int nr = r + row;

				int c1 = d - Math.abs(row);
				int c2 = -c1;

				if (nr >= 0 && nr < N) {
					int nc1 = c + c1;
					int nc2 = c + c2;
					if (nc1 >= 0 && nc1 < N && map[nr][nc1] == '1') cnt++;
					if (nc1 != nc2 && nc2 >= 0 && nc2 < N && map[nr][nc2] == '1') cnt++;
				}
			}
		}
		int profit = (cnt * M) - runPrice;
		if (profit >= 0 && ans < cnt) ans = cnt;
	}
}
