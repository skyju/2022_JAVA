package day0823;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_11315_오목판정_D3_111ms {

	static int N;
	static char[][] map;
	static int[] dr = { 0, 1, 1, 1 }; // 우, 하, 좌하, 우하
	static int[] dc = { 1, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
				}
			}

			boolean flag = false;
			int nr, nc;
			x: for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 'o') {
						for (int d = 0; d < 4; d++) {
							int cnt = 1;
							for (nr = r + dr[d], nc = c + dc[d];
								(nr >= 0 && nc >= 0 && nr < N && nc < N) && map[nr][nc] == 'o';
								nr += dr[d], nc += dc[d]) cnt += 1;
							if (cnt >= 5) {
								flag = true;
								break x;
							}
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			if (flag) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
			
		} // test case for문 종료
		System.out.println(sb.toString());
	} // main method 종료
} // class 종료
