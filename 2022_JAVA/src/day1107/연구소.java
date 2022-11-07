package day1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static char[][] map;
	static char[][] copy;

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static List<Node> wallHubo;
	static List<Node> virus;
	static Node[] selected;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 2 바이러스
		// 1 벽, 0 빈칸
		map = new char[N][M];
		wallHubo = new ArrayList<Node>();
		virus = new ArrayList<Node>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0, index = 0; j < M; j++, index += 2) {
				map[i][j] = input.charAt(index);
				if (map[i][j] == '0') {
					wallHubo.add(new Node(i, j));
				} else if (map[i][j] == '2') {
					virus.add(new Node(i, j));
				}
			}
		}
		selected = new Node[3];
		ans = 0;
		combi(0, 0);
		System.out.println(ans);
	}

	public static void combi(int cnt, int start) {
		if (cnt == 3) {
			// 맵 카피
			copy = new char[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, copy[i], 0, M);
			}

			// 벽세워보기
			for (int i = 0; i < 3; i++) {
				Node now = selected[i];
				copy[now.r][now.c] = '1';
			}
			
			// 바이러스 퍼트리기
			bfs();

			// 안전 영역 크기 구해보기
			int size = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copy[i][j] == '0') {
						size++;
					}
				}
			}
			ans = Math.max(ans, size);
			return;
		}

		for (int i = start; i < wallHubo.size(); i++) {
			selected[cnt] = wallHubo.get(i);
			combi(cnt + 1, i + 1);
		}
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		boolean[][] visit = new boolean[N][M];

		for (int i = 0; i < virus.size(); i++) {
			q.offer(virus.get(i));
			visit[virus.get(i).r][virus.get(i).c] = true;
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node now = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if (visit[nr][nc]) continue;
					if (copy[nr][nc] == '0') {
						copy[nr][nc] = '2';
						q.offer(new Node(nr, nc));
						visit[nr][nc] = true;
					}
				}
			}
		}
	}
}
