package day0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1541_잃어버린괄호_Silver2_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		String first = st.nextToken();
		
		int firstN = 0;
		StringTokenizer st2 = new StringTokenizer(first, "+");
		while (st2.hasMoreTokens()) firstN += Integer.parseInt(st2.nextToken());
		
		int n = 0;
		while (st.hasMoreTokens()) {
			st2 = new StringTokenizer(st.nextToken(), "+");
			while (st2.hasMoreTokens())	n += Integer.parseInt(st2.nextToken());
		}
		// 처음나오는 - 뒤의 숫자를 전부다 더해서 첫 덩어리에서 빼주면됨..
		System.out.println(firstN - n);
	}
}