package day0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_로봇이동거리 {

	// 우 좌 상 하
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		// A: 오른쪽
		// B: 좌우
		// C: 상하 좌우
		// 벽이 있으면 더 이상 이동하지 못함, 다른 로봇이 있던 초기 위치를 넘어가지 못함.
		// S: 공백 / W: 벽
		// 각 로봇이 갈 수 있는 거리의 합을 구하라

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];

			// map reading
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					map[i][j] = s.charAt(index);
				}
			}

			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int dir = 0;
					switch (map[i][j]) {
					case 'A':
						// for(int k = 1; j + k < N && arr[i][j + k] == 'S' k++) ans++;
						dir = 1;
						break;
					case 'B':
						dir = 2;
						break;
					case 'C':
						dir = 4;
						break;
					}
					for (int d = 0; d < dir; d++) {
						int r = i + dr[d];
						int c = j + dc[d];
						boolean flag = true;
						while (flag) {
							if (r >= 0 && c >= 0 && r < N && c < N && map[r][c] == 'S')
								ans++;
							else
								flag = false;
							r += dr[d];
							c += dc[d];
						}
					}

				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}
}
