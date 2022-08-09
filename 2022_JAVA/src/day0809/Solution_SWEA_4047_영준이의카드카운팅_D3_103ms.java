package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_4047_영준이의카드카운팅_D3_103ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int[][] sdhc = new int[4][14]; // [][0]에는 총갯수 카운팅
			boolean flag = true;

			String str = br.readLine();
			x: for (int i = 0; i <= str.length() - 3; i += 3) {
				char c = str.charAt(i);
				int n = Integer.parseInt(str.charAt(i + 1) + "" + str.charAt(i + 2));
				switch (c) {
				case 'S':
					sdhc[0][0]++;
					if (sdhc[0][n] == 0) sdhc[0][n] = 1;
					else {
						flag = false;
						break x;
					}
					break;
				case 'D':
					sdhc[1][0]++;
					if (sdhc[1][n] == 0) sdhc[1][n] = 1;
					else {
						flag = false;
						break x;
					}
					break;
				case 'H':
					sdhc[2][0]++;
					if (sdhc[2][n] == 0) sdhc[2][n] = 1;
					else {
						flag = false;
						break x;
					}
					break;
				case 'C':
					sdhc[3][0]++;
					if (sdhc[3][n] == 0) sdhc[3][n] = 1;
					else {
						flag = false;
						break x;
					}
					break;
				}
			}
			if (flag) {
				sb.append(13 - sdhc[0][0]).append(" ");
				sb.append(13 - sdhc[1][0]).append(" ");
				sb.append(13 - sdhc[2][0]).append(" ");
				sb.append(13 - sdhc[3][0]).append("\n");
			} else {
				sb.append("ERROR").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}