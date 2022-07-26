package day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1984중간평균값구하기_D2_108ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[] arr = new int[10];

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int min_i = 0, max_i = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
				if (arr[i] <= min) {
					min = arr[i];
					min_i = i;
				}
				if (arr[i] >= max) {
					max = arr[i];
					max_i = i;
				}
			}

			int sum = 0;
			for (int i = 0; i < 10; i++) {
				if (i != min_i && i != max_i)
					sum += arr[i];
			}
			int avg = (int) Math.round((double) sum / 8);

			System.out.printf("#%d %d%n", tc, avg);
		}
	}
}
