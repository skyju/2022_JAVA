package day0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_7236_저수지의물의총깊이구하기_D3_115ms {

	static int N, max;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상,하,좌,우, 북서, 북동, 남서, 남동 
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static int search(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < 8; d++) { // 8방으로 확인
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (map[nr][nc] == 'W') cnt++;
			}
		}
		return (cnt == 0)? 1 : cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 저수지 구획의 크기
			map = new char[N][N]; // 빈 저수지 생성
			max = 0; // max값은 0으로 초기화

			// input : 저수지 맵 담기
			for (int i = 0; i < N; i++)
				map[i] = br.readLine().replace(" ", "").toCharArray();
			
			// search : 각 구획마다 깊이를 구해서 max값 갱신하기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 'W') {
						int tmp = search(r, c);
						if (tmp > max) max = tmp;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		} // test case for문 종료
		System.out.println(sb.toString());
	} // main method 종료
} // class 종료
