package day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1258_작업순서_D6_dfs {
	
	static int V, E;
	static boolean[][] matrix;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			visit = new boolean[V + 1];
			matrix = new boolean[V + 1][V + 1];
			
			// 간선
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = true;
			}
			
			sb.append("#").append(tc).append(" ");
			// 위상 정렬
			for (int i = 1; i <= V; i++) {
				if (visit[i]) continue;
				dfs(i);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int v) {
		visit[v] = true;
		for(int i = 1; i <= V; i++) {
			if (!visit[i] && matrix[i][v]) { //부모에서 나에게 오는 정점들 검사
				dfs(i);
			}
		}
		sb.append(v).append(" ");
	}
}
