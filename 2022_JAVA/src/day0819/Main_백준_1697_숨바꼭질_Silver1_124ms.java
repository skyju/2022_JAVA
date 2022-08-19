import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1697_숨바꼭질_Silver1_124ms {

	static int N, K, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;

		// x에서의 이동 선택지 :
		// 1. x - 1 으로 이동
		// 2. x + 1 으로 이동
		// 3. x * 2 으로 이동
		bfs();
		System.out.println(min);
	}

	static int[] visit;

	public static void bfs() {
		// 필요한 자료구조 생성
		Queue<Integer> queue = new LinkedList<>();
		visit = new int[100001];

		// 0초 초기값 설정
		queue.offer(N);
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			if (now == K) {
				min = visit[now];
				break;
			}

			if (now - 1 >= 0 && visit[now - 1] == 0) {
				queue.offer(now - 1);
				visit[now - 1] = visit[now] + 1;
			}
			if (now + 1 < 100001 && visit[now + 1] == 0) {
				queue.offer(now + 1);
				visit[now + 1] = visit[now] + 1;
			}
			if (now * 2 >= 0 && now * 2 < 100001 && visit[now * 2] == 0) {
				queue.offer(now * 2);
				visit[now * 2] = visit[now] + 1;
			}
		}
	}
}
