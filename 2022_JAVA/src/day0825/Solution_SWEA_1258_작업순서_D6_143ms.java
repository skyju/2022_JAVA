package day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1258_작업순서_D6_143ms {
	
	static int V, E;
	static int[] indegree; // 정점별 진입차수(선행 정점 수)
	static boolean[][] matrix;
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			indegree = new int[V + 1];
			matrix = new boolean[V + 1][V + 1];
			
			// 간선
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = true;
				indegree[to]++;
			}
			
			sb.append("#").append(tc).append(" ");
			// 위상 정렬
			// 진입차수가 0인 항목을 queue에 담고 시작
			for (int i = 1; i <= V; i++)
				if (indegree[i] == 0) queue.offer(i);
			
			while(!queue.isEmpty()) {
				int v = queue.poll();
				sb.append(v + " ");
				// v정점으로부터 갈 수 있는 다른 정점을 따진다.
				for (int i = 1; i <= V; i++) {
					if (matrix[v][i]) {
						indegree[i]--;
						if (indegree[i] == 0) queue.offer(i);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
