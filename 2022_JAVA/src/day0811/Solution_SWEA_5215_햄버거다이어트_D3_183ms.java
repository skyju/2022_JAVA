package day0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Burger {
	int score;
	int kcal;
	public Burger() {
	}
	public Burger(int score, int kcal) {
		this.score = score;
		this.kcal = kcal;
	}
}

public class Solution_SWEA_5215_햄버거다이어트_D3_183ms {
	// 비슷한 문제 : 여행경비가 정해져있을 때 여행경비를 넘지 않으면서 최대 만족도를 갖도록 선택하려면??
	
	static int ingredientN, kcalL;
	static Burger[] burgers;
	static int maxScore;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ingredientN = Integer.parseInt(st.nextToken()); // 재료 수
			kcalL = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			// 햄버거 정보를 burger 배열에 입력
			burgers = new Burger[ingredientN];
			for (int i = 0; i < ingredientN; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				burgers[i] = new Burger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// 제한 칼로리 이하에서 맛점수가 가장 높은 점수 구하기
			maxScore = 0;
			subset(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(maxScore).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void subset(int i, int totalScore, int totalKcal) {
		if (totalKcal > kcalL) return; // 제한 칼로리 초과
 		if (i == ingredientN) { // 선택 완료
 			maxScore = Math.max(maxScore, totalScore);
 			return;
 		}
		subset(i + 1, totalScore + burgers[i].score, totalKcal + burgers[i].kcal);
		subset(i + 1, totalScore, totalKcal);
	}
}
