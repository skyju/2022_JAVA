package day0727;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1285아름이의돌던지기_D2_000ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int min = Integer.MAX_VALUE;
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (min >= Math.abs(tmp - 0)) {
					if (min == Math.abs(tmp - 0)) cnt++;
					min = Math.abs(tmp - 0);
				};
			}
			System.out.printf("#%d %d %d%n", tc, min, cnt);
		}
	}
}
