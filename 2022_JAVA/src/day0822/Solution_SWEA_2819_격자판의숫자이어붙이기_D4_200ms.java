package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_SWEA_2819_격자판의숫자이어붙이기_D4_200ms {
	
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Set<Integer> set;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			map = new int[4][4];
			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				String line = br.readLine();
				for (int j = 0, index = 0; j < 4; j++, index += 2)
					map[i][j] = line.charAt(index) - '0';
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) search(i, j, 1, map[i][j]);
			}
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void search(int r, int c, int cnt, int num) {
		if (cnt == 7) {
			set.add(num);
			return;
		}
		for (int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4) continue;
			search(nr, nc, cnt + 1, (num * 10) + map[nr][nc]);
		}
	}
}
	
