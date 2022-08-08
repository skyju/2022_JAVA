package day0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1158_요세푸스문제_Silver4_644ms {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		br.close();
		
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) list.add(i);
		
		sb.append("<");
		while(list.size() > 0) {
			for (int i = 0; i < K - 1; i++) {
				list.add(list.remove(0)); //앞에꺼를 뽑아서 뒤에다가 집어넣음
			}
			sb.append(list.remove(0));
			if (list.size() >= 1) sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}
