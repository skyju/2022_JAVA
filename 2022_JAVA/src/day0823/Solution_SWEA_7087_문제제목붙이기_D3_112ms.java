package day0823;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_7087_문제제목붙이기_D3_112ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[] alpha = new char[N];
			for (int i = 0; i < N; i++)
				alpha[i] = br.readLine().charAt(0);
			
			Arrays.sort(alpha);
			
			int cnt = 0;
			char comp = 'A';
			for (int i = 0; i < N; i++) {
				if(alpha[i] > comp) break;
				if (comp == alpha[i]) {
					cnt++;
					comp++;
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		
		} // test case for문 종료
		
		System.out.println(sb.toString());
	
	} // main method 종료
} // class 종료
