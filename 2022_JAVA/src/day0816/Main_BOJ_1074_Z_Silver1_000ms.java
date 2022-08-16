package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1074_Z_Silver1_000ms {
	static int r, c, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		// (r, c)를 몇번째로 방문했는지 출력.. 2^N 크기를 탐색
		recursive((int) Math.pow(2, N), 0, 0);
	}
	
	// 탐색해야할 전체 크기, 현재탐색 행, 열
	static void recursive(int n, int row, int col) {
		if (row == r && col == c) {
			System.out.println(ans);
			return;
		}
		
		if (row <= r && col <= c
			&& r < (row + n) && c < (col + n)) {
			int nn = n / 2;
			recursive(nn, row, col);
			recursive(nn, row, col + nn);
			recursive(nn, row + nn, col);
			recursive(nn, row + nn, col + nn);
		} else {
			ans += n * n;
		}
	}
}