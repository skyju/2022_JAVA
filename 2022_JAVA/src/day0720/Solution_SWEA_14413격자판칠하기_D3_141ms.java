package day0720;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_14413격자판칠하기_D3_141ms {

	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		/*
		 * # 검은색 . 흰색 ? 흰색 또는 검은색 인접한 변이 항상 다른색이게 할 수있는지 판단하는 프로그램
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			map = new char[N][M];

			// map 입력
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++)
					map[i][j] = s.charAt(j);
			}

			// 한칸마다 상하 좌우로 확인
			boolean flag = true;
			x: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int d = 0; d < dr.length; d++) {
						int r = i + dr[d];
						int c = j + dc[d];
						if (r >= 0 && c >= 0 && r < N && c < M) {
							// 이칸이 #또는 .이고 인접한 같은 값이 있으면 바로 break;
							if ((map[i][j] == '#' || map[i][j] == '.') && map[i][j] == map[r][c]) {
								flag = false;
								break x;
							}
							// 이칸이 ?이고, 인접한 곳에 ?가 아닌 값이 있다면 그 반대 값으로 채움
							if (map[i][j] == '?' && map[r][c] != '?') {
								if (map[r][c] == '#')
									map[i][j] = '.';
								else
									map[i][j] = '#';
							}
						}

					}
				}
			}
			if (!flag) {
				System.out.printf("#%d %s\n", tc, "impossible");
				continue;
			}
			System.out.printf("#%d %s\n", tc, "possible");
		}
	}
	
	// 이문제 뭔가 백준 브루트 포스 문제 체스판 다시 칠하기랑 비슷함..
	
}
