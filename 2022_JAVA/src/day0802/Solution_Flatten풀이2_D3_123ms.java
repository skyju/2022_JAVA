package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Flatten풀이2_D3_123ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int dumpN = Integer.parseInt(br.readLine());

			int[] cnt = new int[101]; // 상자의 높이 카운팅 1 ~ 100층
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int max = 0, min = 100, sum = 0; // 최대, 최소높이, 박스 총개수
			for (int i = 0; i < 100; i++) {
				int x = Integer.parseInt(st.nextToken());
				cnt[x]++;
				if (max < x) max = x;
				if (min > x) min = x;
				sum += x;
			}
			
			int target = sum % 100 == 0 ? 0 : 1;
			
			//평탄화 작업
			for (int i = 0; i < dumpN && max - min > target; i++) {
				cnt[max]--;
				cnt[max - 1]++;
				cnt[min]--;
				cnt[min + 1]++;
				if (cnt[max] == 0) max--;
				if (cnt[min] == 0) min++;
			}
			 
			sb.append("# ").append(tc).append(" ").append(max - min).append('\n');
		}
		System.out.println(sb.toString());
	}
}
