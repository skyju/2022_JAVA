package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_Flatten_D3_128ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int dumpN = Integer.parseInt(br.readLine());
			
			// 입력 받아서 배열에 넣기
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 100; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int tmp = 0;
			// 평탄화 작업
			for (int i = 0; i < dumpN; i++) {
				Arrays.sort(arr);
				tmp = arr[arr.length - 1] - arr[0];
				if (tmp == 0 || tmp == 1) {
					break;
				}
				arr[arr.length - 1] -= 1;
				arr[0] += 1;
			}
			Arrays.sort(arr);
			tmp = arr[arr.length - 1] - arr[0];
			System.out.printf("#%d %d\n", tc, tmp);
			
		}
	}
}
