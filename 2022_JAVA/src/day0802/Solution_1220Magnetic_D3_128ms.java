package day0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1220Magnetic_D3_128ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();

			int[][] arr = new int[100][100];

			// 입력
			for (int i = 0; i < 100; i++) {
				String line = br.readLine();
				for (int j = 0, index = 0; j < 100; j++, index += 2) {
					arr[i][j] = line.charAt(index);
				}
			}

			int ans = 0;
			// 행단위 탐색은 안해도되고 하 방향으로만 보면 되므로, 열우선 탐색
			for (int j = 0; j < 100; j++) {
				boolean chk = false; //이전에 n극이 나왔는지 체크
				for (int i = 0; i < 100; i++) {
					if (chk && arr[i][j] == '2') { //우선 n극이 위에 있고 s극이 나온다면 교착상태
						ans++;
						chk = false; //쌍 하나 찾았으니 하나의 교착 해방
					} else if (arr[i][j] == '1') chk = true;
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
