import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9095_123더하기_Silver3_76ms {
	
	static int n;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			dfs(0);
			System.out.println(cnt);
		}
	}
	static void dfs(int sum) {
		if (sum > n) return;
		if (sum == n) {
			cnt++;
			return;
		}
		dfs(sum + 1);
		dfs(sum + 2);
		dfs(sum + 3);
	}
}
