package day0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1992_쿼드트리_Silver1_84ms {

	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = line.charAt(j);
		}
		solve(0, 0, N);
		System.out.println(sb.toString());
	}

	public static void solve(int r, int c, int n) {
		boolean flag = true;
		char start = map[r][c]; // start값
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (start != map[i][j])
					flag = false;
			}
		}

		if (flag) {
			sb.append(start);
			return;
		}

		int nn = n / 2;
		sb.append("(");
		solve(r, c, nn);
		solve(r, c + nn, nn);
		solve(r + nn, c, nn);
		solve(r + nn, c + nn, nn);
		sb.append(")");
	}
}
