package day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1983조교의성적매기기_D2_109ms {

	static String[] grades = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 학생수
			int k = Integer.parseInt(st.nextToken()) - 1; // 알고싶은 학생 번호

			int[] scores = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int mid = Integer.parseInt(st.nextToken());
				int fin = Integer.parseInt(st.nextToken());
				int hw = Integer.parseInt(st.nextToken());
				scores[i] = (35 * mid) + (45 * fin) + (20 * hw);
			}
			
			// 해당학생의 석차 구하기
			int rank = 0;
			for (int i = 0; i < N; i++) {
				if (scores[i] > scores[k]) rank++;
			}
			
			String ans = grades[(rank * 10) / N];
			System.out.printf("#%d %s\n", tc, ans);
		}
	}
}
