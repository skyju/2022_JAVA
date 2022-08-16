package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSet_BinaryCountingTest {
	static int[] numbers;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		generateSubset();
	}

	private static void generateSubset() {
		// 2의 N승까지 확인 .. 쉬프트 연산 이용
		for (int flag = 0, caseCnt = 1 << N; flag < caseCnt; flag++) {
			// 현 비트열의 상태에 대하여 각 원소의 부분집한에 포함 유/무 확인
			for (int i = 0; i < N; i++) {
				if ((flag & (1 << i)) != 0) // i원소가 부분집합에 포함
					System.out.print(numbers[i] + " ");
			}
			System.out.println();
		}
	}
}
