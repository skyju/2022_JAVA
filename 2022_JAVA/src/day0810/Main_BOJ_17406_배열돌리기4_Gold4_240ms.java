package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17406_배열돌리기4_Gold4_240ms {

	// 핵심1. 배열 회전하기
	// 핵심2. 순열로 회전연산 시키기

	static int N, M, K;
	static int[][] map; // 원본맵
	static int[][] copy; // 카피 맵
	static int[][] cal; // 원본 회전 연산 커맨드 저장
	static boolean[] visit; // 순열 체크를 위해서
	static int[] result; // cal을 토대로 만든 순열 저장
	static int ans = Integer.MAX_VALUE; // 최종 값

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 첫 map input받기
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		// 회전연산 input 받기
		cal = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cal[i][0] = Integer.parseInt(st.nextToken()); // r
			cal[i][1] = Integer.parseInt(st.nextToken()); // c
			cal[i][2] = Integer.parseInt(st.nextToken()); // s
		}

		// 회전연산 input을 토대로 순열만들기
		visit = new boolean[K];
		result = new int[K];
		perm(0);
		
		System.out.println(ans);

	} // end of main

	// 배열회전
	public static void rotate(int r, int c, int s) {
		int pr = r - s - 1;
		int pc = c - s - 1;
		int nr = r + s - 1;
		int nc = c + s - 1;

		for (int t = 0; t <= s; t++) {
			// 지워질 수 있는 값 저장
			int tmp1 = copy[pr][nc];
			int tmp2 = copy[nr][nc];
			int tmp3 = copy[nr][pc];

			// 윗변
			for (int i = nc; i > pc; i--) {
				copy[pr][i] = copy[pr][i - 1];
			}

			// 오른변
			for (int i = nr; i > pr; i--) {
				if (i == pr + 1) copy[i][nc] = tmp1;
				else copy[i][nc] = copy[i - 1][nc];
			}

			// 아랫변
			for (int i = pc; i < nc; i++) {
				if (i == nc - 1) copy[nr][i] = tmp2;
				else copy[nr][i] = copy[nr][i + 1];
			}

			// 왼변
			for (int i = pr; i < nr; i++) {
				if (i == nr - 1) copy[i][pc] = tmp3;
				else copy[i][pc] = copy[i + 1][pc];
			}
			pr++;
			nr--;
			pc++;
			nc--;
		}
	}

	// 회전 연산 커맨드로 순열만들기
	public static void perm(int idx) {
		if (idx == K) {
			// 2차원 배열은 깊은 복사 해야 합니다.
			copy = new int[N][M];
			for (int i = 0; i < map.length; i++)
				System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
			// 따끈따끈한 result 순열로 rotate하면서 합 구해봄
			calculator();
			return;
		}

		for (int i = 0; i < K; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				result[idx] = i;
				perm(idx + 1);
				visit[i] = false;
			}
		}
	}

	// 순열 순서로 rotate하면서 row합을 계산한다.
	public static void calculator() {
		// 우선 rotate
		for (int i = 0; i < result.length; i++) {
			rotate(cal[result[i]][0], cal[result[i]][1], cal[result[i]][2]);
		}
		// 합구하자
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++)
				sum += copy[i][j];
			if (ans > sum) ans = sum;
		}
	}
}
