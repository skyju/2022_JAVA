package day0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_A형대비_03_Shuffle_O_Matic_842ms {
	
	// 필요한 로직 정리
	// 1. x에 따른 shuffle 기능 :
	//	왼쪽(N - 2)에서 x만큼 뺀만큼 일단 덱에 넣고
	//	왼쪽 꺼가 다 떨어질때까지 오른쪽 꺼와 번갈아 섞다가 (오른쪽이 먼저 들어가야 함)
	//	오른쪽도 남았으면 오른쪽을 털어넣음
		
	// 2. DFS : 
	//	x가 [0] ~ [N/2-1] 일때와  [N/2] ~ [N-1]까지의 셔플 상태를 보면
	// 뒤집으면 같은 패턴으로 진행된다는 걸 찾을 수 있다.
	// 이를 통해 deck을 나누어 넣으면서 DFS를 하되, x의 값에 따라 왼쪽과 오른쪽을 바꾸어 넣어준다.
	
	static int N, min;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine()); // 카드의 개수 N
			min = Integer.MAX_VALUE;
			int[] deck = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				deck[i] = Integer.parseInt(st.nextToken());
			
			dfs(0, deck);
			if (min == Integer.MAX_VALUE) min = -1;
			sb.append(min).append("\n");
		} // end of test case

		System.out.println(sb.toString());

	} // end of main

	public static void dfs(int dep, int[] cards) {
		if (dep > 5) return;
		if (dep >= min) return;
		if (isSorted(cards)) { // 정렬된 상태
			min = Math.min(min, dep);
			return;
		}
		
		// 셔플을 위해 카드 나누기
		int[] left = new int[N/2];
		int[] right = new int[N/2];
		
		for (int i = 0; i < N/2; i++)
			left[i] = cards[i];
		for (int i = N/2; i < N; i++)
			right[i - N/2] = cards[i];
		
		// x 가 [0] ~ [N/2-1] 일때와  [N/2] ~ [N-1]까지의 셔플 상태를 보면
		// 뒤집으면 같은 패턴으로 진행된다는 걸 찾을 수 있다.
		for (int x = 1; x < N; x++) {
			int[] next = x < N / 2 ? shuffle(x, left, right) : shuffle(x - N / 2, right, left);
			dfs(dep + 1, next);
		}
	}

	public static int[] shuffle(int x, int[] left, int[] right) {
		int[] ans = new int[N];
		int idx = 0;
		int leftIdx = 0;
		int rightIdx = 0;
		
		// 왼쪽 카드 먼저 배치
		while (leftIdx < N / 2 - x)
			ans[idx++] = left[leftIdx++];
		
		// 중간 섞기
		int order = 0; //짝, 홀로 , 오른쪽 먼저!(그러니까 짝이 오른쪽)
		while (leftIdx < N / 2 && rightIdx < N / 2) {
			ans[idx++] = order % 2 == 0 ? right[rightIdx++] : left[leftIdx++];
			order++;
		}
		
		// 남은 오른쪽 카드 털어 넣기
		while (rightIdx < N / 2)
			ans[idx++] = right[rightIdx++];
		return ans;
	}

	public static boolean isSorted(int[] arr) {
		boolean asc_chk = true;
		boolean dsc_chk = true;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] > arr[j]) asc_chk = false;
				if (arr[i] < arr[j]) dsc_chk = false;
			}
		}
		if (asc_chk || dsc_chk) return true;
		else return false;
	}

} // end of class
