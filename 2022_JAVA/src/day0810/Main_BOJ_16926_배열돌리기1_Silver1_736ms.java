package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16926_배열돌리기1_Silver1_736ms {

	static int N, M, R; // 배열크기 NM, 회전 수 R
	static String[][] map;
	// 좌, 상, 우, 하 방향으로 뒤집어 씌워야하니까 next값은 반대가 되어야함!
	static int[] dr = { 0, 1, 0, -1 }; // 우, 하, 좌, 상 (반시계 방향)
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
				map[i][j] = st.nextToken();
		}
		
		// rotate
		rotate();
		
		// output
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]);
				if (j != M - 1) sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	} // end of main
	
	public static void rotate() {
		int num = Math.min(N, M) / 2; // 한번 회전할 때 돌아야하는 그룹값
		
		for (int i = 0; i < R; i++) { // 회전 횟수
			for (int j = 0; j < num; j++) {
				int r = j, c = j;
				String tmp = map[r][c]; // 시작값 저장 (0,0), (1,1)...
				for (int d = 0; d < dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					while (nr >= j && nc >= j && nr < N - j && nc < M - j) {
						map[r][c] = map[nr][nc];
						r = nr;
						c = nc;
						nr += dr[d];
						nc += dc[d];
					}
				}
				map[j + 1][j] = tmp;
			}
		}
	}
}
