package day0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_숫자만들기 {

	static int[] inputOp;
	static int[] selectOp;
	static int[] number;
	static int N, max, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			// 입력 및 초기화
			N = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			// 연산자
			st = new StringTokenizer(br.readLine(), " ");
			inputOp = new int[4];
			for (int i = 0; i < 4; i++)
				inputOp[i] = Integer.parseInt(st.nextToken());

			// 수
			st = new StringTokenizer(br.readLine(), " ");
			number = new int[N];
			for (int i = 0; i < N; i++)
				number[i] = Integer.parseInt(st.nextToken());

			// logic
			selectOp = new int[N - 1];
			dfs(0);
			sb.append("#").append(tc).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int cnt) {
		if (cnt == N - 1) {
			int result = calculator();
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		for (int d = 0; d < 4; d++) {
			if (inputOp[d] == 0) continue;
			
			inputOp[d] -= 1; // 연산자 사용
			selectOp[cnt] = d; // 사용한 연산자 기록
			dfs(cnt + 1);
			inputOp[d] += 1; // 연산자 사용 취소
		}
	}

	public static int calculator() {
		int result = number[0];
		for (int i = 0; i < N - 1; i++) {
			switch (selectOp[i]) {
			case 0: result += number[i + 1]; break;
			case 1: result -= number[i + 1]; break;
			case 2: result *= number[i + 1]; break;
			case 3: result /= number[i + 1]; break;
			}
		}
		return result;
	}
}
