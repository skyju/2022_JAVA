package day0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1206View_D3_123ms {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {

			int ans = 0;

			// 테케 길이
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			for (int i = 2; i < N - 2; i++) {
				int max = 0;

				int origin = arr[i];
				// 뒤 2개
				int backOne = arr[i - 1];
				max = Math.max(max, backOne);
				int backTwo = arr[i - 2];
				max = Math.max(max, backTwo);
				// 앞 2개
				int frontOne = arr[i + 1];
				max = Math.max(max, frontOne);
				int frontTwo = arr[i + 2];
				max = Math.max(max, frontTwo);

				if (backOne < origin && backTwo < origin && frontOne < origin && frontTwo < origin) {
					ans += origin - max;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
