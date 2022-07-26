package day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1940가랏RC카_D2_000ms {

	// 거 = 시 * 속
	
	
	// 07 26 5:51 푸는중에 그냥 올림

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine()); // N초
			int distance = 0;

			int prev_c = 0, prev_s = 1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int command = Integer.parseInt(st.nextToken());
				if (command != 0) {
					int speed = Integer.parseInt(st.nextToken());
					if (command == 1) { // 가속
						if (prev_c == 1) {// 이전이 가속이었으면
							distance += prev_s * speed;
							prev_s = prev_s * speed;
						} else if (prev_c == 0) { // 유지에서 가속 전환이면
							distance += speed;
							prev_s = speed;
						}
						prev_c = command;
					} else if (command == 2) { // 감속
						if (prev_s < speed) { // 현재 속도보다 감속할 속도가 더크면 속도는 0이된다.
							prev_s = 0;
						} else {
							prev_s = prev_s - speed;
						}
						distance += prev_s;
						prev_c = command;
					}
				} else {
					distance += prev_s;
					prev_c = 0;
				}
			}

			System.out.printf("#%d %d\n", tc, distance);
		}
	}
}
