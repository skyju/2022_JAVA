import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플_D3_000ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			// N개의 Card를 deck에 넣어놓기
			int N = Integer.parseInt(br.readLine());
			String[] deck = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				deck[i] = st.nextToken();

			int front = 0;
			if (N % 2 == 0)
				front = N / 2;
			else
				front = (N / 2) + 1;

			int index = 0;
			for (int i = 0; i < front; i++) {
				if (index % 2 == 0) {
					sb.append(deck[i]).append(" ");
					index++;
				} else {
					sb.append(deck[i + front]).append(" ");
					index++;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
