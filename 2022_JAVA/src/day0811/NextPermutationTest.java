package day0811;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest { //nPn
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		sc.close();
		
		// 전처리 : 순열에 쓰일 수들을 오름차순 정렬
		Arrays.sort(input);
		do {
			System.out.println(Arrays.toString(input));
		} while(np(input));
		
	}
	
	// nextPermutation
	// numbers 배열의 상태를 근거로 다음 순열 생성, 다음 순열이 존재하면 true, 아니면 false
	public static boolean np(int[] numbers) { 
		// 1. 꼭대기 찾기
		int N = numbers.length;
		int i = N - 1;
		
		// 맨 뒤쪽부터 보면서 나보다 같거나 크면
		while (i > 0 && numbers[i - 1] >= numbers[i]) --i;
		
		// 0이어서 끝난거면 만들 수 있는 가장 큰 순열을 만든 것이라 끝임
		if (i == 0) return false;
		
		// 2. 꼭대기의 바로 앞자리(i-1)의 값을 크게 만들어야함 교환값 뒤쪽에서 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) --j;
		
		// 3. i - 1의 위치값과 j 위치값 교환
		swap(numbers, i - 1, j);
		
		// 4. i위치부터 맨뒤까지의 수열을 가장 작은 형태의 오름차순으로 변경
		int k = N - 1;
		while (i < k) swap(numbers, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
	
}
