package day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17472_다리만들기2_Gold1 {

	static class Node implements Comparable<Node> {
		int to, from, weight;

		public Node(int to, int from, int value) {
			this.to = to;
			this.from = from;
			this.weight = value;
		}

		// 그래프 간선을 가중치 기준으로 오름차순 정렬
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static int N, M, landCnt;

	static int[][] map;
	static int[] parents;
	static boolean[][] visit;

	static Queue<int[]> q;
	static PriorityQueue<Node> pq = new PriorityQueue<>();;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 0. 입력 받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1. 섬 넘버링 하기(1이 기본이라 2부터 시작)
		landCnt = 2;
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					numbering(i, j, landCnt);
					landCnt++;
				}
			}
		}

		// 2. 다리 건설 
		// 되는 대로 다 건설해서 pq에 넣어놓음 그러나 pq니까 가중치 기준 정렬되어서 들어감
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) { // 섬이면
					visit = new boolean[N][M];
					makeBridge(i, j, map[i][j]);
				}
			}
		}

		// 3. 크러스칼 (유니온)
		parents = new int[landCnt];
		for (int i = 2; i < landCnt; i++)
			parents[i] = i;
		int answer = kruskal();
		System.out.println(answer == 0 ? -1 : answer);
	}

	// 최소신장 트리 : 크러스칼
	// 사이클 판단을 위해 유니온 알고리즘이 들어가 있다.
	static int kruskal() {
		int len = 0;
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			Node now = pq.poll();
			if (find(now.from) != find(now.to)) { // 사이클이 아니면
				len += now.weight;
				union(now.from, now.to);
			}
		}

		// 섬이 다 잘 이어져있나 확인하기
		// 문제에서 모든 섬을 이으라고 했지만 1번과 모든 섬만 이어져있으면 됨
		int fisrt = parents[2];
		for (int i = 3; i < landCnt; i++) {
			if (fisrt != find(parents[i])) { // 이어져있지 않은 섬이 있으면
				return 0;
			}
		}
		return len;
	}

	// union logic
	static int find(int x) {
		if (parents[x] == x)
			return x;
		int rx = find(parents[x]);
		return rx;

	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y)
			parents[y] = x;
		else
			parents[x] = y;
	}

	// 섬 넘버링
	static void numbering(int x, int y, int flag) {
		// 자료구조 생성
		q = new LinkedList<>();

		// 초기값 세팅
		q.offer(new int[] { x, y });
		map[x][y] = flag;
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny])
					continue;
				if (map[nx][ny] == 1) {
					map[nx][ny] = flag;
					visit[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	// 다리 연결
	static void makeBridge(int x, int y, int flag) {
		q = new LinkedList<>();

		for (int d = 0; d < 4; d++) { // 사방으로 가는데 한방향씩 쭉 진행
			q.offer(new int[] { x, y, 0 });
			visit[x][y] = true;

			while (!q.isEmpty()) {
				int[] now = q.poll();
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				int len = now[2];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny])
					continue;

				if (map[nx][ny] != flag) {
					if (map[nx][ny] != 0) {
						if (len > 1) {
							pq.add(new Node(flag, map[nx][ny], len));
							break; // 이쪽방향으로 땡
						}
					} else {
						visit[nx][ny] = true;
						q.offer(new int[] { nx, ny, len + 1 });
					}
				}
			}
			q.clear();
		}
	}
}