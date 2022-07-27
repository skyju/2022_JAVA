package day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1940가랏RC카_D2_111ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine()); // N초
			int distance = 0;

			int prev_s = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int command = Integer.parseInt(st.nextToken());
				if (command != 0) {
					int speed = Integer.parseInt(st.nextToken());
					if (command == 1) { // 가속
						prev_s += speed;
					} else if (command == 2) { // 감속
						if (prev_s < speed) { // 현재 속도보다 감속할 속도가 더크면 속도는 0이된다.
							prev_s = 0;
						} else
							prev_s -= speed;
					}
				}
				distance += prev_s;
			}

			System.out.printf("#%d %d\n", tc, distance);
		}
	}
}
