package day0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5644_무선충전_000ms {

	static int ans;
	static int[][] map;
	static int[] A;
	static int[] B;
	// UP-RIGHT-DOWN-LEFT
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	static int[] P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			// initialize
			map = new int[10][10];
			ans = 0;
			P = new int[10];

			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); // Moving time 20 <= M <= 100
			int BCnum = Integer.parseInt(st.nextToken()); // Battery Charger Number 1 <= BCnum <= 8

			// User moving information
			A = new int[M]; // 0, 0 start
			B = new int[M]; // 9, 9 start
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++)
				A[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++)
				B[i] = Integer.parseInt(st.nextToken());

			// Battery Charger information
			for (int i = 0; i < BCnum; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int C = Integer.parseInt(st.nextToken());
				P[i] = Integer.parseInt(st.nextToken());

				fillMap(x, y, C, i);
			}


			// Starting A, B
			int ax = 0, ay = 0, bx = 9, by = 9;
			int idx = 0;
			while (true) {
				int bitsA = map[ax][ay];
				int bitsB = map[bx][by];
				
				int maxSum = 0;

				// case A
				for (int i = 0; i < BCnum; i++) {
					if ((bitsA & (1 << i)) == 0) continue;
					if (P[i] > maxSum) maxSum = P[i];
				}

				// case B
				for (int i = 0; i < BCnum; i++) {
					if ((bitsB & (1 << i)) == 0) continue;
					if (P[i] > maxSum) maxSum = P[i];
				}

				// case A and B
				for (int i = 0; i < BCnum; i++) {
					if ((bitsA & (1 << i)) == 0) continue;
					for (int j = 0; j < BCnum; j++) {
						if (j == i || (bitsB & (1 << j)) == 0) continue;
						int sum = P[i] + P[j];
						if (sum > maxSum) maxSum = sum;
					}
				}

				ans += maxSum;
				
				if (idx < M) {
					ax += dx[A[idx]];
					ay += dy[A[idx]];
					bx += dx[B[idx]];
					by += dy[B[idx]];
					idx++;
				} else break;
			}

			sb.append(ans).append("\n");
		} // end of test case for
		System.out.println(sb.toString());
	} // end of main

	private static void fillMap(int x, int y, int c, int i) {
		int nx, ny;
		for (int d = 0; d <= c; d++) {
			for (int range = -d; range <= d; range++) {
				int C1 = d - Math.abs(range);
				int C2 = -C1;

				nx = x + range;
				if (nx >= 0 && nx < 10) {
					ny = y + C1;
					if (ny >= 0 && ny < 10) {
						map[nx][ny] |= (1 << i);
					}
					ny = y + C2;
					if (ny >= 0 && ny < 10) {
						map[nx][ny] |= (1 << i);
					}
				}
			}
		}
	}
} // end of class
