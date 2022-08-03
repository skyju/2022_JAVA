import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2042_구간합구하기4_Silver4_592ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N : 수의 개수
		int M = Integer.parseInt(st.nextToken()); // M : 합을 구해야하는 횟수

		long memo[] = new long[N + 1]; // 0번 안씀

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++)
			memo[i] = memo[i - 1] + Long.parseLong(st.nextToken());
		
		for (int tmp = 0; tmp < M; tmp++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(memo[j] - memo[i - 1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}