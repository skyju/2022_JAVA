package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact_D4_114ms {

	static int ans;
	static int[][] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			int startI = Integer.parseInt(st.nextToken());
			
			graph = new int[101][101];
			
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from][to] = 1;
			}
			search(startI);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void search(int index) {
		// bfs 필요한 자료구조 생성하기
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] visit = new int[101];
		int max = 0;
		
		//시작 값 넣기
		queue.offer(index);
		visit[index] = 1;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i = 1; i < 101; i++) { //현재 now에서 연결된 곳을 다 보고 queue에 넣어야함
				if (graph[now][i] != 1 || visit[i] != 0) continue; // 연결되어있지 않거나 방문했었다면
				visit[i] = visit[now] + 1; // 방문 순서 누적
				queue.offer(i);
			}
			max = visit[now]; // 지금 방문 순서로 max를 변경
		}
		
		for (int i = 1; i < 101; i++) {
			if (max == visit[i]) { //가장 마지막에 방문했떤 노드들이라면
				ans = ans > i ? ans : i;
			}
		}
	}
}
