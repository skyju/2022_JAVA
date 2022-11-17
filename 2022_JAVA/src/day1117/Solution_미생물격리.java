package day1117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, K;
	static List<Data> list;

	// 0은 더미 상 하 좌 우
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	static class Data implements Comparable<Data> {
		int r, c, num, d;

		Data(int r, int c, int num, int d) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.d = d;
		}

		@Override
		public int compareTo(Data o) {
			return o.num - this.num;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 셀의 개수, 정사각형
			M = Integer.parseInt(st.nextToken()); // 격리 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수

			list = new ArrayList<>();
			// 미생물 군집의 정보
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				// 세로 위치 먼저 주어짐
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list.add(new Data(r, c, num, d));
			}

			// M시간 동안 이동 진행
			for (int time = 0; time < M; time++) {
								
				// 이동 진행
				for (int i = 0; i < list.size(); i++) {
					Data now = list.get(i);
					now.r += dr[now.d];
					now.c += dc[now.d];

					// 미생물이 이동 후 약품이 칠해진 셀에 도착했다면
					if (now.r == 0 || now.c == 0 || now.r == N - 1 || now.c == N - 1) {
						now.num /= 2; // 미생물의 절반이 죽음
						// 0이 되면 군집 사라짐
						if (now.num == 0) {
							list.remove(i);
							i--; // 다시 제자리로 돌아가야지
							continue;
						}
						// 방향이 반대로 바뀜
						switch (now.d) {
						case 1: now.d = 2; break;
						case 2: now.d = 1; break;
						case 3: now.d = 4; break;
						case 4: now.d = 3; break;
						}
					}
				}
				
				// 미생물 개수 순으로 내림차순 정렬 해줌
				Collections.sort(list);
				
				// 두 개 이상의 군집이 한 셀의 모이는 경우 합쳐진다!
				// 세 개 이상이 합쳐지는 경우를 고려해야 함 ㅠㅠ..
				for (int i = 0; i < list.size(); i++) {
					for (int j = list.size() - 1; j > i ; j--) {
						if (list.get(i).r == list.get(j).r && list.get(i).c == list.get(j).c) {
							list.get(i).num += list.get(j).num;
							list.remove(j);
						}
					}
				}
				
			} // 시간 반복문 끝

			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i).num;
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}

}
