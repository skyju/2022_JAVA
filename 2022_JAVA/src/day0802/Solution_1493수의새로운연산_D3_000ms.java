package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1493수의새로운연산_D3_000ms {

	static int[][] arr = new int[300][300];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// map 먼저 setting...
		int temp = 1;
		for (int i = 1; i < 25; i++) {
			int tmp = arr[i - 1][1] + temp;
			for (int j = 1; j < 25; j++) {
				arr[i][j] = tmp;
				tmp += 1;
			}
			temp += 1;
		}

		for (int i = 0; i < 25; i++)
			System.out.println(Arrays.toString(arr[i]));

		/*
		 * for (int tc = 1; tc <= T; tc++) { StringTokenizer st = new
		 * StringTokenizer(br.readLine(), " "); int p =
		 * Integer.parseInt(st.nextToken()); int q = Integer.parseInt(st.nextToken());
		 * 
		 * // &(p), &(q)구하기
		 * 
		 * System.out.printf("#%d %d\n"); }
		 */
	}
}
