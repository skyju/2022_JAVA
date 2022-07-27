package day0727;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_SWEA_1288새로운불면증치료법_D2_132ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			Set<Integer> set = new HashSet<>();
			int N = Integer.parseInt(br.readLine());
			
			int multi = N;
			int ans = 1;
			while (true) {
				String tmp = multi + "";
				for (int i = 0; i < tmp.length(); i++)
					set.add(tmp.charAt(i) - '0');
				if (set.size() == 10) break;
				++ans;
				multi = N * ans;
			}

			System.out.printf("#%d %d\n", tc, multi);
		}
	}
}
