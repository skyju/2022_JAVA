package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_SWEA_1228_암호문1_D3_103ms {
	static LinkedList<String> list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			list = new LinkedList<String>();

			int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이

			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 원본 암호문
			for (int i = 0; i < N; i++) list.add(st.nextToken()); // 원본 암호문 입력
			int n = Integer.parseInt(br.readLine()); // 명령어의 개수
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) { // 명령수행
				st.nextToken(); // |
				int index = Integer.parseInt(st.nextToken()); // 넣을 인덱스
				int num = Integer.parseInt(st.nextToken()); // 넣을 숫자
				for (int j = 0; j < num; j++) list.add(index++, st.nextToken());
			}
			sb.append("#").append(tc).append(" ");
			int count = 0;
			for (String s : list) {
				sb.append(s).append(" ");
				++count;
				if (count == 10) break;
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}
}
