package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7964_부먹왕국의차원관문_D3_243ms {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 부먹왕국 도시 수
			int D = Integer.parseInt(st.nextToken()); // 이동거리 제한
			char[] city = new char[N];
			int ans = 0; // 정답

			// 지도 정보
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				city[i] = st.nextToken().charAt(0);
			}
			
			// 값 찾기 (우 탐색하면 됨) D만큼 탐색
			for (int i = 0; i < city.length; i++) {
				int d, idx;
				if (city[i] == '0') {
					// 거리 D만큼 보면서 지나가는 왕국들이 계속 0이면 끝에 관문을 설치
					for (d = D, idx = 0; d > 0 && city[i + idx] == '0'; d--, idx++) {
						if (d == 1) {
							city[i + idx] = '1';
							ans++;
							i += D - 1;
						}
					}
				}
			}
			sb.append(ans).append("\n");

		} // test case for end
		br.close();
		System.out.println(sb.toString());
	}

}
