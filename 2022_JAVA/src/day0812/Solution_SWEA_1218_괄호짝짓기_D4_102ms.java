package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_1218_괄호짝짓기_D4_102ms {

	static StringBuilder sb = new StringBuilder();
	static Stack<Character> stack;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");

			// input & initialize
			stack = new Stack<Character>();
			ans = 1;
			int N = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			// going
			for (int i = 0; i < N; i++) {
				char c = arr[i];
				// 여는 괄호를 만나면 stack에 push
				if (c == '(' || c == '[' || c == '{' || c == '<') stack.push(c);
				else { // 닫는 괄호
					if (stack.empty()) {
						ans = 0;
						break;
					} else {
						char b = stack.pop();
						if ((c == ')' && b != '(')
							|| (c == ']' && b != '[')
							|| (c == '}' && b != '{')
							|| (c == '>' && b != '<')) {
							ans = 0;
							break;
						}
					}
				}
			} // end going
			sb.append(ans).append("\n");
		} //end of test case for
		System.out.println(sb.toString());
	}
}
