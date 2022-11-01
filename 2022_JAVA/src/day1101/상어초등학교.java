import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, population;
	static int[] list;
	static int map[][];
	static List<List<Integer>> fav;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int r, c, favNum, blankNum;
		
		Node(int r, int c, int favNum, int blankNum) {
			this.r = r;
			this.c = c;
			this.favNum = favNum;
			this.blankNum = blankNum;
		}
		
		// favNum이 가장 많은 칸으로
		// 여거래면 비어있는 칸이 가장 많은 칸으로
		// 여러개면 행 번호가 가장 작은 칸으로
		// 여러개면 열 번호가 가장 작은 칸으로
		@Override
		public int compareTo(Node o) {
			if (this.favNum == o.favNum) {
				if (this.blankNum == o.blankNum) {
					if (this.r == o.r) return this.c - o.c;
					return this.r - o.r;
				}
				return o.blankNum - this.blankNum;
			}
			return o.favNum - this.favNum;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		population = (int) Math.pow(N, 2);
		map = new int[N][N];
		fav = new ArrayList<List<Integer>>();
		list = new int[population];

		for (int i = 0; i < population + 1; i++)
			fav.add(new ArrayList<Integer>());

		for (int i = 0; i < population; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()); // 학생 번호
			list[i] = num;
			for (int j = 0; j < 4; j++) {
				fav.get(num).add(Integer.parseInt(st.nextToken()));
			}
		}

		map[1][1] = list[0]; // 첫번째 학생은 그냥 해당 자리에 배치
		
		// 모든 학생에 대하여 앉히기 진행
		for (int i = 1; i < population; i++) {
			sitting(list[i]);
		}
		
		// 만족도 구하기
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int favNum = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
						if (fav.get(map[i][j]).contains(map[nr][nc])) favNum++;
					}
				}
				switch (favNum) {
				case 1:
					result += 1;
					break;
				case 2:
					result += 10;
					break;
				case 3:
					result += 100;
					break;
				case 4:
					result += 1000;
					break;
				}
			}
		}
		System.out.println(result);
	}

	public static void sitting(int stuNum) {
		Queue<Node> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int favNum = 0;
				int blankNum = 0;
				if (map[i][j] != 0) continue; // 이미 학생이 앉아있는 자리면 넘어가기
				boolean flag = false;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
						if (map[nr][nc] == 0) blankNum++;
						else if (fav.get(stuNum).contains(map[nr][nc])) favNum++;
						flag = true;
					}
				}
				if (flag) q.offer(new Node(i, j, favNum, blankNum));
			}
		}
		// 앉히기
		Node res = q.poll();
		map[res.r][res.c] = stuNum;
	}
}
