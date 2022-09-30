package day0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, min;
	static char[][] map;

	static class Node {
		int x, y, time;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static Node start;
	static List<Node> devils;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			// 입력
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			devils = new ArrayList<>();
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == 'S') start = new Node(i, j);
					else if (map[i][j] == '*') devils.add(new Node(i, j));
				}
			}
			bfs();
			sb.append("#").append(tc).append(" ");
			if (min == Integer.MAX_VALUE) sb.append("GAME OVER").append("\n");
			else sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];

		queue.offer(start);
		visit[start.x][start.y] = true;

		while (!queue.isEmpty()) {
			spreadDevil();
			Node now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (visit[nx][ny] || map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
				if (map[nx][ny] == 'D') {
					min = Math.min(min, now.time + 1);
				} else {
					queue.offer(new Node(nx, ny, now.time + 1));
					visit[nx][ny] = true;
				}
			}
		}
	}

	public static void spreadDevil() {
		int size = devils.size();
		for (int i = 0; i < size; i++) {
			Node now = devils.remove(0);
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (map[nx][ny] == 'X' || map[nx][ny] == 'D' || map[nx][ny] == '*') continue;
				map[nx][ny] = '*';
				devils.add(new Node(nx, ny));
			}
		}
	}
}
