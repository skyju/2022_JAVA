package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최소 한개의 모음 (a,e,i,o,u), 최소 두개의 자음, 아스키코드 순으로 정렬
public class Main_BOJ_1759_암호만들기_Gold5_80ms {

	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static char[] ori;
	static char[] res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken()); // 완성될 암호 문자열 크기
		C = Integer.parseInt(st.nextToken()); // 후보 알파벳 개수

		ori = new char[C];
		res = new char[L];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++)
			ori[i] = st.nextToken().charAt(0);
		// 알파벳 순이므로 정렬
		Arrays.sort(ori);
		combi(0, 0, 0, 0);
		System.out.println(sb.toString());
	}

	public static void combi(int cnt, int start, int moum, int zaum) {
		if (cnt == L) { // L개 선택 완료
			if (moum < 1 || zaum < 2)
				return;
			for (int i = 0; i < L; i++)
				sb.append(res[i]);
			sb.append("\n");
			return;
		}

		for (int i = start; i < C; i++) {
			res[cnt] = ori[i];
			if (ori[i] == 'a' || ori[i] == 'e' || ori[i] == 'i' || ori[i] == 'o' || ori[i] == 'u')
				combi(cnt + 1, i + 1, moum + 1, zaum);
			else
				combi(cnt + 1, i + 1, moum, zaum + 1);
		}
	}
}
