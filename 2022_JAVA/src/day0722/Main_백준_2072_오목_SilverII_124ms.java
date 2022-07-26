package day0722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2072_오목_SilverII_124ms {

	static char[][] arr = new char[19][19];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean flag = false;
		for (int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			if (t % 2 == 0)
				arr[i][j] = 'W';
			else
				arr[i][j] = 'B';
			if (t < 9 || flag) continue;
			int cnt = 0;
			// 상하
			for (int r = i - 1; r >= 0 && arr[i][j] == arr[r][j]; r--)
				++cnt;
			for (int r = i + 1; r < arr.length && arr[i][j] == arr[r][j]; r++)
				++cnt;
			flag = setting(cnt, flag, t);
			// 좌우
			cnt = 0;
			for (int c = j - 1; c >= 0 && arr[i][j] == arr[i][c]; c--) ++cnt;
			for (int c = j + 1; c < arr.length && arr[i][j] == arr[i][c]; c++) ++cnt;
			flag = setting(cnt, flag, t);
			// 북서 남동
			cnt = 0;
			for (int r = i - 1, c = j - 1; r >= 0 && c >= 0 && arr[i][j] == arr[r][c]; r--, c--) ++cnt;
			for (int r = i + 1, c = j + 1; r < arr.length && c < arr.length && arr[i][j] == arr[r][c]; r++, c++) ++cnt;
			flag = setting(cnt, flag, t);
			// 북동 남서
			cnt = 0;
			for (int r = i - 1, c = j + 1; r >= 0 && c < arr.length && arr[i][j] == arr[r][c]; r--, c++) ++cnt;
			for (int r = i + 1, c = j - 1; r < arr.length && c >= 0 && arr[i][j] == arr[r][c]; r++, c--) ++cnt;
			flag = setting(cnt, flag, t);
		}
		if (flag)
			System.out.println(ans);
		else
			System.out.println(-1);

	}

	public static boolean setting(int cnt, boolean flag, int t) {
		boolean res = flag;
		if (cnt >= 4 && flag == false) {
			ans = t + 1;
			res = true;
		}
		if (cnt >= 5)
			res = false;
		return res;
	}
}