package day0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1600_말이되고픈원숭이_Gold3_곽민주_000ms {

	static int[] dr = { -1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { 0, 0, -1, 1, -2, -1, 1, 2, -2, -1, 1, 2 };

	static char[][] map;

	static class Node {
		int x, y, cnt, chance;

		Node(int x, int y, int cnt, int chance) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.chance = chance;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine()); // 원숭이가 말처럼 움직일 수 있는 횟수
		st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		map = new char[H][W];

		for (int i = 0; i < H; i++) {
			String input = br.readLine();
			for (int j = 0, index = 0; j < W; j++, index += 2) {
				map[i][j] = input.charAt(index);
			}
		}
		System.out.println(bfs(K, W, H));
	}

	public static int bfs(int K, int W, int H) {
		Queue<Node> queue = new ArrayDeque<>();

		// 행, 열, 해당 자리에서 말처럼 뛸 기회가 살아있는지 여부
		// false가 기본이라 초기화 하지 않고 쓰기 위해 거꾸로 생각하면 됨..
		boolean[][][] visit = new boolean[H][W][K + 1];

		queue.offer(new Node(0, 0, 0, K));

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (now.x == H - 1 && now.y == W - 1) return now.cnt;
			for (int d = 0; d < 4; d++) {
				int nr = now.x + dr[d];
				int nc = now.y + dc[d];
				if (nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc] == '1' || visit[nr][nc][now.chance])
					continue;
				visit[nr][nc][now.chance] = true;
				queue.offer(new Node(nr, nc, now.cnt + 1, now.chance));
			}
			if (now.chance > 0) {
				for (int d = 3; d < 12; d++) {
					int nr = now.x + dr[d];
					int nc = now.y + dc[d];
					if (nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc] == '1' || visit[nr][nc][now.chance - 1])
						continue;
					visit[nr][nc][now.chance - 1] = true;
					queue.offer(new Node(nr, nc, now.cnt + 1, now.chance - 1));
				}
			}
		}
		return -1;
	}

}
