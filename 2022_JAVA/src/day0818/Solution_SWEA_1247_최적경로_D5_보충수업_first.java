package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1247_최적경로_D5_보충수업_first {
	
	// 이 코드는 약 2000ms ~전후가 나온다.

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
			
			perm(0); // 0 : tgt의 맨 앞부터 채우겠다.
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static void perm(int tgtIdx) {
		// 기저 조건
		if (tgtIdx == N) {
			// complete code
			// 현재 순열의 경우의 수가 하나 완성된 상태
			// 거리계산 후 최소값인지 확인, 갱신
			
			// 회사 - 첫번째 고객
			int sum = distance(comX, comY, cust[tgt[0]][0], cust[tgt[0]][1]);
			// 첫번재 고객 - 마지막 고객
			for (int i = 0; i < N - 1; i++) {
				sum += distance(cust[tgt[i]][0], cust[tgt[i]][1], cust[tgt[i + 1]][0], cust[tgt[i + 1]][1]);
			}
			// 마지막 고객  - 집
			sum += distance(homeX, homeY, cust[tgt[N - 1]][0], cust[tgt[N - 1]][1]);
			min = Math.min(min, sum);
			return;
		}

		// src (cust)의 N개의 고객 중 하나씩 선택해 가는 과정을 거친다.
		// 단 이미 이전에 선택한 고객은 제외한다.
		for (int i = 0; i < N; i++) {
			if (select[i]) continue; //이미 이전에 선택된 고객은 skip
			select[i] = true;
			tgt[tgtIdx] = i;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}
	
}
