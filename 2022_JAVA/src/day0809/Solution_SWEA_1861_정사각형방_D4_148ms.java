package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_148ms {
	
	static int N;
	static int ans;
	static int loc;
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[] number; // 1 ~ N*N, 각 number가 갈 수 있는 최대값 담음

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			// initialize
			N = Integer.parseInt(br.readLine());
			ans = 1;
			loc = Integer.MAX_VALUE;
			map = new int[N][N];
			number = new int[N * N + 1];

			// input
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			// searching
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					recursive(i, j);
				}
			}
			
			// value renewal
			// 작은 수 부터 checking하므로, > 비교를 하면 같은 값에 있어서 고민할 필요 없다.
			for (int i = 1; i < number.length; i++) {
				if (number[i] > ans) {
					ans = number[i];
					loc = i;
				}
			}
			sb.append("#").append(tc).append(" ").append(loc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// map[i][j]를 탐색해서 얻을 수 있는 max value를 return하는 재귀함수
	public static int recursive(int i, int j) {
		if (number[map[i][j]] != 0) return number[map[i][j]];
		int cnt = 1;
		for (int d = 0; d < dr.length; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == map[i][j] + 1) {
				cnt += recursive(nr, nc);
				break;
			}
		}
		number[map[i][j]] = cnt;
		return cnt;
	}
} // end of class
