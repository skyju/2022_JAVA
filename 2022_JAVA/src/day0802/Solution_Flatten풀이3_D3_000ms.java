package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_Flatten풀이3_D3_000ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int dumpN = Integer.parseInt(br.readLine());

			// 입력 받아서 배열에 넣기
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0; // 상자의 총 개수
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			int target = sum % 100 == 0 ? 0 : 1; // 평탄화 작업의 목표치 구하기
			Arrays.sort(arr); // 정렬

			// 평탄화 작업
			for (int i = 0; i < dumpN && arr[99] - arr[0] > target; i++) {
				arr[99]--;
				arr[0]++;
				Arrays.sort(arr); // 정렬상태 유지
			}
			System.out.printf("#%d %d\n", tc, arr[99] - arr[0]);

		}
	}
}
