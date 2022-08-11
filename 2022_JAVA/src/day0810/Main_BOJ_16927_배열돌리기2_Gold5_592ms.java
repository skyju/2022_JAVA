package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16927_배열돌리기2_Gold5_592ms {

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

		// rotate : 회전횟수 최적화
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
		int n = N, m = M;
		
		for (int i = 0; i < num; i++) {
			int can = (2*n) + (2*m) - 4; // 한번 회전할 때 회전시킬 총 칸수 (양변이 대칭이니까 2씩 곱하고, 꼭지점 4개를 빼줌)
			int size = R % can;
			// 4x4일 때 제일 겉의 box는 num 12, 회전횟수는 4라고 했을 때.. size = 4 (4번 다 돌려야 유의미)
			// 그 다음 box의 num 4, 회전횟수는 4 니까 size = 0 (안돌려도 된다)
			
			for (int j = 0; j < size; j++) {
				int r = i, c = i;
				String tmp = map[r][c]; // 시작값 저장 (0,0), (1,1)...
				for (int d = 0; d < dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					while (nr >= i && nc >= i && nr < N - i && nc < M - i) {
						map[r][c] = map[nr][nc];
						r = nr;
						c = nc;
						nr += dr[d];
						nc += dc[d];
					}
				}
				map[i + 1][i] = tmp;
			}
			
			n -= 2;
			m -= 2;
		}
	}
}
