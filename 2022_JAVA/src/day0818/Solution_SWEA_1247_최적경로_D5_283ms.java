package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1247_최적경로_D5_283ms {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, ans;
	static Node start, end;
	static Node[] customers;
	static Node[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()); // 전체 배열 크기
			customers = new Node[N];
			result = new Node[N];

			st = new StringTokenizer(br.readLine(), " ");
			start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < N; i++)
				customers[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			perm(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void perm(int flag, int cnt, int distance) {
		if (distance > ans) return;
		if (cnt == N) {
			int realDis = distance + calDistance(result[cnt - 1], end);
			if (realDis < ans) ans = realDis;
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) continue;
			result[cnt] = customers[i];
			if (cnt == 0) perm(flag | 1 << i, cnt + 1, calDistance(start, result[cnt]));
			else perm(flag | 1 << i, cnt + 1, distance + calDistance(result[cnt - 1], result[cnt]));
		}
	}
	
	public static int calDistance(Node one, Node two) {
		return (Math.abs(one.x - two.x) + Math.abs(one.y - two.y));
	}
}
