package day1007;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_17472_다리만들기2_골드1_other_76ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] grid = new char[N][M];
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		for (int i = 0; i < grid.length; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < grid[0].length; j++, index += 2) {
				grid[i][j] = s.charAt(index); 
			}
		}
		Deque<int[]> deque = new ArrayDeque<int[]>();
		char color = 'A';
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					int[] temp = {i,j};
					deque.offer(temp);
					while(!deque.isEmpty()) {
						temp = deque.poll();
						if(grid[temp[0]][temp[1]] != '1') continue;
						grid[temp[0]][temp[1]] = color;
						for (int d = 0; d < dr.length; d++) {
							int nr = temp[0] + dr[d];
							int nc = temp[1] + dc[d];
							if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
							if(grid[nr][nc] != '1') continue;
							int[] new_temp = {nr, nc};
							deque.offer(new_temp);
						}
					}
					color++;
				}
			}
		}
		int islands = color - 'A';
		int[][] dist = new int[islands][islands];
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], 10000);
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] != '0') {
					for (int d = 0; d < dc.length; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						int cnt = 0;
						while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
							if(grid[nr][nc] == grid[i][j]) break;
							else if(grid[nr][nc] == '0') {
								nr += dr[d];
								nc += dc[d];
								cnt++;
							}
							else if(cnt < 2) break;
							else if(cnt >= 2) {
								if(dist[grid[i][j] - 'A'][grid[nr][nc] - 'A'] > cnt) dist[grid[i][j] - 'A'][grid[nr][nc] - 'A'] = cnt;
								break;
							}
						}
					}
				}
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[0], o2[0]);
			}
		});
		boolean[] isVisited = new boolean[islands];
		int cnt = 0;
		int bridge = 0;
		int[] temp = {0, 0};
		pq.offer(temp);
		while(!pq.isEmpty()) {
			temp = pq.poll();
			if(isVisited[temp[1]]) continue;
			isVisited[temp[1]] = true;
			cnt++;
			bridge += temp[0];
			if(cnt == islands) {
				System.out.println(bridge);
				return;
			}
			for (int i = 1; i < dist.length; i++) {
				if(!isVisited[i] && dist[temp[1]][i] != 10000) {
					int[] new_temp = {dist[temp[1]][i], i};
					pq.offer(new_temp);
				}
			}
		}
		System.out.println(-1);
	}
}
