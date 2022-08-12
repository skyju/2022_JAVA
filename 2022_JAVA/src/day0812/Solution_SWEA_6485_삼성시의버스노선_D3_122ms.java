package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6485_삼성시의버스노선_D3_122ms {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] visit;
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(br.readLine()); //test case number
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			// input & initialize
			int N = Integer.parseInt(br.readLine());
			visit = new int[5001];
			
			// 노선 제한 정보
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				for (int j = A; j <= B; j++)
					visit[j]++;
			}
			
			// 버스정류장 갯수 및 위치
			int P = Integer.parseInt(br.readLine());
			for (int i = 0; i < P; i++) {
				// idx 위치 버스정류장을 지나가는  버스 정보 출력
				int idx = Integer.parseInt(br.readLine());
				sb.append(visit[idx]).append(" ");
			}
			sb.append("\n");
		} // test case for end
		br.close();
		System.out.println(sb.toString());
	} // end of main
} // end of class
