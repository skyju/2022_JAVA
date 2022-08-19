import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_2117_홈방범서비스_누적합_170ms {

	static int N, M, ans;
	// 41칸 [0] ~ [40]
	static int[] cost = { 1, 1, 5, 13, 25, 41, 61, 85, 113, 145, 181, 221, 265, 313, 365, 421, 481, 545, 613, 685, 761,
			841, 925, 1013, 1105, 1201, 1301, 1405, 1513, 1625, 1741, 1861, 1985, 2113, 2245, 2381, 2521, 2665, 2813,
			2965, 3121 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			// input
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			List<int[]> home = new ArrayList<int[]>();
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0, idx = 0; j < N; j++, idx += 2) {
					if (line.charAt(idx) == '1') {
						home.add(new int[] { i, j });
					}
				}
			}
			
			// 운영 비용은 서비스 영역의 면적과 동일
			int maxCntHome = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int[] cnt = new int[2 * N];
					for (int h = 0; h < home.size(); h++) {
						cnt[Math.abs(r - home.get(h)[0]) + Math.abs(c - home.get(h)[1]) + 1]++;
					}
					int cntHome = 0;
					for (int K = 1; K < cnt.length; K++) {
						cntHome += cnt[K];
						if (cntHome * M >= cost[K] && maxCntHome < cntHome)
							maxCntHome = cntHome;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(maxCntHome).append("\n");
		} // end of test case
		System.out.println(sb.toString());
	} // end of main
}