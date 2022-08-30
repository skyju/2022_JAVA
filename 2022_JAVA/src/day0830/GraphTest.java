package day0829;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class GraphTest {
	
	static class Node {
		int vertex;
		Node next;
		Node (int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static int V; // 정점개수
	static Node[] adjList; // 인접리스트
	static boolean[] visited; // 방문체크 배열 (dfs)
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new Node[V];
		visited = new boolean[V];
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// 무향 그래프
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		sc.close();
		
		System.out.println("==================dfs====================");
		visited = new boolean[V];
		dfs(0);
		
		System.out.println("==================bfs====================");
		bfs();
	}
	
	static void dfs(int cur) {
		visited[cur] = true;
		System.out.println(cur);
		
		for (Node tmp = adjList[cur]; tmp != null; tmp = tmp.next) {
			if (!visited[tmp.vertex]) {
				dfs(tmp.vertex);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visit = new boolean[V];
		
		queue.offer(0);
		visit[0] = true;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.println(cur);
			
			for (Node tmp = adjList[cur]; tmp != null; tmp = tmp.next) {
				if (!visit[tmp.vertex]) {
					queue.offer(tmp.vertex);
					visit[tmp.vertex] = true;
				}
			}
		}
	}
}
