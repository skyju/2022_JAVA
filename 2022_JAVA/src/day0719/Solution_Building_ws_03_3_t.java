package day0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_Building_ws_03_3_t {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 상하좌우, 북동, 남동, 북서, 남서
		int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, -1, 1, 1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // tc
		for (int tc = 1; tc <= t; tc++) {

			// 입력 받기
			int N = Integer.parseInt(br.readLine()); /// N은 자연수 3~20
			char[][] arr = new char[N + 2][N + 2];

			// StringTokenizer 안쓰는 게 더 빨라요!
			for (int i = 1; i <= N; i++) {
				String s = br.readLine();
				for (int j = 1, index = 0; j <= N; j++, index += 2) {
					arr[i][j] = s.charAt(index);
				}
			}

			int max = 0;
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (arr[r][c] == 'G')
						continue;
					boolean flag = true;
					for (int i = 0; i < dr.length; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (arr[nr][nc] == 'G') {
							flag = false;
							break;
						}
					}

					// 요 아래로는 같음
					int count = 0;
					if (flag) { // 빌딩 조성가능
						count = -1;
						for (int i = 1; i <= N; i++) {
							if (arr[r][i] == 'B') count++;
							if (arr[i][c] == 'B') count++;
						}
					} else
						count = 2;
					if (max <= count) max = count;
				}
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
