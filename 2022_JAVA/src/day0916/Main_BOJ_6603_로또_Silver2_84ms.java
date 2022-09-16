package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_6603_로또_Silver2_84ms {

	static final int LOTTO_SIZE = 6;
	static int k;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = 1;
		
		while (k != 0) {
			st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			result = new int[LOTTO_SIZE];
			for (int i = 0; i < k; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			// arr을 가지고 조합 만들기
			// 사전 순으로 출력해야 하므로, 우선 sorting
			Arrays.sort(arr);
			comb(0, 0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void comb(int flag, int start, int cnt) {
		if (cnt == LOTTO_SIZE) {
			for (int i = 0; i < LOTTO_SIZE ; i++) {
				sb.append(result[i]);
				if (i != k - 1) sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < k; i++) {
			if ((flag & 1 << i) != 0) continue;
			result[cnt] = arr[i];
			comb(flag | 1 << i, i, cnt + 1);
		}
	}
}
