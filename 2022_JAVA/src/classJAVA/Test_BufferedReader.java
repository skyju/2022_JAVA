package classJAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test_BufferedReader {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		// 데이터 쪼개기 delim
		// 1. String.split(); -> 오래걸림
		String arr[] = s.split(" ");
		System.out.println(Arrays.toString(arr));
		// 2. StringTokenizer
		StringTokenizer st = new StringTokenizer(s, " ");
		while (st.hasMoreTokens()) {
			System.out.print(st.nextToken() + " ");
		}
	}
}
