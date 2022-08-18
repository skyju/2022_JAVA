package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrixTest {
	static int[][] adjMatrix;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		// 간선정보 입력
		adjMatrix = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = adjMatrix[from][to] = 1; // 무향 그래프
		}
		
		bfs();
		dfs(0);
	}
	
	static boolean[] visited;
	private static void dfs(int cur) {
		visited[cur] = true; // 방문
		System.out.print((char)(cur + 'A'));
		
		//현재 정점의 인접정점들 큐에 넣어서 차후 탐색하도록 만들기
		for (int i = 0; i < N; i++) {
			// 방문하지 않았으며, 인접한 경우
			if (!visited[i] && adjMatrix[cur][i] != 0) {
				dfs(i);
			}
		}
	}
	
	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N]; //방문관리 배열
		
		visited[0] = true;
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print((char)(cur + 'A'));
			
			//현재 정점의 인접정점들 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 0; i < N; i++) {
				// 방문하지 않았으며, 인접한 경우
				if (!visited[i] && adjMatrix[cur][i] != 0) {
					visited[i] = true; // 방문예약
					queue.offer(i);
				}
			}
		}
		System.out.println();
	}
}
