import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4_814ms {

	static int N, max;
	static int[] src, map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			max = 0;

			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			src = new int[N];
			map = new int[N];

			for (int i = 0; i < N; i++)
				src[i] = Integer.parseInt(st.nextToken());
			perm(0, 0);
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	public static void perm(int cnt, int flag) {
		if (cnt == N) {
			calculator(0, 0, 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) continue;
			map[cnt] = src[i];
			perm(cnt + 1, flag | 1 << i);
		}
	}
	
	public static void calculator(int cnt, int lsum, int rsum) {
		if (cnt == N) {
			max++;
			return;
		}
		calculator(cnt + 1, lsum + map[cnt], rsum);
		if (lsum >= rsum + map[cnt])
			calculator(cnt + 1, lsum, rsum + map[cnt]);
	}
	
}
