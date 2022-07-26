package day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2005파스칼의삼각형_D2_111ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			// 배열 채우기
			for (int i = 0; i < N; i++) {
				map[i][0] = 1;
			}

			for (int i = 1; i < N; i++) {
				for (int j = 1; j < N; j++) {
					map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
				}
			}
			
			// 출력
			System.out.printf("#%d\n", tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						System.out.print(map[i][j] + " ");
					}
				}
				System.out.println();
			}
		}
	}
}
