package day1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_17143_낚시왕_Gold1_2840ms {

	static int R, C, M, ans;
	static int[] dr = { -1, 1, 0, 0 }; // 위 아래 오른쪽 왼쪽
	static int[] dc = { 0, 0, 1, -1 };
	static Shark[][] map;
	static List<Shark> list;

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Shark other = (Shark) obj;
			if (z != other.z)
				return false;
			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 격자판의 행크기 (2 <= R,C <= 100)
		C = Integer.parseInt(st.nextToken()); // 격자판의 열크기
		M = Integer.parseInt(st.nextToken()); // 상어의 수 (0 <= M <= R*C)

		map = new Shark[R][C];
		list = new ArrayList<Shark>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()) - 1; // 이동 방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			map[r][c] = new Shark(r, c, s, d, z);
			list.add(new Shark(r, c, s, d, z));
		}
		kingGo();
		System.out.println(ans);
	}

	public static void kingGo() {
		for (int c = 0; c < C; c++) { // 낚시왕이 오른쪽으로 한칸 이동한다.
			int r = 0;
			while (r < R && map[r][c] == null)
				r++;
			if (r != R) { // 잡을 상어가 존재
				ans += map[r][c].z;
				Shark tmp = map[r][c];
				map[r][c] = null;
				list.remove(tmp);
			}
			fishGo();
		}
	}

	public static void fishGo() {
		
		// 이 부분 고쳐보기
		for (int i = 0; i < list.size(); i++) {
			Shark now = list.get(i);
			for (int j = 0; j < now.s; j++) {
				int nr = now.r + dr[now.d];
				int nc = now.c + dc[now.d];
				if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
					now.r = nr;
					now.c = nc;
				} else {
					if (now.d % 2 == 0)
						now.d++;
					else
						now.d--;
					j--;
				}
			}
		}
		map = new Shark[R][C];
		for (int i = 0; i < list.size(); i++) {
			Shark now = list.get(i);
			if (map[now.r][now.c] != null) { // 이미 뭔 값이 들어있음
				if (now.z > map[now.r][now.c].z) { // 들어있는 값보다 새로운 값이 더 크다
					Shark tmp = map[now.r][now.c];
					map[now.r][now.c] = now;
					list.remove(tmp); // 들어 있던 값 제거
					i--; // indexing 처리
				} else {
					list.remove(now); // 새로 뽑은 값 제거
					i--;
				}
			} else {
				map[now.r][now.c] = now;
			}
		}
	}
}
