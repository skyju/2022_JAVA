package day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1753_최단경로_Gold4_00ms {

	static class Edge {
		int vertex, weight;

		Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	static ArrayList<ArrayList<Edge>> vertex = new ArrayList<>();
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((o1, o2)->o1.weight - o2.weight);
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

		// 인접리스트 초기화
		for (int i = 0; i <= V; i++)
			vertex.add(new ArrayList<Edge>());
		
		// 최단거리 저장 배열 초기화
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// 간선 정보 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			vertex.get(v1).add(new Edge(v2, c));
		}

		// 다익스트라 진행
		dijkstra(K);
		
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if (dist[i] < Integer.MAX_VALUE) sb.append(dist[i]);
			else sb.append("INF");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dijkstra(int K) {

		dist[K] = 0; // 출발지 비용 0
		pqueue.add(new Edge(K, 0));

		while (!pqueue.isEmpty()) {
			Edge now = pqueue.poll();
			if (now.weight > dist[now.vertex]) continue; // 이미 구해놓은 값보다 형편없으면 여기로는 가지 말아야하므로 패스
			
			int len = vertex.get(now.vertex).size();
			//인접리스트 전부 돌면서 확인
			for (int i = 0; i < len; i++) { 
				Edge next = vertex.get(now.vertex).get(i); // now를 통해 갈 수 있는 next
				if (dist[next.vertex] > now.weight + next.weight) { // 이미 구해놓은 값보다 유리한 값이 있으면
					dist[next.vertex] = now.weight + next.weight; // 변경하고 큐에 넣는다.
					pqueue.add(new Edge(next.vertex, dist[next.vertex]));
				}
			}
		}
	}
}

/*
 * 
5 5
1
1 2 3
2 3 2
2 5 3
3 4 3
2 4 10
*/