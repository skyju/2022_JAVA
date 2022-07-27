package day0722;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2615_오목_SilverII_160ms {

	static int[][] arr = new int[21][21]; // 배열의 경계 테두리

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 19; i++) {
			String line = br.readLine();
			for (int j = 1, index = 0; j <= 19; j++, index += 2) {
				arr[i][j] = line.charAt(index);
			}
		}

		for (int r = 1; r <= 19; r++) {
			for (int c = 1; c <= 19; c++) {
				// 4방 탐색하면서 오목이지 확인
				if (arr[r][c] == '0') continue;
				int ansColor = complete(r, c);
				if (ansColor == 0)
					continue;
				else {
					System.out.println(ansColor - '0');
					System.out.println(r + " " + c);
					return;
				}
			}
		}
		System.out.println(0); // 아직 승부가 결정나지 않음
	} // end of main

	static int[] dr = { 1, 0, 1, -1 }; // 하, 우, 우하, 우상
	static int[] dc = { 0, 1, 1, 1 };

	private static int complete(int r, int c) {
		int color = arr[r][c];
		for (int i = 0; i < 4; i++) { // 4방 탐색
			// 오목 전칸을 확인해야 탐색을 확 줄일 수 있음!
			if (arr[r - dr[i]][c - dc[i]] == color)
				continue; // 오목 전칸은 다른 색이거나, 공백, 바둑판 밖이어야
			// 오목인지 확인
			if (arr[r + dr[i]][c + dc[i]] != color 
					|| arr[r + dr[i] * 2][c + dc[i] * 2] != color
					|| arr[r + dr[i] * 3][c + dc[i] * 3] != color 
					|| arr[r + dr[i] * 4][c + dc[i] * 4] != color)
				continue;
			if (arr[r + dr[i] * 5][c + dc[i] * 5] == color)
				continue;
			return color;
		}
		return 0;
	} // end of complete

} // end of class
