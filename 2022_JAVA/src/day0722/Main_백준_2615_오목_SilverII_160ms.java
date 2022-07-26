package day0722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2615_오목_SilverII_160ms {

	// +-시 상하, 좌우, 북서남동, 북동남서
	static int[] dc = { 1, 0, 1, 1 };
	static int[] dr = { 0, 1, 1, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[19][19];
		boolean flag = false;
		int win = 0;
		int fr = 0;
		int fc = 0;

		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		x: for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][j] != 1 && arr[i][j] != 2)
					continue;
				for (int d = 0; d < 4; d++) {
					int cnt = 1;
					int nr, nc, pr, pc;
					for (nr = i + dr[d], nc = j + dc[d]; nr >= 0 && nr < arr.length && nc >= 0 && nc < arr.length
							&& arr[i][j] == arr[nr][nc]; nr += dr[d], nc += dc[d])
						cnt++;
					for (pr = i - dr[d], pc = j - dc[d]; pr >= 0 && pr < arr.length && pc >= 0 && pc < arr.length
							&& arr[i][j] == arr[pr][pc]; pr -= dr[d], pc -= dc[d])
						cnt++;
					if (cnt == 5) {
						flag = true;
						win = arr[i][j];
						fr = pr + dr[d] + 1;
						fc = pc + dc[d] + 1;
						break x;
					} else {
						flag = false;
					}

				}
			}
		}
		if (flag) {
			System.out.println(win);
			System.out.println(fr + " " + fc);
		} else {
			System.out.println(0);
		}
	}
}
