package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SebsetSumTest {

	static int numbers[];
	static int goalSum, N, totalCnt;
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/**
		 * 유한 개의 자연수로 이루어진 집합이 있을 때,
		 * 이 집합의 부분집합 중에서 그 집합의 원소를 모두 더한 값이 21이 되는 경우가 몇 번이나 있는 지 알아내는 문제
		 * 예를 들어, {5, 21, 11, 16, 6, 10}이라는 부분집합이 있을 때,
		 * {5, 6, 10}은 이 집합의 부분집합이면서 합이 21이므로 적합하다.
		 */

		goalSum = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		visit = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		subset(0, 0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}

	public static void subset(int cnt, int sum) {
		if (sum == goalSum) {
			totalCnt++;
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					System.out.print("" + numbers[i] + '\t');
				}
			}
			System.out.println();
			return;
		}
		
		// sum < goalSum || sum > goalSum
		if (sum > goalSum || cnt == N) return;
		
//		for (int flag = 0, caseCnt = 1 << N; flag < caseCnt; flag++) {
//			int sumt = 0;
//			for (int i = 0; i < N; i++) {
//				if ((flag & (1 << i)) != 0) { // i원소가 부분집합에 포함
//					sumt += numbers[i];
//				}
//			}
//			if (sumt == goalSum) ++totalCnt;
//		}
		
		visit[cnt] = true;
		subset(cnt + 1, sum + numbers[cnt]);
		visit[cnt] = false;
		subset(cnt + 1, sum);
	}

}

// input
//21
//6
//5 21 11 16 6 10
