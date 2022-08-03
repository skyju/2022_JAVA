
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2805_농작물수확하기_D3_155ms {

	static int[][] farm;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 농장 크기
			int sum = 0;
			farm = new int[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(line.charAt(j) + "");
				}
			}
			
			
			/**
			 * N = 5일때
			 *   *
			 *  ***
			 * *****
			 *  ***
			 *   *
			 *   
			 *   행번호, 공백숫자, 별숫자
			 *   0 2 1
			 *   1 1 3
			 *   2 0 5
			 *   3 1 3
			 *   4 2 1
			 *   
			 */
			// 마름모 별찍기 원리
			for (int row = 0; row < N; row++) {
				int col = 0;
				
				int c = row;
				if (row >= (N / 2) + 1)
					c = -row + N - 1;
				for (int k = 0; k < -c + (N / 2); k++) col++;
				for (int k = 0; k < 2 * c + 1; k++) sum += farm[row][col++];
			}
			

			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}