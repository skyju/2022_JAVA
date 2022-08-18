package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1247_최적경로_D5_보충수업_np {
	
	// np는 조합을 만드는 데 많은 시간이 들때 (만들어야하는 조합 수가 많을 때) 유용하다
	// 이 코드는 1000ms ~전후 나온다.

	static int N, comX, comY, homeX, homeY, min;
	static int[][] cust; // 고객의 정보 (src)
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()); // 전체 배열 크기
			cust = new int[N][2]; // 0 : x, 1 : y

			st = new StringTokenizer(br.readLine(), " ");
			comX = Integer.parseInt(st.nextToken());
			comY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			
			// N개의 고객
			for (int i = 0; i < N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 순열
			// 가장 작은 수를 구성
			numbers = new int[N]; // 0, 1, 2 ... N - 1
			for (int i = 0; i < N; i++) numbers[i] = i;
			// np 전에 첫번째도 경우의 수
			while (true) {
				check();
				if(!np()) break;
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean np() {
		int n = numbers.length;
		int i = n - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) --i; //최대값 찾기
		if (i == 0) return false;
		int j = n - 1;
		while (numbers[i - 1] >= numbers[j]) --j; //최대값의 앞자리 찾기
		swap(numbers, i - 1, j);
		int k = n - 1;
		while (i < k) swap(numbers, i++, k--);
		return true;
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
	
	public static void check() {
		int sum = distance(comX, comY, cust[numbers[0]][0], cust[numbers[0]][1]);
		for (int i = 0; i < N - 1; i++)
			sum += distance(cust[numbers[i]][0], cust[numbers[i]][1], cust[numbers[i + 1]][0], cust[numbers[i + 1]][1]);
		sum += distance(homeX, homeY, cust[numbers[N - 1]][0], cust[numbers[N - 1]][1]);
		min = Math.min(min, sum);
	}

	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
