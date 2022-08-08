package day0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1493_수의새로운연산_D3_000ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			// &p, &q먼저 구하기
			int p_arr[] = address(p);
			int x1 = p_arr[0];
			int y1 = p_arr[1];
			int q_arr[] = address(q);
			int x2 = q_arr[0];
			int y2 = q_arr[1];

			// #연산 하기
			sb.append("#").append(tc).append(" ").append(revAddr(x1 + x2, y1 + y2)).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int[] address(int n) {
		// return 배열의 index 0이 x좌표, 1이 y좌표

		int cnt = 1;
		for (int i = 1;; i++) { // i는 세로선(\)안의 value 갯수
			for (int x = 1, y = i; x <= i; x++, y--) {
				if (cnt == n)
					return new int[] { x, y };
				++cnt;
			}
		}
	}

	public static int revAddr(int x, int y) {
		
		int cnt = 1;
		for (int i = 1;;i++) {
			for (int r = 1, c = i; r <= i; r++, c--) {
				if (r == x && y == c) return cnt;
				++cnt;
			}
		}
	}
}
