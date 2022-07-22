package day0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Building_ws_03_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 부지는 N x N
		// 한칸당 빌딩 하나 세울 수 있고
		// B : 빌딩 세울수있음 / G : 공원 조성단지
		// 	인접한 구획에 G가있으면 2층, 인접은 대각선도 포함
		// 	없다면 현 위치의 가로 위치에 있는 빌딩구획 B와 세로위치에 있는 빌딩구획 B의 수를 더한 크기만큼
		// 가장 높은 빌딩은 몇층?

		// 상하좌우, 북동, 남동, 북서, 남서
		int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, -1, 1, 1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {

			// 입력 받기
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = st.nextToken().charAt(0);
				}
			}

			// 계산 및 출력
			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					boolean flag = true;
					for (int d = 0; d < 8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
							if (arr[nr][nc] == 'G')
								flag = false;
						}
					}
					if (flag) { // 빌딩 조성가능
						int count = -1;
						for (int i = 0; i < N; i++) {
							if (arr[r][i] == 'B')
								count++;
							if (arr[i][c] == 'B')
								count++;
						}
						max = Math.max(max, count);
					} else
						max = Math.max(max, 2);
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
