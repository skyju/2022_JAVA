package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플_D3_151ms {

	static List<String> strArr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // total card number.
			strArr = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				strArr.add(st.nextToken());
			
			int target = 0;
			if (N % 2 == 0) target = N / 2;
			else target = N / 2 + 1;
			for (int index = 1; target < N; target++, index += 2)
				strArr.add(index, strArr.remove(target));
			sb.append("#").append(tc).append(" ");
			for (String s : strArr)
				sb.append(s).append(" ");
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
