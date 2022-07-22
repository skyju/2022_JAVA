package day0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_소금쟁이 {

	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

//		
//		N * N 정사각형 연못
//		처음엔 3 두번째는 2 세번째는 1칸 뜀
//		연못밖으로 나가면 죽음
//		앞에서 뛰었던 소금쟁이의 세번째 위치에 가면 죽음
//		시작위치에 이미 다른 소금쟁이가 있으면 죽음
//		살아있는 소금쟁이 수를 구하라

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 연못 크기 N : 5~20
			int num = Integer.parseInt(st.nextToken()); // 소금쟁이 개수

			int[][] arr = new int[N][N];

			x: for (int i = num; i > 0; i--) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				// 시작 위치에 이미 다른 소금쟁이가 있다면 죽음
				if (arr[r][c] != 0) {
					num--;
					continue;
				}

				for (int j = 3; j >= 1; j--) {
					r += dr[dir] * j;
					c += dc[dir] * j;
					if (r < 0 || r >= N || c < 0 || c >= N || arr[r][c] != 0) {
						num--;
						continue x;
					}
				}
				arr[r][c] = 1;
				
				/* 잘못된 풀이 : 옮기는 와중을 고려안함
				if (dir == 1 && r - 6 >= 0 && arr[r - 6][c] == 0)
					arr[r - 6][c] = 1;
				else if (dir == 2 && r + 6 < N && arr[r + 6][c] == 0)
					arr[r + 6][c] = 1;
				else if (dir == 3 && c - 6 >= 0 && arr[r][c - 6] == 0)
					arr[r][c - 6] = 1;
				else if (dir == 4 && c + 6 < N && arr[r][c + 6] == 0)
					arr[r][c + 6] = 1;
				else
					num--;
				*/
			}
			sb.append("#" + t + " " + num + "\n");
		}
		System.out.println(sb.toString());
	}
}
