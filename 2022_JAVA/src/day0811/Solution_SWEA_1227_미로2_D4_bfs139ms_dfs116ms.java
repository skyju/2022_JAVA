package day0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_SWEA_1227_미로2_D4_bfs139ms_dfs116ms {
	
	static char[][] maze = new char[100][100]; // 배열 낭비를 줄인다.
	static int sx, sy, ans;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			br.readLine(); //test case number flush
			
			// maze input && get start & end coordinate 
			for (int i = 0; i < 100; i++) {
				String line = br.readLine();
				for (int j = 0; j < 100; j++) {
					maze[i][j] = line.charAt(j);
					if (maze[i][j] != '2' && maze[i][j] != '3') continue;
					if (maze[i][j] == '2') {
						sx = i;
						sy = j;
					}
				}
			}
			// searching
			//boolean flag = bfs(sx, sy);
			//if (flag) sb.append(1);
			//else sb.append(0);
			visit = new boolean[100][100];
			ans = 0;
			dfs(sx, sy);
			sb.append(ans);
			sb.append("\n");
		} // end of test case for
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int x, int y) {
		if (ans == 1) return;
		visit[x][y] = true; // 방문
		if (maze[x][y] == '3') {
			ans = 1;
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || visit[nx][ny]
				|| maze[nx][ny] == '1') continue;
			dfs(nx, ny);
		}
	}
	
	public static boolean bfs(int x, int y) {
		// 필요한 자료구조 생성
		Queue<Node> queue = new ArrayDeque<Node>();
		visit = new boolean[100][100];
		
		// 초기값 설정
		queue.offer(new Node(x, y));
		visit[x][y] = true;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int d = 0; d < 4; d++) { //사방 탐색
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || visit[nx][ny]
					|| maze[nx][ny] == '1') continue;
				if (maze[nx][ny] == '3') return true;
				queue.offer(new Node(nx, ny));
				visit[nx][ny] = true;
			}
		}
		return false;
	}
}

class Node {
	int x;
	int y;
	
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}