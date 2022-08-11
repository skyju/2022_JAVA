package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16935_배열돌리기3_시도2_Silver1_472ms {
	static int N, M;
	static String[][] map;
	static String[][] copy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st.nextToken(); // R flush
		map = new String[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
				map[i][j] = st.nextToken();
		}
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			if (i % 2 == 0) rotate(input.charAt(i));
		}

		// output
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(map[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());

	} // end of main

	public static void rotate(char ch) {
		int limit, swap;
		int halfN, halfM;
		switch (ch) {
		case '1': // 상하반전
			for (int i = 0; i < N / 2; i++) {
				String[] tmp = new String[M];
				System.arraycopy(map[i], 0, tmp, 0, M);
				System.arraycopy(map[N - 1 - i], 0, map[i], 0, M);
				System.arraycopy(tmp, 0, map[N - 1 - i], 0, M);
			}
			break;
		case '2': // 좌우반전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					String tmp = map[i][j];
					map[i][j] = map[i][M - 1 - j];
					map[i][M - 1 - j] = tmp;
				}
			}
			break;
		case '3': // 오른쪽으로 90도 회전
			copy = new String[M][N]; // 계속 새로운 객체를 만드는거보다 위에서 만들어서 재탕하는게 좋음(배열 통째로 스왑해버려)
			limit = N - 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++)
					copy[j][limit] = map[i][j];
				limit--;
			}
			// N과 M 바꿔줌
			swap = N;
			N = M;
			M = swap;
			map = copy;
			break;
		case '4': // 왼쪽으로 90도 회전
			copy = new String[M][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[M - 1 - j][i] = map[i][j];
				}
			}
			// N과 M 바꿔줌
			swap = N;
			N = M;
			M = swap;
			map = copy;
			break;
		case '5': // 전체 맵을 4등분해서 시계방향으로 회전 ,, 왜 여기에는 System.arraycopy()안썼니!
			// 12
			// 43
			copy = new String[N][M];
			halfN = N / 2;
			halfM = M / 2;
			// 1 <- 4
			for (int i = 0; i < halfN; i++) {
				for (int j = 0; j < halfM; j++)
					copy[i][j] = map[i + halfN][j];
			}
			// 2 <- 1
			for (int i = 0; i < halfN; i++) {
				for (int j = halfM; j < M; j++)
					copy[i][j] = map[i][j - halfM];
			}
			// 3 <- 2
			for (int i = halfN; i < N; i++) {
				for (int j = halfM; j < M; j++)
					copy[i][j] = map[i - halfN][j];
			}
			// 4 <- 3
			for (int i = halfN; i < N; i++) {
				for (int j = 0; j < halfM; j++)
					copy[i][j] = map[i][j + halfM];
			}
			map = copy;
			break;
		case '6': // 전체 맵을 4등분해서 반시계방향으로 회전
			copy = new String[N][M];
			halfN = N / 2;
			halfM = M / 2;
			// 1 <- 2
			for (int i = 0; i < halfN; i++) {
				for (int j = 0; j < halfM; j++)
					copy[i][j] = map[i][j + halfM];
			}
			// 2 <- 3
			for (int i = 0; i < halfN; i++) {
				for (int j = halfM; j < M; j++)
					copy[i][j] = map[i + halfN][j];
			}
			// 3 <- 4
			for (int i = halfN; i < N; i++) {
				for (int j = halfM; j < M; j++)
					copy[i][j] = map[i][j - halfM];
			}
			// 4 <- 1
			for (int i = halfN; i < N; i++) {
				for (int j = 0; j < halfM; j++)
					copy[i][j] = map[i - halfN][j];
			}
			map = copy;
			break;
		}
	}
	
	/**
	 * 알고리즘에서는 쓰지말고 참고
	 */
	static OperInter[] opers = {new Oper1(), new Oper2()};
	static interface OperInter {
		void oper();
	}
	static class Oper1 implements OperInter {
		@Override
		public void oper() {}
	}
	static class Oper2 implements OperInter {
		@Override
		public void oper() {}
	}
}
