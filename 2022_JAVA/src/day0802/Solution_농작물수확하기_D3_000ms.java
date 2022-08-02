package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_농작물수확하기_D3_000ms {

	static int[][] farm;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 농장 크기
			farm = new int[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = line.charAt(j);
				}
			}
			
			
			int sum = 0;
			for (int i = 0; i < N / 2; i++) {
				
			}
			
			for (int i = 0; i < N; i++) {
				sum += farm[N/2][i];
			}
			
			for (int i = 0; i < N / 2; i++) {
				
			}
			

			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
