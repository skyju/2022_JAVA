import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_13023_ABCDE_Gold5_236ms {
	
	static ArrayList<ArrayList<Integer>> list; // 인접 리스트
	static boolean flag;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		
		// 인접리스트 생성 및 초기화
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) list.add(new ArrayList<Integer>());
		
		// 친구 관계 input
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
			// 무향이므로 서로 친구관계를 넣어줘야 함
		}
		
		if (M < 4) { // 중복된 관계는 없으므로 최소 간선의 수를 충족하지 못함
			System.out.println(0);
			System.exit(0);
		}
		
		for (int now = 0; now < N && !flag; now++) {
			visit = new boolean[N]; // 현재 now의 친구관계를 체크할 배열을 초기화
			// 5개만 있으면 되잖아요!
			dfs(now, 1);
		}
		
		if (flag) System.out.println(1);
		else System.out.println(0);
	}
	
	public static void dfs(int now, int depth) {
		if (depth == 5) {
			flag = true;
			return;
		}
		
		visit[now] = true;
		for (int friend : list.get(now)) { // now의 친구 리스트를 가져와요.
			int next = friend;
			if (!visit[next]) dfs(next, depth + 1); // 방문한적 없던 친구면 그 친구로 dfs
		}
		visit[now] = false;
	}
}