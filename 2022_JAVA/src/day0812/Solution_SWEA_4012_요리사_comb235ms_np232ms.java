package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사_comb235ms_np232ms {

	/**
	 * N개의 식재료(N은 짝수) N/2씩 나누어 두 개의 요리 A,B의 맛의 차이가 최소가 되도록 재료 배분
	 * 순열로 하면 시간 터짐 (순열로 해서 앞뒤를 잘라보는 방식도 있겠다만, 시너지 행열이 중요한 문제가 아님(통합을 구하는))
	 * np이용 조합이나 조합이용하자
	 * 
	 * 첫시도 315ms
	 * 
	 * 시간 줄인 방법 : calculating에서 for문 구조가 0~N으로 무식하게 돌고 있었음
	 * 2차원 배열에서 우쪽 삼각형이나 아래쪽 삼각형만 보고 행열을 뒤집어 더해주면 된다는 점 이용
	 * 따라서 열은 보고있는 행 다음 것만 본다. (우쪽 삼각형만 확인)
	 */
	
	static int N;
	static int[][] synergy;
	static int min;
	static int[] select;
	
	static boolean[] visit;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			// initialize
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine()); // 식재료 갯수
			synergy = new int[N][N];
			min = Integer.MAX_VALUE;
			visit = new boolean[N];
			
			select = new int[N];
			int tmp = N - 1;
			while (tmp >= N / 2) {
				select[tmp] = 1;
				tmp--;
			}
			
			// synergy input
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					synergy[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// calculating
			do calculator2();
			while (np(select));
			//comb(0, 0);

			sb.append(min).append("\n");
		} // end of test case for
		System.out.println(sb.toString());
		br.close();
	}
	
	public static void comb(int cnt, int start) {
		if (cnt == N / 2) {
			calculator();
			return;
		}
		for (int i = start; i < N; i++) {
			visit[i] = true;
			comb(cnt + 1, i + 1);
			visit[i] = false;
		}
	}

	public static boolean np(int[] numbers) {
		int N = numbers.length;
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) i--;
		if (i == 0) return false;

		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) j--;
		swap(numbers, i - 1, j);

		int k = N - 1;
		while (i < k) swap(numbers, i++, k--);

		return true;
	}

	public static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

	// comb용
	public static void calculator() {
		int a = 0, b = 0; // A, B 맛값 초기화
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visit[i] && visit[j])
					a += (synergy[i][j] + synergy[j][i]);
				else if (!visit[i] && !visit[j])
					b += (synergy[i][j] + synergy[j][i]);
			}
		}
		int ans = Math.abs(a - b);
		if (ans < min) min = ans;
	}
	
	 // np용
    public static void calculator2() {
        int a = 0, b = 0; // A, B 맛값 초기화
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (select[i] == 1 && select[j] == 1)
                    a += (synergy[i][j] + synergy[j][i]);
                else if (select[i] == 0 && select[j] == 0)
                    b += (synergy[i][j] + synergy[j][i]);
            }
        }
        int ans = Math.abs(a - b);
        if (ans < min) min = ans;
    }
}
