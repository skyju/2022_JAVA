package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_12891_DNA비밀번호_Silver2_선생님 {

	static int ans;
//     {'A','C','G','T'};          A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z
    public static int[] index = {0,4,1,4,4,4,2,4,4,4,4,4,4,4,4,4,4,4,4,3,4,4,4,4,4,4}; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 슬라이딩 윈도우
		int S = Integer.parseInt(st.nextToken()); // 원본 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 만들 문자열 길이
		String dnaStr = br.readLine();
		int[] target = new int[4]; // 0A 1C 2G 3T; 갯수저장
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < target.length; i++)
			target[i] = Integer.parseInt(st.nextToken());

		int[] cnt = new int[4];
		for (int i = 0; i < P; i++)
			cnt[index[dnaStr.charAt(i) - 'A']]++;
		if (check(target, cnt)) ans++;
		
		for (int left = 0, right = P; right < S; left++, right++) {
			cnt[index[dnaStr.charAt(left) - 'A']]--;
			cnt[index[dnaStr.charAt(right) - 'A']]++;
			if (check(target, cnt)) ans++;
		}

		System.out.println(ans);
	}

	public static boolean check(int[] target, int[] cnt) {
		for (int i = 0; i < target.length; i++) {
			if (target[i] > cnt[i]) return false;
		}
		return true;
	}
}
