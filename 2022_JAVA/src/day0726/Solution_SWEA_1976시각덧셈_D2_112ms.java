package day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1976시각덧셈_D2_112ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int ph = Integer.parseInt(st.nextToken());
			int pm = Integer.parseInt(st.nextToken());
			int nh = Integer.parseInt(st.nextToken());
			int nm = Integer.parseInt(st.nextToken());
			
			int fh = 0, fm = 0;
			if (ph + nh > 12) {
				fh = ph + nh - 12;
			} else {
				fh = ph + nh;
			}
			
			if (pm + nm > 59) {
				fh += 1;
				fm = pm + nm - 60;
			} else {
				fm = pm + nm;
			}
			
			System.out.printf("#%d %d %d\n", tc, fh, fm);
		}
	}
}
