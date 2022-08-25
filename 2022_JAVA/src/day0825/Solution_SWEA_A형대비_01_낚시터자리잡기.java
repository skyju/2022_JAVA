package day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_A형대비_01_낚시터자리잡기 {
	
	static int N, min;
	static int[] gateInput, gate;
	static int[] input;
	static boolean[] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 3P3 순열을 시행 (게이트 입장 순서)
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine()); //낚시터의 개수
			gateInput = new int[3];
			gate = new int[3];
			input = new int[N + 1]; //0 dummy
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int loc = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				gateInput[i] = loc; // 순열용
				input[loc] = num;
			}
			perm(0, 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void perm(int flag, int cnt) {
		if (cnt == 3) {
			// 하나의 순열 완성
			map = new boolean[N + 1];
			go();
			return;
		}
		for (int i = 0; i < 3; i++) {
			if ((flag & 1 << i) != 0) continue;
			gate[cnt] = gateInput[i];
			perm(flag | 1 << i, cnt + 1);
		}
	}
	
	// 낚시터에 자리가 부족할 일은 없다.
	public static void go() {
		int sum = 0; 
		for (int i = 0; i < 3; i++) {
			int nowGate = gate[i]; // 입장할 게이트 번호
			int num = input[nowGate]; // 해당 게이트에서 기다리고 있는 사람의 수
			int dist = 0;
			while(num > 0) {
				if (i != 2 && num == 1 && ((nowGate - dist >= 1 && !map[nowGate - dist])
						&& (nowGate + dist <= N && !map[nowGate + dist]))) {
						// 마지막 게이트가 아니고, 맨 마지막 사람이고, 가장 가까운 빈 자리가 두 곳이라면 선택 해야함
						// 다음 게이트가 더 뒤에 나오면 
						if (nowGate < gate[i + 1]) map[nowGate - dist] = true;
						else map[nowGate + dist] = true;
						sum += dist + 1;
						num--;
				} else {
					if (nowGate - dist >= 1 && !map[nowGate - dist]) { // 앞자리
						map[nowGate - dist] = true;
						sum += dist + 1;
						num--;
						continue;
					} else if (nowGate + dist <= N && !map[nowGate + dist]) { // 뒷자리
						map[nowGate + dist] = true;
						sum += dist + 1;
						num--;
						continue;
					}
				}
				dist++;
			}
		}
		if (min > sum) min = sum;
	}
}
