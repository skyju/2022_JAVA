import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_BOJ_13458_시험감독_Bronze2_436ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 시험장의 개수
		int[] map = new int[N]; // 시험장 생성
		
		// 각 시험장에 있는 응시자의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st.nextToken()); // 총감독관이 감시할 수 있는 응시자 수
		int C = Integer.parseInt(st.nextToken()); // 부 감독관이 응시할 수 있는 응시자 수
		
		BigInteger count = new BigInteger("0"); // 100만 x 100만 int(21억 ~)
		// 각 시험장마다 응시생을 모두 감독하기 위해 필요한 감독관의 최소 수
		for (int i = 0; i < N; i++) {
			map[i] -= B;
			count = count.add(BigInteger.ONE);
			if (map[i] > 0) {
				int d = map[i] / C;
				count = count.add(BigInteger.valueOf(d));
				if (map[i] % C > 0) count = count.add(BigInteger.ONE);
			}
		}
		System.out.println(count);
		
	}
}
