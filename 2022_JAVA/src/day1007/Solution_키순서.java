package day1007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_키순서 {

	static boolean[][] chk;
	static boolean[] visit;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 학생들의 수 (2 <= N <= 500)
			int M = Integer.parseInt(br.readLine()); // 두 학생의 키를 비교한 횟수 M
			chk = new boolean[N + 1][N + 1];
			for (int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// a < b 임
				chk[a][b] = true;
				//chk[b][a] = true;
			}

			int result = 0;
			for (int i = 1; i <= N; i++) {
				visit = new boolean[N + 1];
				if (find(i)) ++result;
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean find(int index) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int cnt = 0;
		queue.offer(new int[] {index, 0});
		visit[index] = true;

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			cnt++;
			for (int i = 1; i <= N; i++) {
				if(visit[i]) continue;
				if (pos[1] >= 0 && chk[pos[0]][i]) { // 나보다 큰 값
					queue.offer(new int[] {i, 1});
					visit[i] = true;
				}
				if (pos[1] <= 0 && chk[pos[0]][i]) { // 나보다 작은 값
					queue.offer(new int[] {i, -1});
					visit[i] = true;
				}
			}
		}
		return cnt == N;
	}
}
