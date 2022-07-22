package day0722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2615_오목_SilverII_000ms2 {

	/**
	 * 흰돌이 이기면 2 검은돌이 이기면 1 승부가 안났으면 0
	 * 
	 * 승부가 났을 시, 가장 외쪽에 있는 바둑알의 좌표 출력 단,(1,1)이 가장 첫좌표라고 가정
	 */
	static int[][] arr = new int[19][19];
	static int win;
	static boolean flag = false;
	static int fr;
	static int fc;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 1 && arr[i][j] != 2)
					continue;
				++tmp;
				if (tmp >= 8 && !flag) {
					int tr = i;
					int tc = j;
					int cnt = 0;
					// 상하
					for (int r = i - 1; r >= 0 && arr[i][j] == arr[r][j]; r--) {
						++cnt;
						tr = r;
					}
					for (int r = i + 1; r < arr.length && arr[i][j] == arr[r][j]; r++)
						++cnt;
					calculator(cnt, arr[i][j], tr, tc);

					// 좌우
					tr = i;
					tc = j;
					cnt = 0;
					for (int c = j - 1; c >= 0 && arr[i][j] == arr[i][c]; c--) {
						++cnt;
						tc = c;
					}
					for (int c = j + 1; c < arr.length && arr[i][j] == arr[i][c]; c++)
						++cnt;
					calculator(cnt, arr[i][j], tr, tc);

					// 북서 남동
					tr = i;
					tc = j;
					cnt = 0;
					cnt = 0;
					for (int r = i - 1, c = j - 1; r >= 0 && c >= 0 && arr[i][j] == arr[r][c]; r--, c--) {
						++cnt;
						tr = r;
						tc = c;
					}
					for (int r = i + 1, c = j + 1; r < arr.length && c < arr.length && arr[i][j] == arr[r][c]; r++, c++)
						++cnt;
					calculator(cnt, arr[i][j], tr, tc);

					// 북동 남서
					tr = i;
					tc = j;
					cnt = 0;
					cnt = 0;
					for (int r = i - 1, c = j + 1; r >= 0 && c < arr.length && arr[i][j] == arr[r][c]; r--, c++) {
						++cnt;
						tr = r;
					}
					for (int r = i + 1, c = j - 1; r < arr.length && c >= 0 && arr[i][j] == arr[r][c]; r++, c--) {
						++cnt;
						tc = c;
					}
					calculator(cnt, arr[i][j], tr, tc);
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

	public static void calculator(int cnt, int color, int r, int c) {
		if (cnt >= 4 && !flag) {
			flag = true;
			win = color;
			fr = r + 1;
			fc = c + 1;
		}
	}
}
