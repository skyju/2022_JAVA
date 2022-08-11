package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_4789_성공적인공연기획_D3_149ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			// 0번째 글자 -> 아무도 없을 떄 기립박수하는 사람 수
			// i번째 글자 -> i명 이상일때 기립박수하는 사람 수
			String input = br.readLine();
			
			int curClap = Integer.parseInt(input.charAt(0) + ""); // 초기값
			int ans = 0;
			for (int i = 1; i < input.length(); i++) {
				// i명 이상일 때 박수치게 될 사람 수 num
				int num = Integer.parseInt(input.charAt(i) + "");
				if (i <= curClap) { //조건 충족일 때는 박수 무리에 합류
					curClap += num;
				} else {
					int nowEmpl = i - curClap; // 지금 고용해야하는 사람 수
					ans += nowEmpl;
					curClap += (nowEmpl + num); // 고용인과 num모두 박수 합류
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}