package day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1948날짜계산기_D2_107ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int pm = Integer.parseInt(st.nextToken());
			int pd = Integer.parseInt(st.nextToken());
			int nm = Integer.parseInt(st.nextToken());
			int nd = Integer.parseInt(st.nextToken());

			int cnt = 1;
			while (true) {
				if (pm == nm && pd == nd) {
					break;
				}
				pd++;
				if ((pm == 4 || pm == 6 || pm == 9 || pm == 11) && pd > 30) {
					pm++;
					pd = 1;
				} else if (pm == 2 && pd > 28) {
					pm++;
					pd = 1;
				} else if ((pm == 1 || pm == 3 || pm == 5 || pm == 7 || pm == 8
						|| pm == 10 || pm == 12) && pd > 31){
					pm++;
					pd = 1;
				}
				++cnt;
			}
			
			System.out.printf("#%d %d%n", tc, cnt);
		}
	}
}
