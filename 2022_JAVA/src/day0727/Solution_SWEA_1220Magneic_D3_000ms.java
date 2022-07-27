package day0727;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1220Magneic_D3_000ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			// 1 N 위 
			// 2 S 아래
			br.readLine();
			
			int[][] arr = new int[100][100];
			
			// 입력
			for (int i = 0; i < 100; i++) {
				String line = br.readLine();
				for (int j = 0, index = 0; j < 100; j++, index += 2) {
					arr[i][j] = line.charAt(index);
				}
			}
			
			int previous;
			int ans = 0;
			// 행단위 탐색은 안해도되고 하 방향으로만 보면됨
			for (int j = 0; j < 100; j++) {
				previous = 2;
				int tmp = 0;
				for (int i = 0; i < 100; i++) {
					if (arr[i][j] == '0') continue;
					else {
						if (previous != arr[i][j]) { //교착상태
							if (tmp != 1) {
								++ans;
								if (ans == 1) {
									ans += 1;
								}
							}
							tmp++;
						}
						previous = arr[i][j];
					}
				}
				System.out.println(j + "열의 교착상태 누적 " + ans);
			}
			
			System.out.println(ans);
		}
	}
}
