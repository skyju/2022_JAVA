package day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_BOJ_1786_찾기_Platinum5_000ms {
	
	static int cnt = 0;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] src = br.readLine().toCharArray();
		char[] match = br.readLine().toCharArray();
		
		int[] pi = getPi(match);
		System.out.println(Arrays.toString(pi));
		int j = 0;
		for (int i = 0; i < src.length; i++)
			while (j > 0 && src[i] != match[j]) {
				j = pi[j - 1];
			if (src[i] == match[j]) {
				if (j == match.length - 1) {
					++cnt;
					list.add(i - j + 1);
					j = pi[j];
				} else j++;
			}
		}
		
		System.out.println(cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.print(list.get(i));
		}
	}
	
	static int[] getPi(char[] match) {
		int[] pi = new int[match.length];
		int j = 0;
		for (int i = 1; i < match.length; i++) {
			while (j > 0 && match[i] != match[j]) {
				j = pi[j - 1];
			}
			if (match[i] == match[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}
