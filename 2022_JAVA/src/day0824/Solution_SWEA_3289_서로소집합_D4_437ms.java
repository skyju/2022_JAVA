import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_D4_437ms {
	
	static int[] rank;
	static int[] root;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken()); // 집합 원소 크기
			int M = Integer.parseInt(st.nextToken()); // 연산 수
			rank = new int[N + 1];
			root = new int[N + 1]; // 0 dummy
			
			// n개의 집합
			for (int i = 1; i <= N; i++) {
				rank[i] = i;
				root[i] = i;
			}
			
			// 연산
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int type = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (type == 1) {
					if (find(a) == find(b)) sb.append(1);
					else sb.append(0);
				} else union(a, b);
			}
			sb.append("\n");
		} // test case for문 끝
		System.out.println(sb.toString());
	} // main method 끝

	// i를 포함하는 집합을 찾는 연산
	public static int find(int i) {
		if (root[i] == i) return i;
		// Path Compression 나의 부모를 전부 대표자로 바꿔줌
		else return root[i] = find(root[i]); 
	}
	
	// 두 대표자 집합을 합침
	public static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if (A != B) {
			//root[A] = B;
			link(A, B);
		}
	}
	
	public static void link(int A, int B) {
		
	}
}