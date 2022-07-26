package day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1954달팽이숫자_D2_127ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];


			// 가장큰 반복문은 그대로 있으면됨
			// r과 c가 유지가 되어야하므로 밖으로 뺌
			// 두줄 채우면 방향 꺾여야함
			// 전체 반복 수는 print로 조절
			int print = N;
			int curv = 1;
			int r = 0;
			int c = -1;
			int num = 1;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < print; j++) {
					c += curv;
					map[r][c] = num;
					++num;
				}
				--print;
				for (int j = 0; j < print; j++) {
					r += curv;
					map[r][c] = num;
					++num;
				}
				curv *= -1;
			}
			
			//출력
			System.out.printf("#%d\n", tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					System.out.print(map[i][j] + " ");
				System.out.println();
			}
		}
	}
}
