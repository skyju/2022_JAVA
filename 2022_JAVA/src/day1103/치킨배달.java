import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static int chickenHNum, houseNum; // 총 치킨집의 개수, 총 집의 개수
	static List<Node> chickenList; // 치킨 집 리스트
	static List<Node> houseList; // 집 리스트
	
	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static Node[] selected; // 고른 M개의 치킨집 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 초기화
		chickenHNum = 0;
		houseNum = 0;
		chickenList = new ArrayList<>();
		houseList = new ArrayList<>();
		selected = new Node[M];
		result = Integer.MAX_VALUE;
		
		// '0':빈칸 / '1':집 / '2':치킨집
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				char tmp = st.nextToken().charAt(0);
				if(tmp == '2') {
					chickenHNum++;
					chickenList.add(new Node(i, j));
				} else if (tmp == '1') {
					houseNum++;
					houseList.add(new Node(i, j));
				}
			}
		}
		
		combi(0, 0);
		System.out.println(result);
	}
	
	public static void combi(int cnt, int start) {
		if (cnt == M) { // M개의 치킨집을 다 뽑았으면
			// 모든 집에서 가장 가까운 치킨집의 거리를 찾아서 더해요
			int distSum = 0;
			for (int i = 0; i < houseNum; i++) { // 모든 집에 대하여
				Node house = houseList.get(i);
				int minDist = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) { // 모든 치킨집에 대하여
					Node chicken = selected[j];
					int dist = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
					minDist = Math.min(minDist, dist);
				}
				distSum += minDist;
			}
			result = Math.min(distSum, result);
			return;
		}
		
		for (int i = start; i < chickenHNum; i++) {
			selected[cnt] = chickenList.get(i);
			combi(cnt + 1, i + 1);
		}
	}
}
