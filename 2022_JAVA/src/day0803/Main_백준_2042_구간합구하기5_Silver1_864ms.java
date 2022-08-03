import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2042_구간합구하기5_Silver1_864ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N : 표의 크기
		int M = Integer.parseInt(st.nextToken()); // M : 합을 구해야하는 횟수

		int[][] sum = new int[N + 1][N + 1];
	
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1]
					+ Integer.parseInt(st.nextToken())
					- sum[i - 1][j - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			//전체
			int ans = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
			
			/**
			 * 333111**
			 * 333111**
			 * 222000**
			 * 222000**
			 * ********
			 * 0? *이 아닌 전체 - 1 - 2 + 3 부분
			 */
			sb.append(ans).append("\n");
		}

		System.out.println(sb.toString());
	}
}