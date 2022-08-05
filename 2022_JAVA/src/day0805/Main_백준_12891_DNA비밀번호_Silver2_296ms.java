package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_12891_DNA비밀번호_Silver2_296ms {

	static int cnt;
	static int[] acgt = new int[100];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 슬라이딩 윈도우
		int S = Integer.parseInt(st.nextToken()); // 원본 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 만들 문자열 길이
		String dnaStr = br.readLine();
		int[] target = new int[4];

		st = new StringTokenizer(br.readLine(), " ");
		int sumtmp = 0;
		for (int i = 0; i < target.length; i++) {
			target[i] = Integer.parseInt(st.nextToken());
			sumtmp += target[i];
		}
		
		// 그냥 간단한 분기
		if (sumtmp > P || S < P) {
			System.out.println(0);
			System.exit(0);
		}

		for (int i = 0; i < P; i++) acgt[dnaStr.charAt(i)]++;
		if (target[0] <= acgt['A'] && target[1] <= acgt['C']
			&& target[2] <= acgt['G'] && target[3] <= acgt['T']) cnt++;

		int tmp = 1;
		while (tmp < S - P + 1) {
			acgt[dnaStr.charAt(tmp - 1)]--;
			acgt[dnaStr.charAt(tmp + P - 1)]++;
			if (target[0] <= acgt['A'] && target[1] <= acgt['C']
					&& target[2] <= acgt['G'] && target[3] <= acgt['T']) cnt++;
			tmp++;
		}

		System.out.println(cnt);
	}
}
