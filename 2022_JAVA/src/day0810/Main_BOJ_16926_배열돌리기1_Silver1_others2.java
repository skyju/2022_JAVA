package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16926_배열돌리기1_Silver1_others2 {
	/**
	 * 2차원 배열의 나이테 하나를 1차원 배열로 다 넣음
	 * 쉬프트를 진행하지 않고 index만큼 움직인 후 다시 담음
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		// receive input array
		int[][] grid = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				grid[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int[] buffer = new int[2 * (N + M) - 4]; // intermediate buffer
		for (int or = 0, oc = 0, lr = N, lc = M; lr > 0 && lc > 0; or++, oc++, lr -= 2, lc -= 2) {
			int elCnt = 2 * (lr + lc) - 4; // element count
			int idx = 0; // buffer index

			// add elements into buffer
			int r = or, c = oc; // current position
			// go down
			for (int k = 1; k < lr; k++, r++) {
				buffer[idx++] = grid[r][c];
			}
			// go right
			for (int k = 1; k < lc; k++, c++) {
				buffer[idx++] = grid[r][c];
			}
			// go up
			for (int k = 1; k < lr; k++, r--) {
				buffer[idx++] = grid[r][c];
			}
			// go left
			for (int k = 1; k < lc; k++, c--) {
				buffer[idx++] = grid[r][c];
			}
			
			// 처음으로 돌아옴
			
			// shift buffer
			idx = (idx - R) % elCnt; // (칸 갯수 - 회전수) % 원래 칸갯수
			if (idx < 0) idx += elCnt;

			// go down
			for (int k = 1; k < lr; k++, r++) {
				grid[r][c] = buffer[idx];
				idx = (idx + 1) % elCnt;
			}
			// go right
			for (int k = 1; k < lc; k++, c++) {
				grid[r][c] = buffer[idx];
				idx = (idx + 1) % elCnt;
			}
			// go up
			for (int k = 1; k < lr; k++, r--) {
				grid[r][c] = buffer[idx];
				idx = (idx + 1) % elCnt;
			}
			// go left
			for (int k = 1; k < lc; k++, c--) {
				grid[r][c] = buffer[idx];
				idx = (idx + 1) % elCnt;
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(grid[r][c]).append(" ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}
