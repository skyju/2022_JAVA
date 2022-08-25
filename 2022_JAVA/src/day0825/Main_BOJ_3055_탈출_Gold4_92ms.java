package day0825;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_3055_탈출_Gold4_92ms {
	
	static class Node {
		int r;
		int c;
		int cnt;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static Queue<Node> water = new LinkedList<Node>();
	static Node start;
	static int R, C;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 }; // 위, 아래, 오른쪽, 왼쪽
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					start =  new Node(i, j);
				} else if (map[i][j] == '*') {
					water.offer(new Node(i, j));
				}
			}
		}
		
		bfs();
		System.out.println("KAKTUS");
	}
	
	public static void bfs() {
		// 필요한 자료구조 먼저 생성
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			
			int waterSize = water.size();
			for (int t = 0; t < waterSize; t++) {
				Node now = water.poll();
				for (int d = 0; d < 4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
					if (map[nr][nc] == '.') {
						map[nr][nc] = '*';
						water.offer(new Node(nr, nc));
					}
				}
			}
			
			int qSize = queue.size();
			for (int t = 0; t < qSize; t++) {
				Node now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
					if (map[nr][nc] == 'D') {
						System.out.println(now.cnt + 1);
						System.exit(0);
					} else if (map[nr][nc] == '.') {
						map[nr][nc] = 'S';
						queue.offer(new Node(nr, nc, now.cnt + 1));
					}
				}
			}
			
		}
	}
}