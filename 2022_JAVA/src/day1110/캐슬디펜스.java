package day1110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M, D, xNum, max;
	static int[][] map, copy;
	static int[] archers;

	static class Node implements Comparable<Node> {
		int r, c, dist;

		Node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			if (this.dist == o.dist)
				return this.c - o.c;
			return this.dist - o.dist;
		}

		@Override
		public int hashCode() {
			return Objects.hash(r, c);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (r == other.r && c == other.c)
				return true;
			return true;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		archers = new int[3];
		max = 0;
		xNum = 0;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0, index = 0; j < M; j++, index += 2) {
				map[i][j] = input.charAt(index) - '0';
				if (map[i][j] == 1)
					xNum++;
			}
		}

		combi(0, 0);
		System.out.println(max);
	}

	public static void combi(int cnt, int start) {
		if (cnt == 3) {
			goGame();
			return;
		}

		for (int i = start; i < M; i++) {
			archers[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	public static void goGame() {
		// 맵 복사
		copy = new int[N][M];
		for (int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, copy[i], 0, M);
		
		int attack = 0; // 공격당한 적 수

		int castle = N;
		while (castle > 0) {

			// 궁수의 3명의 공격
			Set<Node> set = new HashSet<>();

			for (int i = 0; i < 3; i++) {
				int archerIdx = archers[i];
				// 가장 가까운 적 찾기 여러명이라면 가장 왼쪽 적 찾기
				PriorityQueue<Node> q = new PriorityQueue<>();
				for (int r = castle - 1; r >= 0; r--) {
					for (int c = 0; c < M; c++) {
						if (copy[r][c] == 0) continue;
						int d = Math.abs(castle - r) + Math.abs(archerIdx - c);
						if (d <= D)
							q.offer(new Node(r, c, d));
					}
				}
				// 찾았으면 Set에 집어 넣음
				if (!q.isEmpty())
					set.add(q.poll());
				q.clear();
			}

			// set에 담겨있던 적 어택
			Iterator<Node> iterator = set.iterator();
			while (iterator.hasNext()) {
				Node x = iterator.next();
				copy[x.r][x.c] = 0;
				attack++;
			}
			castle--;
		}
		max = Math.max(max, attack);
	}

}
