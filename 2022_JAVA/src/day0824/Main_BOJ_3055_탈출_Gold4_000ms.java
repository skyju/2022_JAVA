import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_3055_탈출_Gold4_000ms {
	
	static class Node {
		int r;
		int c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static List<Node> water;
	static Node start;
	static int R, C, min;
	static char[][] map, copy;
	static int[] dr = { -1, 1, 0, 0 }; // 위, 아래, 오른쪽, 왼쪽
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		water = new ArrayList<Node>();
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					start =  new Node(i, j);
				} else if (map[i][j] == '*') {
					water.add(new Node(i, j));
				}
			}
		}
		
		goDochi();
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		if (min < Integer.MAX_VALUE) System.out.println(min);
		else System.out.println("KAKTUS");
	}
	
	// bfs
	public static void goDochi() {
		// 필요한 자료구조 먼저 생성
		Queue<Node> queue = new LinkedList<Node>();
		int[][] visit = new int[R][C];
		
		queue.offer(start);
		visit[start.r][start.c] = 1;
		
		while (!queue.isEmpty()) {
			
			Node now = queue.poll();
			spreadWater();
			
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				if (visit[nr][nc] != 0) continue;
				if (map[nr][nc] == 'D') {
					if (min > visit[now.r][now.c])
						min = visit[now.r][now.c]; 
				}
				if (map[nr][nc] == '.') {
					visit[nr][nc] = visit[now.r][now.c] + 1;
					map[nr][nc] = 'S';
					queue.offer(new Node(nr, nc));
				}
			}
		}
	}
	
	public static void spreadWater() {
		List<Node> tmp = new ArrayList<Node>();
		for (int i = 0; i < water.size(); i++) {
			Node now = water.get(i);
			int r = now.r;
			int c = now.c;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == '.') {
					map[nr][nc] = '*';
					tmp.add(new Node(nr, nc));
				}
			}
		}
		water = tmp;
	}
}
