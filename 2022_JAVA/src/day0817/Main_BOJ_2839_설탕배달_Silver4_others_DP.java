package day0817;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2839_설탕배달_Silver4_others_DP {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] ans = new int[5001];
		ans[1] = ans[2] = ans[4] = 5000;
		ans[3] = ans[5] = 1;
		
		for (int i = 6; i <= N; i++)		
			ans[i] = Math.min(ans[i - 5], ans[i - 3]) + 1;
				
		System.out.println(ans[N] >= 5000 ? -1 : ans[N]);
	}
}