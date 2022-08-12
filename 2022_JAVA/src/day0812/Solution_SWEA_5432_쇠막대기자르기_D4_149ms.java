package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_5432_쇠막대기자르기_D4_149ms {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int ans;
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			ans = 0;
			int laser = 0;
			
			String line = br.readLine();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c == '(') {
					if (i != line.length() - 1 && line.charAt(i + 1) == ')') { // 레이저 가동
						ans += laser;
						i++; // 레이저 넘어감
					} else laser++;
				} else { // )
					ans++; // 한 꽁다리씩 한,, 토막씩 추가되는 느낌
					laser--;
				}
			}
			sb.append(ans).append("\n");
		} // end of test case for
		System.out.println(sb.toString());
	} // end of main
} // end of class
