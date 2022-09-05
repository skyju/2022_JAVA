import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7562_나이트의이동_Silver1_240ms {
	
	static int l; // 체스판 한 변의 길이 (4 <= l <= 300)
	static class Point {
		int x , y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Point start, end;
	// 8방으로 이동가능
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			l = Integer.parseInt(br.readLine());
			
			// 현재 위치
			st = new StringTokenizer(br.readLine(), " ");
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			// 목표 위치
			st = new StringTokenizer(br.readLine(), " ");
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			System.out.println(bfs());
		}
	}
	static int bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		int[][] visit = new int[l][l];
		
		queue.offer(start);
		visit[start.x][start.y] = 0;
		
		while (!queue.isEmpty()) {
			
			Point now = queue.poll();
			if (now.x == end.x && now.y == end.y)
				return visit[now.x][now.y];
			
			for (int d = 0; d < dx.length; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (nx >= 0 && ny >= 0 && nx < l && ny < l && visit[nx][ny] == 0) {
					queue.offer(new Point(nx, ny));
					visit[nx][ny] = visit[now.x][now.y] + 1;
				}
			}
		}
		return 0;
	}
}
