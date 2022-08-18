package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1247_최적경로_D5_보충수업_prun_dfs {
	
	/**
	 * min값을 구하는 문제
	 * 현재 과정에서 앞으로 계속 가 봤자 min 값보다 큰 값이 나온다면 갈 필요가 없겠죠.
	 * sum을 달고 다녀야합니다.
	 * 279ms
	 */


	static int N, comX, comY, homeX, homeY, min;
	static int[][] cust; // 고객의 정보 (src)
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()); // 전체 배열 크기
			cust = new int[N][2]; // 0 : x, 1 : y
			visit = new boolean[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			comX = Integer.parseInt(st.nextToken());
			comY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			
			// N개의 고객
			for (int i = 0; i < N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// dfs
			// 첫번째 고객부터 마지막 고객까지 가장 먼저 출발 해보기
			for (int i = 0; i < N; i++) {
				// visit 초기화
				Arrays.fill(visit, false);
				visit[i] = true;
				// 0 채워놨으니, depth는 1부터 출발
				dfs(i, 1, distance(comX, comY, cust[i][0], cust[i][1]));
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	// custIdx : 고객, depth : 재귀깊이, sum : 누적거리
	public static void dfs(int custIdx, int depth, int sum) {
		// 기저조건 
		if (depth == N) {
			// 마지막 고객 -> 집 / custIdx : 마지막 고객
			sum += distance(homeX, homeY, cust[custIdx][0], cust[custIdx][1]);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visit[i]) continue;
			// 가지치기
			int dis = distance(cust[custIdx][0], cust[custIdx][1], cust[i][0], cust[i][1]);
			if (sum + dis >= min) continue;
			visit[i] = true;
			dfs(i, depth + 1, sum + dis);
			visit[i] = false;
		}
		
	}
	
}
