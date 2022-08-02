package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_달팽이숫자_선생님_D2 {

	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			int r = 0, c = 0;
			int size = N - 1; //진행할 한 변
			int num = 1; // 저장할 숫자
			while (size > 0) {
				for (int i = 0; i < size; i++) //우
					arr[r][c++] = num++;
				for (int i = 0; i < size; i++) //하
					arr[r++][c] = num++;
				for (int i = 0; i < size; i++) //좌
					arr[r][c--] = num++;
				for (int i = 0; i < size; i++) //상
					arr[r--][c] = num++;
				break;
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
