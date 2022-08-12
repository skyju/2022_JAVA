package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7964_부먹왕국의차원관문_D3_000ms {

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
			char[] city = new char[N + 2];
			int ans = 0; // 정답
			
			// 지도 정보
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				city[i] = st.nextToken().charAt(0);
			}
			
			// 0번과 N위치에 차원 관문 놓기
			if (city[0] != '1') {
				ans++;
				city[0] = '1';
			}
			if (city[N - 1] != '1') {
				ans++;
				city[N - 1] = '1';
			}
			
			// 값 찾기 (좌우 탐색하면 됨)
			// 1이 원래 차원관문, 2가 커버라고 하면 전부 커버하고 남은 0을 세면 됨
			// D - 1만큼 커버가능
			for (int i = 0; i < city.length; i++) {
				if (city[i] == '1') { // 커버해주러 가야지!
					int tmp = D - 1;
					while (tmp > 0) {
					if (i - tmp > 0 && city[i - tmp] == '0') city[i - tmp] = '2';
					if (i + tmp < N && city[i + tmp] == '0') city[i + tmp] = '2';
					tmp--;
					}
				}
			}
			for (int i = 0; i < city.length; i++)
				if (city[i] == '0') ans++;
			sb.append(ans).append("\n");
		
		} // test case for end
		br.close();
		System.out.println(sb.toString());
	}
	
}
