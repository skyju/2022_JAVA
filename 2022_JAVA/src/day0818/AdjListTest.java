package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjListTest {
	
	static class Node {
		int to;
		Node next;
		//int weight;
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}
	
	static Node[] adjList;
	static int N;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		// 간선정보 입력
		adjList = new Node[N];
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			// 앞에 끼워넣는 코드
			adjList[from] = new Node(to, adjList[from]); 
			adjList[to] = new Node(from, adjList[to]); 
		}
		
		visited = new boolean[N];
		bfs();
		dfs(0);
	}
	
	private static void dfs(int cur) {
		visited[cur] = true; // 방문
		System.out.print((char)(cur + 'A'));
		
		//현재 정점의 인접정점들 큐에 넣어서 차후 탐색하도록 만들기
		for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
			if (!visited[temp.to]) {
				dfs(temp.to);
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
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				// 방문하지 않았으며, 인접한 경우
				if (!visited[temp.to]) {
					visited[temp.to] = true; // 방문예약
					queue.offer(temp.to);
				}
			}
		}
		System.out.println();
	}
}
