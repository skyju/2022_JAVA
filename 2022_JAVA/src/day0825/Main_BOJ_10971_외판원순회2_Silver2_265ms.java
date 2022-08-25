package day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10971_외판원순회2_Silver2_265ms {
	
	// MST 문제 

	static int N, min;
	static int[][] map;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 도시의 수
		min = Integer.MAX_VALUE;
		
		// 유향 그래프, 입력받기
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 도시의 방문여부 체크
		for (int i = 0; i < N; i++) {
			visit = new boolean[N];
			visit[i] = true; // 시작 도시 방문 체크
			dfs(i, i, 0, 1);
		}
		System.out.println(min);
	}
	
	public static void dfs(int start, int now, int w, int depth) {
		if (depth == N) {
			// 마지막에서 처음으로
			if (map[now][start] != 0) {
				w += map[now][start];
				min = Math.min(min, w);
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visit[i] && map[now][i] != 0) {
				visit[i] = true;
				dfs(start, i, w + map[now][i], depth + 1);
				visit[i] = false;
			}
		}
		
	}
	
	
}
