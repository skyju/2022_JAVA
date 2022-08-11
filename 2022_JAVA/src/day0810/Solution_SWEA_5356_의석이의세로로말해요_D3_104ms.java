package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_5356_의석이의세로로말해요_D3_104ms {
	
	static char[][] board;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int cMax = 0; 
			
			// 각 테케는 5줄
			String[] tmp = new String[5];
			for (int i = 0; i < 5; i++) {
				String temp = br.readLine();
				tmp[i] = temp;
				if (temp.length() > cMax) cMax = temp.length();
			}
			board = new char[5][cMax];
			for (int i = 0; i < 5; i++) {
				System.arraycopy(tmp[i].toCharArray(), 0, board[i], 0, tmp[i].toCharArray().length);
			}
			
			//세로로 읽어서 붙이기
			for (int j = 0; j < cMax; j++) {
				for (int i = 0; i < 5; i++) {
					if (board[i][j] != 0)
						sb.append(board[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}