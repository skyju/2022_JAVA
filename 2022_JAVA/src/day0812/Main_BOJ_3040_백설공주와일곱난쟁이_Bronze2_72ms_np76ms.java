package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_3040_백설공주와일곱난쟁이_Bronze2_72ms_np76ms {
	
	static StringBuilder sb = new StringBuilder();
	static int[] nanjang; // 9명 받는 원본 배열
	static int[] numbers; // 7명 뽑아보는 배열
	static int[] ans; // sum 100을 충족하는 배열

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		nanjang = new int[9];
		numbers = new int[7];
		ans = new int[7];
		for (int i = 0; i < 9; i++) // 9명의 난장이 입력받음
			nanjang[i] = Integer.parseInt(br.readLine());
		
		// 조합을 담을 같은 크기의 배열 생성, 뽑을 갯수만큼을 0아닌 수로 채움
		int[] combi = {0, 0, 1, 1, 1, 1, 1, 1, 1};
		boolean flag = true;
		do {
			int sum = 0;
			for (int i = 0; i < combi.length; i++)
				if (combi[i] == 1) sum += nanjang[i];
			if (sum == 100) {
				for (int i = 0; i < combi.length; i++)
					if (combi[i] == 1) sb.append(nanjang[i]).append("\n");
				flag = false;
			}
		} while(np(combi) && flag);
		
		System.out.println(sb.toString());
	} // end of main
	
	
	public static boolean np(int[] numbers) {
		int N = numbers.length;
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) i--;
		if (i == 0) return false;
		
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) j--;
		swap(numbers, i - 1, j);
		
		int k = N - 1;
		while (i < k) swap(numbers, i++, k--);
		return true;
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public static void comb(int cnt, int start, int sum) {
		if (cnt == 7) {
			if (sum == 100) {
				for (int v : numbers)
					sb.append(v).append("\n");
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			numbers[cnt] = nanjang[i];
			comb(cnt + 1, i + 1, sum + nanjang[i]);
		}
	} // end of comb
	
} // end of class