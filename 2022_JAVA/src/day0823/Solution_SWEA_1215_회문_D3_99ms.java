package day0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1215_회문_D3_99ms {

	static final int size = 8;
	static int len, ans;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			len = Integer.parseInt(br.readLine()); // 찾아야하는 회문의 길이
			ans = 0;

			map = new char[size][size];
			for (int i = 0; i < size; i++)
				map[i] = br.readLine().toCharArray();

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (j + len <= size) search1(i, j);
					if (i + len <= size) search2(i, j);
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		} // test case for문 종료

		System.out.println(sb.toString());

	} // main method 종료

	public static void search1(int r, int c) {
		String str = "";
		for (int i = 0; i < len; i++) {
			str += map[r][c + i];
		}
		if (palindrome(str)) {
			ans++;
		}
	}

	public static void search2(int r, int c) {
		String str = "";
		for (int i = 0; i < len; i++) {
			str += map[r + i][c];
		}
		if (palindrome(str)) {
			ans++;
		}
	}


	// 회문검사
	public static boolean palindrome(String str) {
		int strLen = str.length();
		for (int i = 0; i < strLen / 2; i++) {
			if (str.charAt(i) != str.charAt(strLen - 1 - i))
				return false;
		}
		return true;
	}
} // class 종료
