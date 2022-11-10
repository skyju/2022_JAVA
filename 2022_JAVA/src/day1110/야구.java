package day1110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main_야구 {

	static int N, ans;
	static int[][] result;
	static int[] select;
	static boolean[] visit;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 이닝 수
		ans = 0;

		// 각 이닝의 결과
		result = new int[N][10];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 1, index = 0; j <= 9; j++, index += 2) {
				result[i][j] = input.charAt(index) - '0';
			}
		}

		// 1~9 타순을 정하려함 1번선수는 4번타자로 미리 결정되어 있음
		select = new int[10];
		visit = new boolean[10];
		visit[1] = true;
		permutation(1);
		System.out.println(ans);
	}

	// 8개의 순열
	public static void permutation(int cnt) {
		if (cnt == 4) {
			select[4] = 1;
			permutation(cnt + 1);
		}
		if (cnt == 10) {
			// 가장 많은 득점을 하는 타순을 찾고 그 때의 득점을 구하자
			goGame();
			return;
		}

		for (int i = 2; i <= 9; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			select[cnt] = i;
			permutation(cnt + 1);
			visit[i] = false;
		}
	}

	public static void goGame() {
		int score = 0;
		// 각 이닝에 대하여 반복문
		int tasunIdx = 1;
		x: for (int i = 0; i < N; i++) {
			boolean[] ground = new boolean[4];
			int out = 0;
			while (true) {
				if (tasunIdx > 9) tasunIdx = 1;
				int res = result[i][select[tasunIdx]];
				switch (res) {
          case 0: // 아웃 : 3아웃시 이닝 종료 
					out++;
					if (out >= 3) {
						tasunIdx++;
						continue x;
					}
					break;
          case 1: // 안타 : 타자 주자 1루씩 진루
					if (ground[3]) {
						ground[3] = false;
						score++;
					}
					if (ground[2]) {
						ground[2] = false;
						ground[3] = true;
					}
					if (ground[1]) {
						ground[1] = false;
						ground[2] = true;
					}
					ground[1] = true;
					break;
          case 2: // 2루타 : 타자 주자 2루씩 진루
					if (ground[3]) {
						ground[3] = false;
						score++;
					}
					if (ground[2]) {
						ground[2] = false;
						score++;
					}
					if (ground[1]) {
						ground[1] = false;
						ground[3] = true;
					}
					ground[2] = true;
					break;
          case 3: // 3루타 : 타자 주자 3루씩 진루
					if (ground[3]) {
						ground[3] = false;
						score++;
					}
					if (ground[2]) {
						ground[2] = false;
						score++;
					}
					if (ground[1]) {
						ground[1] = false;
						score++;
					}
					ground[3] = true;
					break;
          case 4: // 홈런 : 타자 주자  진루
					if (ground[3]) {
						ground[3] = false;
						score++;
					}
					if (ground[2]) {
						ground[2] = false;
						score++;
					}
					if (ground[1]) {
						ground[1] = false;
						score++;
					}
					// 타자까지
					score++;
					break;
				}
				tasunIdx++;
			}
		}
		ans = Math.max(ans, score);
	}
}
