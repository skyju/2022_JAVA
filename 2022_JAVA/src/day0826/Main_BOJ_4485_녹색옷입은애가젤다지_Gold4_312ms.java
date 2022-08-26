package day0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main_BOJ_4485_녹색옷입은애가젤다지_Gold4_312ms {

	static int N, ans;
	static int[][] dist;
	static int[][] map; // 인접행렬
	static boolean[][] visit;
	static PriorityQueue<Node> pqueue = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
	static class Node {
		int x, y, w;
		Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int cnt = 1;
		while (N != 0) {

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					map[i][j] = Integer.parseInt(str.charAt(index) + "");
				}
			}

			// 다익스트라 진행
			dist = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++)
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			dijkstra();

			// 최소 비용 구하기
			sb.append("Problem ").append(cnt).append(": ").append(dist[N - 1][N - 1]).append("\n");
			cnt++;
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb.toString());
	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void dijkstra() {
		dist[0][0] = map[0][0]; // 출발지 비용
		pqueue.offer(new Node(0, 0, dist[0][0]));
		
		while (!pqueue.isEmpty()) {
			Node now = pqueue.poll();
			if (visit[now.x][now.y]) continue;
			visit[now.x][now.y] = true;
			
			// now를 통해 갈 수 있는 next를 구하자
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
				Node next = new Node(nx, ny, map[nx][ny]);
				if (dist[next.x][next.y] > now.w + next.w) { // 이미 구해놓은 값보다 유리한 값이 있으면
					dist[next.x][next.y] = now.w + next.w; // 변경하고 큐에 넣는다.
					pqueue.offer(new Node(next.x, next.y, dist[next.x][next.y]));
				}
			}
		}
	}
}
