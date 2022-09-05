import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_11725_트리의부모찾기_Silver2_2000ms {
	
	static int N;
	static ArrayList<ArrayList<Integer>> list;
	static int[] parents;
    
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		list = new ArrayList<>();
        N = Integer.parseInt(br.readLine()); // 노드의 개수
        
        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        // 간선 정보 입력
        for (int i = 0; i < N - 1 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            
            // 무향 그래프
            list.get(first).add(second);
            list.get(second).add(first);
        }
        
        bfs();
        for(int i = 2; i < parents.length; i++)
        	System.out.println(parents[i]);
    }
    
    static void bfs() {
    	// 필요한 자료구조 생성
    	Queue<Integer> queue = new ArrayDeque<>();
    	parents = new int[N + 1]; // 0 dummy
    	
    	// 루트 노드부터 집어 넣자. 
    	queue.offer(1);
    	parents[1] = 1; //1의 부모는 자기 자신으로 둔다.
    	
    	while(!queue.isEmpty()) {
    		int now = queue.poll();
    		
    		for (int i : list.get(now)) {
    			if (parents[i] == 0) { // 처음 방문 하는 자식이 있다면 그 자식의 부모를 현재로 설정
    				parents[i] = now;
    				queue.offer(i);
    			}
    		}
    	}
    	
    }
}