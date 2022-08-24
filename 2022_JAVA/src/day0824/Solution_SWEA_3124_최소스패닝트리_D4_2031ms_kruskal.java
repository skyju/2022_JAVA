import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3124_최소스패닝트리_D4_2031ms_kruskal  {
	
	// p배열과 make, fine, union만들어놓고
	// 간선 정보 입력받고, 가중치 기준으로 오름차순 정렬함
	// 간선 정보를 하나씩 빼면서 유니온된다면 웨이트를 누적함
	// 정점개수 - 1 만큼 엣지를 돌았다면 종료
	
	static int V, E; // 정점 개수, 간선 개수
	static int[] parents;
	static Edge[] edgeList;
	
	// 크기가 1인 서로 소 집합 생성
	// 모든 노드가 자신을 부모(대표자)로 하는 집합
	static void make() {
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	// x의 대표자 찾기
	static int find(int x) {
		if (parents[x] == x) return x;
		else return parents[x] = find(parents[x]);
	}
	
	// true: union 성공
	static boolean union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if (A == B) return false;
		parents[B] = A;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E]; // 간선 크기만큼
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),
									   Integer.parseInt(st.nextToken()),
									   Integer.parseInt(st.nextToken()));
			}
			
			make();
			// 가중치기준으로 오름차순 정렬
			Arrays.sort(edgeList);
			
			int result = 0;
			int count = 0;
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					result += edge.weight;
					if (++count == V - 1) break;
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}