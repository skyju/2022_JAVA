package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3109_빵집_Gold2_324ms {

	static char[][] map;
	static int r, c, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		ans = 0;

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 스타트 시점을 각 행으로 모두 두어봐야 함
		for (int i = 0; i < r; i++) linkingPipe(0, i);
		System.out.println(ans);
	}

	public static boolean linkingPipe(int col, int row) {
		if (col == c - 1) { // 연결완료!
			++ans;
			return true;
		}
		
		// 0열은 항상 비어있으니 처음부터 next부터 보면됨
		for (int i = -1; i <= 1; i++) {
			int nc = col + 1;
			int nr = row + i;
			if (nr < 0 || nr >= r || nc >= c) continue;
			if (map[nr][nc] == '.') {
				map[nr][nc] = 'x';
				if (linkingPipe(nc, nr)) return true; //왔던 길로 또 못가게 해야됨
			}
		}
		return false;
	}
}
