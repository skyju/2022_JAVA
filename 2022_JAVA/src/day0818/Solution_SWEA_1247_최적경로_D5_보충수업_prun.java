package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1247_최적경로_D5_보충수업_prun {
	
	/**
	 * min값을 구하는 문제
	 * 현재 과정에서 앞으로 계속 가 봤자 min 값보다 큰 값이 나온다면 갈 필요가 없겠죠.
	 * sum을 달고 다녀야합니다.
	 */


	static int N, comX, comY, homeX, homeY, min;
	static int[][] cust; // 고객의 정보 (src)
	static int[] tgt;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()); // 전체 배열 크기
			cust = new int[N][2]; // 0 : x, 1 : y
			tgt = new int[N];
			select = new boolean[N];

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
			
			perm(0, 0); // 0 : tgt의 맨 앞부터 채우겠다.
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static void perm(int tgtIdx, int sum) {
		// 기저 조건
		if (tgtIdx == N) {
			// complete code
			// 중간에 계속 sum을 계산해 올 것이므로 마지막에는 집으로 가는 sum만 구하면 된다.
			 sum += distance(homeX, homeY, cust[tgt[N - 1]][0], cust[tgt[N  - 1]][1]);
			 min = Math.min(min, sum);
			return;
		}

		// src (cust)의 N개의 고객 중 하나씩 선택해 가는 과정을 거친다. 단 이미 이전에 선택한 고객은 제외한다.
		for (int i = 0; i < N; i++) {
			if (select[i]) continue; //이미 이전에 선택된 고객은 skip
			select[i] = true;
			tgt[tgtIdx] = i;
			
			// 가지치기
			// 첫번째 고객이면 회사 -> 고객, 아니면 고객 -> 다음고객
			int dis = 0;
			if (tgtIdx == 0) dis = distance(comX, comY, cust[tgt[tgtIdx]][0], cust[tgt[tgtIdx]][1]);
			else dis = distance(cust[tgt[tgtIdx - 1]][0], cust[tgt[tgtIdx - 1]][1], cust[tgt[tgtIdx]][0], cust[tgt[tgtIdx]][1]);
			if (dis < min) perm(tgtIdx + 1, sum + dis);
			select[i] = false;
		}
	}
	
}
