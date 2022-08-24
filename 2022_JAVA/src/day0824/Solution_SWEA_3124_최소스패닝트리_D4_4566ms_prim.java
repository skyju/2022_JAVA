import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// prim : 정점 중심으로 새로운 정점을 찾아간다. (갈 수 있는 정점 중 비용이 가장 싼)
public class Solution_SWEA_3124_최소스패닝트리_D4_4566ms_prim  {
	
	static int V, E; // 정점 개수, 간선 개수
	static long ans;
	
	static ArrayList<ArrayList<Edge>> vertex; //그래프의 자료구조 - 인접행렬[][]
	static boolean[] visit;
	
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			// 자료구조 만들기
			vertex = new ArrayList<ArrayList<Edge>>();
			for (int i = 0; i <= V; i++) { // 0 dummy
				vertex.add(new ArrayList<Edge>());
			}
			visit = new boolean[V + 1]; // 0 dummy
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int v1 = Integer.parseInt(st.nextToken()); // 첫번째 vertex
				int v2 = Integer.parseInt(st.nextToken()); // 연결되는 vertex
				int c = Integer.parseInt(st.nextToken()); // 비용
				// v1 -c-> v2 & v2 -c-> v1 두 군데
				vertex.get(v1).add(new Edge(v2, c));
				vertex.get(v2).add(new Edge(v1, c));
			}
			
			ans = 0;
			pqueue.clear();
			prim();
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void prim() {
		int count = 1; // 첫번째 정점 선택이 정점 1개를 선택한 것임.
		visit[1] = true; // 맨 앞 정점부터 시작
		// 1번 정점에서 갈 수 있는 다른 정점, 간선을 전부 다 pq에 담고 시작
		pqueue.addAll(vertex.get(1));
		
		while (!pqueue.isEmpty()) {
			Edge edge = pqueue.poll();
			if (visit[edge.v]) continue;
			
			// edge.v가 바로 현재 가장 비용이 싼, 갈 수 있는 정점
			visit[edge.v] = true;
			ans += edge.c; //누적
			
			count++;
			if (count == V) break;
			// 새로운 정점 v로 부터 갈 수 있는 다른 노드를 다시 큐에 담는다.
			pqueue.addAll(vertex.get(edge.v));
		}
	}
	
	static class Edge {
		int v, c; // 정점 v로 가는 비용 c
		public Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
}