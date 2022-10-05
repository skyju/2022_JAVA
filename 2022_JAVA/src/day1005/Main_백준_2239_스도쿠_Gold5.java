package day1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2239_스도쿠_Gold5 {

	static int[][] map;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		sb = new StringBuilder();
		for (int r = 0; r < 9; r++) {
			String input = br.readLine();
			for (int c = 0; c < 9; c++) {
				map[r][c] = input.charAt(c) - '0';
			}
		}
		dfs(0, 0);
	}

	public static void dfs(int r, int c) {
		if (c == 9) {
			dfs(r + 1, 0);
			return;
		}
		if (r == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) sb.append(map[i][j]);
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}
		// 채워야하는 값이면 탐색
		if (map[r][c] == 0) {
			for (int num = 1; num <= 9; num++) {
				if (isPromissing(r, c, num)) {
					map[r][c] = num;
					dfs(r, c + 1);
				}
			}
			map[r][c] = 0; // fix 했던 값을 rollback
			return;
		}
		// 채워야 하는 값이 아니면 그냥 다음 탐색으로
		dfs(r, c + 1);
	}

	public static boolean isPromissing(int r, int c, int num) {
		// 가로, 세로 유망
		for (int i = 0; i < 9; i++) {
			if (map[i][c] == num) return false;
			if (map[r][i] == num) return false;
		}
		
		// 3x3 유망
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;
		for (int dr = 0; dr < 3; dr++) {
			for (int dc = 0; dc < 3; dc++) {
				if (map[sr + dr][sc + dc] == num) return false;
			}
		}
		return true;
	}
}
