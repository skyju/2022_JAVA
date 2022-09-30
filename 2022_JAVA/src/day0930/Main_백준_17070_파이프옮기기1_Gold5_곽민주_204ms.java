package day0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_17070_파이프옮기기1_Gold5_곽민주_204ms {

	static int N, ans;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 집 크기 N

		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0, index = 0; j < N; j++, index += 2) {
				map[i][j] = input.charAt(index);
			}
		}
		dfs(0, 1, 0);
		System.out.println(ans);
	}
	
	// 0: 가로, 1: 세로, 2: 대각
	public static void dfs(int x, int y, int d) {
		if (x == N - 1 && y == N - 1) {
			++ans;
			return;
		}
		switch (d) {
		case 0: 
			if (y + 1 < N && map[x][y + 1] == '0') dfs(x, y + 1, 0);
			break;
		case 1: 
			if (x + 1 < N && map[x + 1][y] == '0') dfs(x + 1, y, 1);
			break;
		case 2: 
			if (y + 1 < N && map[x][y + 1] == '0') dfs(x, y + 1, 0);
			if (x + 1 < N && map[x + 1][y] == '0') dfs(x + 1, y, 1);
			break;
		}
		// 파이프 d가 어떻든 대각으로는 보낸다.
		if (x + 1 < N && y + 1 < N && map[x][y + 1] == '0' && map[x + 1][y] == '0' && map[x + 1][y + 1] == '0')
			dfs(x + 1, y + 1, 2);
	}
}
