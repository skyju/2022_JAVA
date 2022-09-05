package day0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_SWEA_1767_프로세서연결하기 {

	static int N, num, minLen, maxCore;
	static ArrayList<Node> coreList;
	static char[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			// 초기화
			num = 0;
			coreList = new ArrayList<>();
			minLen = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;

			// map입력 받기
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					map[i][j] = str.charAt(index);
					if (map[i][j] == '1') {
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1) continue;
						num++;
						coreList.add(new Node(i, j));
					}
				}
			}
			dfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(minLen).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int cnt, int coreCnt, int wireLen) {
		if (cnt == num) {
			if (maxCore < coreCnt) {
				maxCore = coreCnt;
				minLen = wireLen;
			} else if (maxCore == coreCnt && minLen > wireLen) minLen = wireLen;
			return;
		}
		
		int x = coreList.get(cnt).x;
		int y = coreList.get(cnt).y;
		
		for (int d = 0; d < 4; d++) {
			int count = 0;
			int nr = x;
			int nc = y;
			while (true) {
				nr += dr[d];
				nc += dc[d];
				if (isEnd(nr, nc)) break;
				if (map[nr][nc] == '1') {
					count = 0;
					break;
				}
				count++;
			}
			fillMap(x, y, d, count, '1'); // 이 코어 선택했으니 경로 채워 보냄
			if (count == 0) {
				dfs(cnt + 1, coreCnt, wireLen);
			} else {
				dfs(cnt + 1, coreCnt + 1, wireLen + count);
				fillMap(x, y, d, count, '0'); // 경로 되돌림
			}
		}
		
	}

	public static boolean isEnd(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= N) return true;
		else return false;
	}

	public static void fillMap(int x, int y, int d, int count, char flag) {
		int nr = x;
		int nc = y;
		for (int i = 0; i < count; i++) {
			nr += dr[d];
			nc += dc[d];
			map[nr][nc] = flag;
		}
	}
}
