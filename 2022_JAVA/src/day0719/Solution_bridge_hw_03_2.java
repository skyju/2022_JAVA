package day0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_bridge_hw_03_2 {
	
	// 상하 중 1, 좌우 중 택1만 탐색하면 되는 문제라서
	static int[] dr = { -1, 0};
	static int[] dc = { 0, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[][] arr = new char[N][N];
		int ans = 1;
		// 1과 1사이의 0으로 이어진 가장 큰 길이

		// 입력 받기
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < N; j++, index += 2) {
				arr[i][j] = s.charAt(index);
			}
		}

		// visit check를 하면 더 좋을 것 같아요.
		// 가지치기도 응용

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != '1') continue;
				for (int d = 0; d < dr.length; d++) {
					int cnt = 1;
					int r = i + dr[d];
					int c = j + dc[d];
					while (r >= 0 && c >= 0 && r < N && c < N && arr[r][c] == '0') {
						cnt++;
						r += dr[d];
						c += dc[d];
					}
					ans = Math.max(ans, cnt);

				}
			}
		}
		
		System.out.println(ans);
		
		/**
		 * 선생님 풀이
		 */
		
		ans = 1;
		
		// 상하좌우를 다 탐색할 필요 없이 하, 우만 탐색하면 되는 문제...
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] != '1') continue;
				int cnt = 1;
				for (int i = 1; r + i < N && arr[r + i][c] == '0'; i++) cnt++; // 하
				if (ans < cnt) ans = cnt;
				
				cnt = 1;
				for (int i = 1; c + i < N && arr[r][c + i] == '0'; i++) cnt++; // 우
				if (ans < cnt) ans = cnt;
			}
		}
		
		System.out.println(ans);
	}
	/*
8
1 0 1 0 0 0 1 1
1 1 1 1 0 1 0 0
0 1 0 0 1 0 0 0
0 1 0 0 0 0 0 1
1 0 0 1 1 1 0 1
0 1 1 0 0 0 1 0
0 0 0 1 1 0 0 1
1 1 1 0 0 1 1 1
	*/
}
