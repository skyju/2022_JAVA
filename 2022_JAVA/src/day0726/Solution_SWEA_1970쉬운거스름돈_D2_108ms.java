package day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1970쉬운거스름돈_D2_108ms {

	static int[] chgs = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[] chg = new int[chgs.length];
			
			int tmp = N;
			for (int i = 0; i < chgs.length; i++) {
				chg[i] = tmp / chgs[i];
				tmp -= (tmp / chgs[i]) * chgs[i];
			}
			
			System.out.printf("#%d%n", tc);
			for (int i = 0; i < chg.length; i++) {
				System.out.print(chg[i] + " ");
			}
			System.out.println();
		}
	}
}
