import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14503_로봇청소기_Gold5_000ms {

	static int N, M, clean;
	static char[][] map;
	static int[] dr = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}
		go(r, c, d);
		System.out.println(clean);
	}
	
	public static void go(int r, int c, int d) {
		// 1. 현재 위치를 청소한다.
		if (map[r][c] == '0') {
			map[r][c] = '2';
			clean++;
		}
		
		// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
		// 왼쪽방향으로 회전
		boolean flag = false;
		int nd, nr, nc;
		int originD = d;
		for (int i = 0; i < 4; i++) { // 4방으로 탐색한다.
			nd = (d + 3) % 4;
			nr = r + dr[nd];
			nc = c + dc[nd];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M) { // 맵 범위 안
				if (map[nr][nc] == '0') {
					go(nr, nc, nd);
					flag = true;
					break;
				}
			}
			d = nd;
		}
		// 네 방향 모두 청소가 되어있거나 벽인 경우
		if (!flag) {
			nd = (originD + 2) % 4;
			nr = r + dr[nd];
			nc = c + dc[nd];
			if (nr >= N || map[nr][nc] == '1') return;
			go(nr, nc, originD);
		}
	}
}
