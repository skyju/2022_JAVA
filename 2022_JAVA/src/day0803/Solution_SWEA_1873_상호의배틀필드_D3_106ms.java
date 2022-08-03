
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1873_상호의배틀필드_D3_106ms {

	static char[][] map;
	static int row;
	static int col;
	static int[] dr = {-1, 1, 0, 0}; //상, 하, 좌, 우
	static int[] dc = {0, 0, -1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			// input
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			//map = new char[H][]; // 가변배열
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				// map[i] = line.toCharArray();
				for (int j = 0; j < W; j++) {
					char c = map[i][j] = line.charAt(j);
					if (c == '^' || c == 'v' || c == '<' || c == '>') {
						row = i;
						col = j;
					}
				}
			}

			// cmd input
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			for (int i = 0; i < N; i++) {
				char c = line.charAt(i);
				if (c == 'U') {
					map[row][col] = '^';
					if (row - 1 >= 0 && map[row - 1][col] == '.') {
						map[row][col] = '.';
						map[row - 1][col] = '^';
						row -= 1;
					}
				} else if (c == 'D') {
					map[row][col] = 'v';
					if (row + 1 < H && map[row + 1][col] == '.') {
						map[row][col] = '.';
						map[row + 1][col] = 'v';
						row += 1;
					}
				} else if (c == 'L') {
					map[row][col] = '<';
					if (col - 1 >= 0 && map[row][col - 1] == '.') {
						map[row][col] = '.';
						map[row][col - 1] = '<';
						col -= 1;
					}
				} else if (c == 'R') {
					map[row][col] = '>';
					if (col + 1 < W && map[row][col + 1] == '.') {
						map[row][col] = '.';
						map[row][col + 1] = '>';
						col += 1;
					}
				} else if (c == 'S') { // Shooting
					char bul = map[row][col];
					int tmp = 1;
					if (bul == '^') {
						while (row - tmp >= 0 && (map[row - tmp][col] != '#' && map[row - tmp][col] != '*')) tmp++;
						if (row - tmp >= 0 && map[row - tmp][col] == '*')
							map[row - tmp][col] = '.';
					} else if (bul == 'v') {
						while (row + tmp < H && (map[row + tmp][col] != '#' && map[row + tmp][col] != '*')) tmp++;
						if (row + tmp < H && map[row + tmp][col] == '*')
							map[row + tmp][col] = '.';
					} else if (bul == '<') {
						while (col - tmp >= 0 && (map[row][col - tmp] != '#' && map[row][col - tmp] != '*')) tmp++;
						if (col - tmp >= 0 && map[row][col - tmp] == '*')
							map[row][col - tmp] = '.';
					} else if (bul == '>') {
						while (col + tmp < W && (map[row][col + tmp] != '#' && map[row][col + tmp] != '*')) tmp++;
						if (col + tmp < W && map[row][col + tmp] == '*')
							map[row][col + tmp] = '.';
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				sb.append(map[i]).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
