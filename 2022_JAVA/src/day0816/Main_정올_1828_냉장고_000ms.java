package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정올_1828_냉장고_000ms {
	
	static class Chamical implements Comparable<Chamical>{
		int minTemp;
		int maxTemp;
		
		public Chamical(int minTemp, int maxTemp) {
			this.minTemp = minTemp;
			this.maxTemp = maxTemp;
		}
		
		// 최고온도 오름차순으로 정렬하고 같다면 최저온도 오름차순으로 정렬
		@Override
		public int compareTo(Chamical o) {
			return this.maxTemp == o.maxTemp ? this.minTemp - o.minTemp : this.maxTemp - o.maxTemp;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/**
		 * 그리디 탐욕기법
		 * n개의 화학물질 c1 ~ cn
		 * 각 물질마다 최저 보관온도, 최고 보관 온도 정해져있음
		 * 이 화학물질을 모두 보관하기 위해 가장 적은 수의 냉장고 사용
		 * 
		 * 4
		 * -15 5
		 * -10 36
		 * 10 73
		 * 27 44
		 * 
		 * 정렬 하면
		 * -15 5
		 * -10 36
		 * 27 44
		 * 10 73
		 * 
		 * 우선 첫번째거 최고기온으로 하나 가동
		 */
		
		// input
		int N = Integer.parseInt(br.readLine()); // 화학물질 수 (1 ~ 100)
		Chamical[] chamicals = new Chamical[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int minTemp = Integer.parseInt(st.nextToken());
			int maxTemp = Integer.parseInt(st.nextToken());
			chamicals[i] = new Chamical(minTemp, maxTemp);
		}
		
		List<Chamical> list = new ArrayList<>();
		Arrays.sort(chamicals);
		// 첫값 주입 (냉장고 개수)
		list.add(chamicals[0]);
		
		for (int i = 1, idx = 0; i < N; i++) {
			if (list.get(idx).maxTemp < chamicals[i].minTemp) {
				list.add(chamicals[i]);
				idx++;
			}
		}
		
		System.out.println(list.size());
	}
	
}