package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_Ladder1_D4_123ms {

	static final int NUM = 100;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			arr = new char[NUM][NUM]; // Map
			for (int i = 0; i < NUM; i++) { // 입력
				String line = br.readLine();
				for (int j = 0, index = 0; j < NUM; j++, index += 2)
					arr[i][j] = line.charAt(index);
			}

			List<Integer> memo = new ArrayList<>(50);
			int idx = -1;

			int r = NUM - 1, c = 0; // 출구 찾아놓기, memo(세로선) 찾기
			for (int i = 0; i < NUM; i++) {
				if (arr[0][i] == '1') {
					memo.add(i);
					if (arr[r][i] == '2') {
						c = i;
						idx = memo.size() - 1;
					}
				}
			}

			while (r != 0) { // 첫번째 행일때가지 탐색
				arr[r][c] = '0'; // 지나온길은 지움
				if (c - 1 >= 0 && arr[r][c - 1] == '1')
					idx--;
				else if (c + 1 < NUM && arr[r][c + 1] == '1')
					idx++;
				c = memo.get(idx);
				r -= 1;
			}
			sb.append("#").append(tc).append(" ").append(c).append("\n");
		}
		System.out.println(sb.toString());
	}
}