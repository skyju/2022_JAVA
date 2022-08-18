package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳_Gold4_752ms {
	
	static int R, C;
	static char[][] map;
	static boolean[] visit;
	static int max;
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[100];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		go(0, 0, 0);
		System.out.println(max);
		// 0, 0에는 말이 놓여져있다.
		// 말은 상하좌우 4방으로 인접한 네칸 중 하나로 이동가능
		// 이동하려면 이동할 칸의 알파벳이 지금까지 지나온 모든 칸에 적혀있는 알파벳과 달라야함
		// 즉, 같은 알파벳이 적힌 칸을 두번 지날 수 없다.
		// 말이 최대한 몇 칸을 지날 수 있는지 구하라. 이동 칸수에는 0, 0도 포함한다.
	}
	
	public static void go(int r, int c, int cnt) {
		if (visit[map[r][c]]) {
			max = Math.max(max, cnt);
			return;
		}
		
		visit[map[r][c]] = true;
		if (r - 1 >= 0) go(r - 1, c, cnt + 1);
		if (r + 1 < R) go(r + 1, c, cnt + 1);
		if (c - 1 >= 0) go(r, c - 1, cnt + 1);
		if (c + 1 < C) go(r, c + 1, cnt + 1);
		visit[map[r][c]] = false;
		
	}
}
