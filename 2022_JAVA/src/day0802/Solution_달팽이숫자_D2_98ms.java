package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_달팽이숫자_D2_98ms {

	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			arr = new int[N][N];

			
			int r = 0, c = -1;
			int curv = 1;
			int max = N; //찍을 숫자 갯수
			
			int num = 1;
			for (int i = 0; i < N; i++) {
				
				//가로
				for (int j = 0; j < max; j++) {
					c += curv;
					arr[r][c] = num++;
				}
				
				max--;
				
				//세로
				for (int j = 0; j < max; j++) {
					r += curv;
					arr[r][c] = num++;
				}
				curv *= -1;
			}
			
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
