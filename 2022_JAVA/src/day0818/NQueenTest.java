package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueenTest {
	static int N, cols[], ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 각 행의 퀸이 놓아진 열의 위치를 1차열 배열에 저장한다!
		cols = new int[N + 1]; // 1행부터 사용
		ans = 0;
		
		setQueen(1);
		System.out.println(ans);
	}
	
	public static void setQueen(int rowNum) { // 하나의 퀸만 가능한 모든 곳에 놓아보기
		// 직전까지의 상황이 유망하지 않으면 현재 퀸 놓을 필요 없으니 백 트랙!
		if (!isPromissing(rowNum - 1)) { 
			return;
		}
		
		if (rowNum > N) { // N퀸 완성
			++ans;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			cols[rowNum] = i; // 퀸 놓고
			setQueen(rowNum + 1); // 다음퀸 놓으러 갑니다.
		}
	}

	private static boolean isPromissing(int rowNum) {
		// 직전애들을 다 비교함
		for (int i = 1; i < rowNum; i++) {
			// 열값은 같을 수가 없으니 pass,
			if (cols[i] == cols[rowNum] || // 행값이 같은지 체크
				rowNum - i == Math.abs(cols[rowNum] - cols[i])) // 대각이 같은지 체크
				return false;
		}
		return true;
	}
}
