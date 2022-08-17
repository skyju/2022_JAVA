import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1074_Z_Silver1_others {
	static int r, c, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 15
		r = Integer.parseInt(st.nextToken()); // 0 <= r,c < 2^N
		c = Integer.parseInt(st.nextToken());

//		for (int i = 0; i < N; i++) {
////			ans += (r % 2 * 2 + c % 2) * Math.pow(4, i);
////			r /= 2;
////			c /= 2;
//
//			ans += (r & 1) << 1 + (c & 1) << (2 * i);
//			r >>= 1;
//			c >>= 1;
//			
//			if (r == 0 && c == 0) break;
//		}
		
		for (int i = N - 1; i >= 0; i--) {
			ans <<= 2; // 자리수 올리기
			ans |= ((r & (1 << i)) != 0 ? 1 : 0) << 1 | ((c & (1 << i)) != 0 ? 1 : 0);
		}
		System.out.println(ans);
	}
}