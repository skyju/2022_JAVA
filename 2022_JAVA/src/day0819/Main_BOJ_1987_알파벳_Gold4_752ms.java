import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳_Gold4_752ms {

	static int R, C;
	static int[][] map;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++)
				map[i][j] = str.charAt(j) - 'A'; // A:0, B:1 ~ Z
		}
		max = 1;
		go(0, 0, 0, 1 << (map[0][0]));
		System.out.println(max);
	}

	public static void go(int r, int c, int cnt, int visit) {
		if (r - 1 >= 0 && (visit & 1 << map[r - 1][c]) == 0)
			go(r - 1, c, cnt + 1, (visit | 1 << map[r - 1][c]));
		if (r + 1 < R && (visit & 1 << map[r + 1][c]) == 0)
			go(r + 1, c, cnt + 1, (visit | 1 << map[r + 1][c]));
		if (c - 1 >= 0 && (visit & 1 << map[r][c - 1]) == 0)
			go(r, c - 1, cnt + 1, (visit | 1 << map[r][c - 1]));
		if (c + 1 < C && (visit & 1 << map[r][c + 1]) == 0)
			go(r, c + 1, cnt + 1, (visit | 1 << map[r][c + 1]));
		max = Math.max(max, cnt);
	}
}