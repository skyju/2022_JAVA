package day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_2146_다리만들기_Gold3 {

	static int N, ans;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0, index = 0; j < N; j++, index += 2) {
				map[i][j] = input.charAt(index);
			}
		}

		// 섬끼리 구분을 해야함
		char flag = '2';
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1') {
					numbering(i, j, flag);
					++flag;
				}
			}
		}

		// 다리를 지어봄
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != '0') {
					mkBridge(i, j, map[i][j]);
				}
			}
		}
		
		System.out.println(ans);
	}

	public static void numbering(int r, int c, char flag) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { r, c, flag });
		visit[r][c] = true;
		map[r][c] = flag;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (visit[nr][nc] || map[nr][nc] == '0')
					continue;
				queue.offer(new int[] { nr, nc, flag });
				visit[nr][nc] = true;
				map[nr][nc] = flag;
			}
		}
	}

	public static void mkBridge(int r, int c, char flag) {
		Queue<int[]> queue = new LinkedList<int[]>();
		visit = new boolean[N][N];
		queue.offer(new int[] { r, c, 0 });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc])
					continue;
				if (map[nr][nc] != flag) {
					if (map[nr][nc] == '0') {
						queue.offer(new int[] { nr, nc, now[2] + 1 });
						visit[nr][nc] = true;
					} else {
						// 다리 다 놔졌음!
						ans = ans > now[2] ? now[2] : ans;
						break;
					}
				}
			}
		}
	}
}