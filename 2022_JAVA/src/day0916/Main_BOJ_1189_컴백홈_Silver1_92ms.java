package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1189_컴백홈_Silver1_92ms {
	
	static int R, C, K;
	static char[][] map;
	static int ans;
	
	//4방 탐색
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 0;
		
		// R X C 맵
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			map[r] = line.toCharArray();
		}
		visit[R - 1][0] = true;
		dfs(1, R - 1, 0); // 왼쪽 아래부터 출발
		System.out.println(ans);
	}
	
	public static void dfs(int cnt, int r, int c) {
		if (cnt == K) {
			if (r == 0 && c == C - 1) { // 오른쪽 위 도착
				ans++;
				return;
			}
		}
		
		for (int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			// 한번 지나친 곳은 다시 방문하지 않는다. T로 표시된 부분은 가지 못한다.
			if (visit[nr][nc] || map[nr][nc] == 'T') continue;
			visit[nr][nc] = true;
			dfs(cnt + 1, nr, nc);
			visit[nr][nc] = false;
		}
		
	}
}
