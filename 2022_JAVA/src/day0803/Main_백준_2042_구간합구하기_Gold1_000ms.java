import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2042_구간합구하기_Gold1_000ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 메모지네이션, DP

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N : number
		int M = Integer.parseInt(st.nextToken()); // M : count of change number
		int K = Integer.parseInt(st.nextToken()); // K : count of sum

		long arr[] = new long[N];
		long memo[][] = new long[N + 1][N + 1];
		boolean flag = true;

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		for (int i = 0; i < M + K; i++) {
			long sum = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int a = st.nextToken().charAt(0);
			if (a == '1') { // replace .. b'th value is replaced for c.
				int b = Integer.parseInt(st.nextToken());
				arr[b - 1] = Long.parseLong(st.nextToken());
				flag = false;
			} else { // a == 2, printing sum between b and c.
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if (flag) {
					sum = memo[b - 1][c];
				} else {
					for (int t = b - 1; t < c; t++)
						sum += (arr[t]);
					memo[b - 1][c] = sum;
					flag = true;
				}
				sb.append(sum).append("\n");
			}
		}
		System.out.println(sb.toString());

	}
}
