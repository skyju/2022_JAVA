package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시뮬레이션
 * N이 행인지 열인지 테스트 케이스를 통해 확인 필요
 * 
 * 배열 회전의 시작점을 (i, j)로 정하고, swap
 * 회전 swap 후에는 백업해둔 temp 값을 채운다
 * 내부 회전하는 원 모양이 몇개가 생기는지 Math.min(N, M) / 2; // 반복 횟수
 * 
 * 사각형 좌표 그려서 이동하는 끝 네퉁이를 수식으로 표현해보기
 * (0, 0)						(0, M-1-0)
 * 		(1, 1)				(1, M-1-1)
 * 			(2, 2)		(2, M-1-2)
 * 
 * 			(N-1-2, 2)	(N-1-2, M-1-2)
 * 		(N-1-1, 1)			(N-1-1, M-1-1)
 * (N-1-0,0)					(N-1-0, M-1-0)
 * 
 * 0 <= i < N/2, 0 <= i < M/2
 * 배열 범위 체크가 필요없으므로, 배열 테두리 작업은 필요없음
 * DFS, BFS아님
 * 
 * 삼성역량 테스트 기출문제 중 부분 모듈
 * 
 * 아이디어:
 * 660ms : FM 대로 한칸한칸 쉬프트해서 회전시키기
 * 620ms : 한바퀴의 개수 이상이되면, 반복이되니까, 전체 회전횟 = 전체회전회수 % 한바퀴 개수로 줄여서 회전
 * 330ms : 회전해야할 위치 만큼을 한번에 쉬프트, 행열 좌표체크 번거롭다면, 1차원배열에 글자를 넣고 한번에 쉬프트해서 입력
 * x 어려움 회전해야할 위치 만큼을 한번에 쉬프트, 겹치는 부분을 템프로 저장하기 번거로우니까 별도 배열에 저장
 */

public class Main_BOJ_16926_배열돌리기1_Silver1_others {

	static int N, M, R; // 배열크기 NM, 회전 수 R
	static String[][] map;
	// 좌, 상, 우, 하 방향으로 뒤집어 씌워야하니까 next값은 반대가 되어야함!
	static int[] dr = { 0, 1, 0, -1 }; // 우, 하, 좌, 상 (반시계 방향)
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
				map[i][j] = st.nextToken();
		}
		
		// rotate
		rotate();
		
		// output
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(map[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());

	} // end of main
	
	public static void rotate() {
		int age = Math.min(N, M) / 2; // 나이테
		
		for (int i = 0; i < age; i++) { // 나이테만큼 바깥 테두리부터 안쪽으로 반복
			int cycle = (2*N) + (2*M) -4 - (8*i); // 한바퀴 회전할 원소의 개수
			int minR = R % cycle; // 회전 반복을 줄임, 40ms 감소
			for (int j = 0; j < minR; j++) {
				int r = i, c = i;
				String tmp = map[r][c]; // 시작값 저장 (0,0), (1,1)...
				for (int d = 0; d < dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					while (nr >= i && nc >= i && nr < N - i && nc < M - i) {
						map[r][c] = map[nr][nc];
						r = nr;
						c = nc;
						nr += dr[d];
						nc += dc[d];
					}
				}
				map[i + 1][i] = tmp;
			}
		}
	}
}
