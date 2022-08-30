package day0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7272_안경이없어_D3_157ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		
		// 1. 구멍 없음, 2. 구멍 하나, 3. 구멍 두개
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			String first = st.nextToken();
			String second = st.nextToken();
			
			String ans = "SAME";
			if (first.length() != second.length()) {
				ans = "DIFF";
			} else {
				for (int i = 0; i < first.length(); i++) {
					char c1 = first.charAt(i);
					char c2 = second.charAt(i);
					if ("ADOPQR".indexOf(c1) != -1) {
						if ("ADOPQR".indexOf(c2) == -1) {
							ans = "DIFF";
							break;
						}
					}
					if (c1 == 'B') {
						if (c2 != 'B') {
							ans = "DIFF";
							break;
						}
					}
					if ("ADOPQR".indexOf(c2) != -1) {
						if ("ADOPQR".indexOf(c1) == -1) {
							ans = "DIFF";
							break;
						}
					}
					if (c2 == 'B') {
						if (c1 != 'B') {
							ans = "DIFF";
							break;
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
