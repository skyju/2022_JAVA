package day0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1592_영식이와친구들_Bronze2_96ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// 원형으로 시계방향으로 1 ~ N까지 앉음
		// 1번사람이 공을 받아 던지기 시작
		// 한 사람이 M번 공을 받았으면 게임 끝 (지금 받은 공도 포함)
		// M번보다 적게 공을 받은 사람이 공을 받을 때,
		// 자기가 받은 공의 횟수가 홀수번이면 자기의 현재 위치에서 시계방향으로 L번째에 있는 사람에게
		// 짝수번이면 자기의 현재 위치에서 반시계방향으로 L번재 있는 사람에게 공을 던진다.
		
		int[] play = new int[N + 1];
		
		int cnt = 0;
		int nowPlayer = 0;
		play[0]++; // 1번이 한번 잡는다.
		while (true) {
			if (play[nowPlayer] == M) break;
			int next;
			if (play[nowPlayer] % 2 != 0) { // 홀수
				next = nowPlayer + L;
				if (next >= N) next -= N;
				play[next]++;
			} else { // 짝수번
				next = nowPlayer - L;
				if (next < 0) next += N;
				play[next]++;
			}
			nowPlayer = next;
			++cnt;
		}
		System.out.println(cnt);
	}
}
