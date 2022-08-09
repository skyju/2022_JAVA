package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2563_색종이_Bronze1_124ms {

	static int ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[100][100];
		ans = 0;
		int N = Integer.parseInt(br.readLine()); // 색종이 갯수

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int nr = r; nr < r + 10; nr++) {
				for (int nc = c; nc < c + 10; nc++) {
					if (map[nr][nc] != 1) { 
						map[nr][nc] = 1;
						ans++;
					}
				}
			}
		}
		
		System.out.println(ans);

	}
}
