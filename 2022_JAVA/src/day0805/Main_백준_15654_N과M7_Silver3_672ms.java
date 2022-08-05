package day0805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_15654_N과M7_Silver3_672ms {
	
	static int[] numbers;
	static int[] result;
	static int N, M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		//n개의 자연수 중에서 m개를 고른 수열, 고른 수열은 오름차순, 중복o -> 중복순열
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String line = br.readLine();
		N = line.charAt(0) - '0';
		M = line.charAt(2) - '0';
		
		numbers = new int[N];
		result = new int[M];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		
		perm(0);
		System.out.println(sb.toString());
		
	}
	
	public static void perm(int num) {
		if (num == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]);
				if (i != M - 1)
					sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			result[num] = numbers[i];
			perm(num + 1);
		}
	}
}
