package day0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_A형대비_02_헌터_294ms {
	
	// 1. 헌터 몬스터의 수 구하기 및 정보 담아놓기
	// 모든 정보를 체크할 수 있는 class를 만들어 놓고
	// 헌터나 몬스터가 들어올 때마다 list에 add한다.
	// 그럼 list의 사이즈를 기준으로 다시 작업이 편하도록 배열에 옮겨 담아 놓는다.
	
	// 2. 배열을 기준으로 nPn의 순열을 만든다.  
	// 순열이 완성되면 헌팅을 시작해본다.
	
	// 3. 헌팅을 진행하며 아직 몬스터를 잡지 않았는데 집을 들리는 경우는 제외해준다.
	
	static int N, size, min;
	static ArrayList<Node> list;
	static Node[] permResult;
	
	static class Node {
		int x;
		int y;
		boolean isMonster;
		int num;
		Node (int x, int y, boolean isMonster, int num) {
			this.x = x;
			this.y = y;
			this.isMonster = isMonster;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine()); // map size
			min = Integer.MAX_VALUE; // minimum value initialize
			list = new ArrayList<Node>(); // list initialize
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int v = Integer.parseInt(st.nextToken());
					if (v < 0) { // customer
						list.add(new Node(i, j, false, Math.abs(v)));
					} else if (v > 0) { // monster
						list.add(new Node(i, j, true, Math.abs(v)));
					}
				}
			}
			
			size = list.size(); // 몬스터 개수 + 고객 수
			permResult = new Node[size];
			
			perm(0, 0);
			sb.append(min).append("\n");
		} // end of test case
		
		System.out.println(sb.toString());
	
	} // end of main
	
	public static void perm(int cnt, int flag) {
		if (cnt == size) {
			go(permResult);
			return;
		}
		for (int i = 0; i < size; i++) {
			if ((flag & 1 << i) != 0) continue;
			permResult[cnt] = list.get(i);
			perm(cnt + 1, flag | 1 << i);
		}
	}
	
	public static void go(Node[] nodes) {
		boolean[] check = new boolean[(list.size() / 2) + 1]; //몬스터 처치 체크, 0 dummy
		
		int sum = 0;
		Node before = new Node(0, 0, false, 0); // 거리 계산을 위해 헌터의 초기 값 저장
		
		for (int i = 0; i < list.size(); i++) {
			Node now = nodes[i];
			if (now.isMonster) check[now.num] = true;
			else if (!now.isMonster && !check[now.num]) return; // 고객인데 몬스터를 잡은 적 없으면 넘어감, 잘못된 순열
			
			// 이동거리를 구해본다.
			int x = Math.abs(now.x - before.x);
			int y = Math.abs(now.y - before.y);
			sum += (x + y);
			
			before = now;
		}
		if (min > sum ) min = sum;
	}
	
} // end of class