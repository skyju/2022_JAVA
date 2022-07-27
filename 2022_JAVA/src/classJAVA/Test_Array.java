package classJAVA;

public class Test_Array {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++)
				System.out.printf("%02d ", arr[i][j]);
			System.out.println();
		}
//
//		// 향상된 for, 속도가 조금 더 빠름
//		for (int[] row : arr) {
//			for (int num : row)
//				System.out.printf("%02d ", num);
//			System.out.println();
//		}
//
//		// 역순출력
//		for (int i = arr.length - 1; i >= 0; i--) {
//			for (int j = arr[i].length - 1; j >= 0; j--)
//				System.out.printf("%02d ", arr[i][j]);
//			System.out.println();
//		}

//		// 상하 좌우의 값의 합 출력
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				int sum = 0;
//				if (i != 0)
//					sum += arr[i - 1][j];
//				if (i != arr.length - 1)
//					sum += arr[i + 1][j];
//				if (j != 0)
//					sum += arr[i][j - 1];
//				if (j != arr[i].length - 1)
//					sum += arr[i][j + 1];
//				System.out.printf("%2d ", sum);
//			}
//			System.out.println();
//		}

		// refactor : alt shift r
		int[] dr = { -1, 1, 0, 0 }; // 상하좌우
		int[] dc = { 0, 0, -1, 1 }; // 상하좌우

		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				int sum = 0;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[r].length)
						sum += arr[nr][nc];
				}
				System.out.printf("%2d ", sum);

			}
			System.out.println();
		}

		// 배열의 크기가 커지면, 테두리만 검사하는 방식이 더 빠름, 단 메모리 확보 문제
		// 테두리에 0을 넣을거임
		// 원본 배열 카피는 System.arraycopy가 제일 빠르다.
		// 알고리즘 문제일때는 카피하지말구 입력받을때 여기에 넣으면됨.
		int[][] brr = new int[arr.length + 2][arr[0].length + 2];
		for (int i = 0; i < arr.length; i++)
			System.arraycopy(arr[i], 0, brr[i + 1], 1, arr[i].length);

		for (int r = 1; r <= arr.length; r++) {
			for (int c = 1; c <= arr[r - 1].length; c++) {
				int sum = 0;
				for (int d = 0; d < dc.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					sum += brr[nr][nc];
				}
				System.out.printf("%2d ", sum);

			}
			System.out.println();
		}

		// X로 표시된 항목의 상하좌우 숫자의 합을구하는 코드를 작성하시오.
		// 단, 합을 구할 때, 이미 사용된 숫자는 다시 사용하지 않음.
		int[][] crr = { { 2, 3, 1, 4 }, { 1, 'X', 3, 2 }, { 3, 4, 'X', 'X' }, { 'X', 4, 1, 5 } };
		int sum = 0;
		for (int r = 0; r < crr.length; r++) {
			for (int c = 0; c < crr[r].length; c++) {
				if (crr[r][c] == 'X') {
					for (int d = 0; d < dr.length; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr >= 0 && nc >= 0 && nr < crr.length && nc < crr[r].length && crr[nr][nc] != 'X') {
							sum += crr[nr][nc];
							crr[nr][nc] = 0;
						}
					}
				}
			}
		}
		System.out.println(sum);
	}

}
