package day0727;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1284수도요금경쟁_D2_106ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// A사
			int P = Integer.parseInt(st.nextToken());

			// B사
			int Q = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			// 사용 리터
			int W = Integer.parseInt(st.nextToken());

			int tmp;
			if (W <= R) {
				tmp = Q;
			} else {
				tmp = Q + (S * (W - R));
			}
			System.out.printf("#%d %d%n", tc, Math.min(P * W, tmp));
		}
	}
}
