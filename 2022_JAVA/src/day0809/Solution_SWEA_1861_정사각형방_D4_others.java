package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_others {

	/**
	 * 외길이므로 dfs, bfs 다 필요없음
	 * 설명하기 좋은 예시
	 * 3
	 * 7 8 9
	 * 6 1 2
	 * 5 4 3
	 */

	private static int N;
	private static int[][] A;
	private static int[][] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine()); // 1 <= N <= 10^3
			A = new int[N + 2][N + 2]; // 1 <= N*N <= 10^6
			memo = new int[N + 2][N + 2];
			
			// input
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++)
					A[i][j] = Integer.parseInt(st.nextToken());
			}

			int max = 0; // 최대 이동할 수 있는 방의 개수
			int num = Integer.MAX_VALUE; // 최대 이동을 위해 출발할 방위치(숫자)
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					int val = go(r, c); // r,c 위치에서 출발해서 최대 이동할 수 있는 방의 개수를 리턴
					// 이동할수있는 방의개수 최대갑 숙하기: 큰값이면 업데이트, 같은 값이면 방의 숫자가 작으면
					if (max < val || (max == val && num > A[r][c])) {
						max = val;
						num = A[r][c];
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(num).append(" ").append(max).append("\n");
		} // end of for testCase
		System.out.println(sb.toString());
	}// end of main
	
	private static int[] dr = {-1, 1, 0, 0}; //상하좌우
	private static int[] dc = {0, 0, -1, 1};
	/** A[r][c]에서 출발할 때 최대 이동할 수 있는 방의 개수를 리턴하는 메서드 */
	public static int go(int r, int c) {
		if (memo[r][c] != 0) // 탐색을 했던 칸이면 memo 사용
			return memo[r][c];
		
		memo[r][c] = 1; // 아무곳도 갈 수 없는 경우는 내방 한 칸 갈 수 있으니까 초기값 1
		int num = A[r][c]; // 현재 방의 숫자 임시 저장
		for (int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (num + 1 == A[nr][nc]) {
				memo[r][c] += go(nr, nc); // 재귀 호출 후 값 저장(난 한 칸 더 갈 수 있다)
				break; // 외길이니까, 이 한줄로 100ms 줄임
			}
		}
		return memo[r][c]; //A[r][c]에서 출발해서 최대 이동할 수 있는 방의 개수를 리턴
	}
} // end of class
