package day0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_7465_창용마을무리의개수_D4_000ms {

	static ArrayList<ArrayList<Integer>> list; // 인접 리스트
	static int N, M, cnt;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken()); // 사람의 수
			M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
			cnt = 0;
			
			// 인접리스트 생성 및 초기화
			list = new ArrayList<>();
			for (int i = 0; i < N + 1; i++)
				list.add(new ArrayList<Integer>());

			// 친구 관계 input
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);
				list.get(b).add(a);
				// 무향이므로 서로 친구관계를 넣어줘야 함
			}

			for (int now = 0; now < N + 1; now++) {
				visit = new boolean[N + 1]; // 현재 now의 친구관계를 체크할 배열을 초기화
				dfs(now, 0);
			}

			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		} // test case for문 끝
		System.out.println(sb.toString());
	} // main method 끝

	public static void subset(int now, int cnt) {
		if (cnt == N) {
			++cnt;
		}

		visit[now] = true;
		for (int friend : list.get(now)) { // now의 친구 리스트를 가져와요.
			int next = friend;
			if (!visit[next]) {
				subset(next, cnt + 1);
			} else {
				subset(next, cnt + 1);
			}
		}
		visit[now] = false;
	}
}
