package day0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_A형대비_01_낚시터자리잡기_102ms {
	
	// 1. 낚시터 입장 순서를 순열로 돌리기 (3P3 밖에 안돼요)
	// 2. int[] input에는 어떤 게이트에 몇명의 낚시꾼이 기다리고 있는지 저장
	// 3. 만들어진 순열의 순서대로 게이트를 오픈해서 낚시꾼을 입장시켜본다.
	//		이때, boolean[] map으로 해당 자리에 낚시꾼이 이미 들어가 있는지 체크
	// 4. 해당 게이트에 마지막 사람이 아니라면 앞 뒤 상관없이 게이트에 가까운 곳부터 집어 넣음
	//		이때 distance를 올리는 것을 주의
	// 5. 해당 게이트가 마지막 게이트가 아니면서 (마지막 게이트면 어따 집어넣든 상관없음)
	//	해당 게이트의 마지막 사람이고, 가장 가까운 자리가 두자리라면 예외 처리를 해야 한다.
	
	//	이 경우에 다음 순번 게이트가 지금 게이트보다 뒷자리에 있다면 둘 중 앞자리에 사람을 넣고, 반대면 반대로 행한다.
	//	만약 다음 게이트가 한참 뒤에 있었고, 지금 앞에 넣은 것이 그 다음 게이트에 영향을 주게 된다면,
	//	다른 순열로 돌아가면서 잡히니까 greedy하게 처리해보았다.
	
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