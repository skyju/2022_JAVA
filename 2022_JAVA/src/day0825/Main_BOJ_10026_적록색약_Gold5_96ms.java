package day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_10026_적록색약_Gold5_96ms {
	
	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] map1 = new char[N][N]; // non적록색약
		char[][] map2 = new char[N][N]; // 적록색양
		boolean[][] visit1 = new boolean[N][N];
		boolean[][] visit2 = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			map1[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if(map1[i][j] == 'G') map2[i][j] = 'R';
				else map2[i][j] = map1[i][j];
			}
		}
		
		int cnt1 = 0, cnt2 = 0;
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit1[i][j]) {
					bfs(map1, visit1, i, j);
					cnt1++;
				}
				if (!visit2[i][j]) {
					bfs(map2, visit2, i, j);
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}
	
	public static void bfs(char[][] map, boolean[][] visit, int x, int y) {
		// 필요한 자료 구조 생성
		Queue<Node> queue = new LinkedList<Node>();
		//초기 값 입력
		queue.add(new Node(x, y));
		visit[x][y] = true;
		
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if (visit[nx][ny]) continue;
				if (map[now.x][now.y] == map[nx][ny]) {
					queue.offer(new Node(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
	}
}
