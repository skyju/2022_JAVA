package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_한빈이와SpotMart_D3_141ms {

	/**
	 * N개의 과자봉지, 2개 선택 ai그램의 무게 최대한 양이 많은(무게 많은)과자를 고르고 싶음 M그램 초과하면 X
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, max;
	static int[] a;
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			// input & initialize
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // num
			M = Integer.parseInt(st.nextToken()); // limit
			max = -1;
			a = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				a[i] = Integer.parseInt(st.nextToken());
			comb(0, 0, 0);
			sb.append(max).append("\n");
		}
		br.close();
		System.out.println(sb.toString());
	}
	
	public static void comb(int cnt, int start, int sum) {
		if (sum > M) return; // 무게 초과
		if (cnt == 2) {
			max = Math.max(max, sum);
			return;
		}
		for (int i = start; i < N; i++) {
			comb(cnt + 1, i + 1, sum + a[i]);
		}
	}
}
