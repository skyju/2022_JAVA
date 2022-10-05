package day1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2363_치즈_Gold5_100ms {

	static int R, C;
	static int[][] map;
	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0, index = 0; j < C; j++, index += 2) {
				map[i][j] = input.charAt(index) - '0';
			}
		}
		
		int time = 0;
		int result = 0;
		while (true) {
			int tmp = bfs();
			if (tmp == 0) break;
			else result = tmp;
			time++;
		}
		System.out.println(time);
		System.out.println(result);
	}
	
	public static int bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		boolean visit[][] = new boolean[R][C];
		
		queue.offer(new Node(0, 0));
		visit[0][0] = true;
		
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || visit[nr][nc]) continue;
				
				visit[nr][nc] = true;
				
				if (map[nr][nc] == 1) {
					map[nr][nc] = 0;
					cnt++;
				} else queue.offer(new Node(nr, nc));
			}
		}
		return cnt;
	}
}
