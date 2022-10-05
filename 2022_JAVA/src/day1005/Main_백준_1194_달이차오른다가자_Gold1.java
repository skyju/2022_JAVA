package day1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_백준_1194_달이차오른다가자_Gold1 {

	static int N, M;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int r, c, time, key;

		Node(int r, int c, int time, int key) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.key = key;
		}
	}

	static Node start;
	static Set<Character> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '0') {
					start = new Node(i, j, 0, 0);
				}
			}
		}
		bfs();
		System.out.println(-1);
	}

	public static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		boolean[][][] visit = new boolean[N][M][64];
		
		queue.offer(start);

		while (!queue.isEmpty()) {

			Node now = queue.poll();
			if (map[now.r][now.c] == '1') {
				System.out.println(now.time);
				System.exit(0);
			}
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '#') continue;
				if (visit[nr][nc][now.key]) continue;
				if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') { // 열쇠일때
					int tmpKey = (1 << (map[nr][nc] - 'a')) | now.key;
					if (!visit[nr][nc][tmpKey]) {
						visit[nr][nc][now.key] = true;
						visit[nr][nc][tmpKey] = true;
						queue.offer(new Node(nr, nc, now.time + 1, tmpKey));
					}
				} else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') { // 문일때
					int tmpDoor = (1 << (map[nr][nc] - 'A')) & now.key;
					if (tmpDoor != 0) { // 통과 
						queue.offer(new Node(nr, nc, now.time + 1, now.key));
						visit[nr][nc][now.key] = true;
					}
				} else {
					queue.offer(new Node(nr, nc, now.time + 1, now.key));
					visit[nr][nc][now.key] = true;
				}
			}

		}
	}
}
