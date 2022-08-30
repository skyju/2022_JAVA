package day0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_게리맨더링_Gold4_96ms {

	static ArrayList<Integer>[] edge; // 인접리스트
	static int[] map;
	static boolean[] isAreaA;
	static int N, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 구역의 갯수 N
		map = new int[N + 1]; // 각 구역의 인구를 담을 map
		edge = new ArrayList[N + 1];
		isAreaA = new boolean[N + 1]; // subset결과를 담을 것
		min = Integer.MAX_VALUE;
		

		// 인접 리스트 초기화, 및 각 구역의 인구 input 담기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			edge[i] = new ArrayList<Integer>();
		}

		// edge 정보 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()); // 해당 구역과 인접한 구역 수
			for (int j = 0; j < num; j++) {
				edge[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		subset(1, 0, 0);
		if (min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}

	// true - a지역 / false - b 지역
	public static void subset(int cnt, int aSum, int bSum) {
		if (cnt == N + 1) { // 일단 지역 나누어서 다 뽑았음
			// 각 선거구에 포함된 구역이 모두 연결되어있는지 확인한다.
			if (check()) {
				int nowMin = Math.abs(aSum - bSum);
				if (min > nowMin) min = nowMin;
			}
			return;
		}
		isAreaA[cnt] = true;
		subset(cnt + 1, aSum + map[cnt], bSum);
		isAreaA[cnt] = false;
		subset(cnt + 1, aSum, bSum + map[cnt]);
	}

	public static boolean check() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N + 1];
		
		// 각 선거구 구역에 포함된 한 구역 찾기
		int A = -1, B = -1;
		for (int i = 1; i <= N; i++) {
			if (isAreaA[i]) {
				A = i;
			} else {
				B = i;
			}
		}
		// 한 구역에라도 속한 선거구가 없다면
		if (A == -1 || B == -1) return false;

		// 각 구역 확인
		queue.offer(A);
		visit[A] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < edge[cur].size(); i++) {
				int next = edge[cur].get(i);
				if (visit[next] || !isAreaA[next]) continue;
					visit[next] = true;
					queue.offer(next);
			}
		}
		queue.add(B);
		visit[B] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < edge[cur].size(); i++) {
				int next = edge[cur].get(i);
				if (visit[next] || isAreaA[next]) continue;
					visit[next] = true;
					queue.offer(next);
			}
		}
		
		// 한 곳이라도 연결되지 않았다면
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) return false;
		}
		
		return true;
	}
}
