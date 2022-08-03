import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1493수의새로운연산_D3_000ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			// 좌표 구하기
			int[] p_place = getGraph(p);
			int[] q_place = getGraph(q);

			// 좌표 끼리 연산
			int[] new_place = { p_place[0] + q_place[0], p_place[1] + q_place[1] };
			
			System.out.printf("#%d %d\n", tc, getValue(new_place));
		}
	}

	// 좌표 구하기
	public static int[] getGraph(int value) {
		int count = 1;
		for (int i = 1;; i++) { // i는 세로선(\) 안의 value 갯수
			for (int x = 1, y = i; x <= i; x++, y--) { //x는 1부터 시작해야하고, i범위 안에서 y는 줄어들어야함
				if (value == count)
					return new int[] { x, y };
				count++;
			}
		}
	}

	// 값 구하기
	public static int getValue(int[] graph) {
		int count = 1;
		for (int i = 1;; i++) {
			for (int x = 1, y = i; x <= i; x++, y--) {
				if (x == graph[0] && y == graph[1])
					return count;
				count++;
			}
		}
	}
	
}
