package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1233_사칙연산유효성검사_D4_103ms {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int ans = 1;
			int N = Integer.parseInt(br.readLine()); // total node number
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken(); // skip node number
				char node = st.nextToken().charAt(0); // alphabet
				if (st.hasMoreTokens()) { // not leaf node
					if (node >= '0' && node <= '9') {
						ans = 0;
						for (int j = i + 1; j <= N; j++) br.readLine(); // skip other input
						break;
					}
				} else { // leaf node 
					if (node < '0' || node > '9') {
						ans = 0;
						for (int j = i + 1; j <= N; j++) br.readLine();
						break;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

// check
// 1. When it is a leaf node and an operator.
// 2. When not a leaf node and a number.