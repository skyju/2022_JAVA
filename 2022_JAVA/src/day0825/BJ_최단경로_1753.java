package day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// visit 사용 할 경우, 주의!! 엑셀 파일 있음.
// 엑셀용 테케
// dijkstra_wrong 으로 풀면  0 3 5 8 13 이 나온다.
/*
5 5
1
2 5 3
3 4 3
2 3 2
1 2 3
2 4 10
0 3 5 8 6

5 5
5
2 5 3
3 4 3
2 3 2
1 2 3
2 4 10
INF INF INF INF 0
*/

// 112832    1044
// 111400    996 ( 가지치기  )
public class BJ_최단경로_1753 {

    static int V, E, K;
    static List<List<Edge>> vertex = new ArrayList<>(); // vertex 기준 edge list

    static boolean[] visit;
    static int[] cost; // (weight) K로부터 각 정점으로 가는 최소 비용 저장 // 초기는 충분히 큰 값 // prim 에는 없다.
    static PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>( (e1, e2) -> e1.c - e2.c );

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine());
    
    visit = new boolean[V+1];
    cost = new int[V+1]; // K 로부터 각 정점(index)으로 가는 최소 비용 관리

    // V+1 개
    // list.get(0)     // dummy
    // cost[0]         // dummy
    for (int i = 0; i <= V; i++) {
        vertex.add( new ArrayList<Edge>() );
        cost[i] = INF; // 충분히 큰 값
    } 
            
    // edges
    for (int i = 1; i <= E; i++) {
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        
        // v1 에서부터 갈 수 있는 Edge
        vertex.get(v1).add(new Edge(v2, w));
    }
                
    dijkstra();    
            
    for (int i = 1; i <= V; i++) {            
        System.out.println( cost[i] == INF ? "INF" : cost[i] );
    }
}

// 시작 정점을 pq 에 담고 시작
// pq 에서 꺼낸 간선의 정점(e.v)에서 갈 수 있는 다른 정점을 고려 (간선 리스트를 이용) 
//   K부터 다른 정점을(ne.v) 으로 가는 현재 비용 ( cost[ne.v] ) 과
//   K - e.v - ne.v 로 가는 비용( ne.c + cost[e.v] ) 를 비교
//   e.v 를 거쳐 가는 비용이 더 낮으면 cost[ne.v] 를 변경하고, 
//   비용이 낮아진 정점(ne.v) 으로 가는 간선을 만들어서 ( 새로 또는 기존의 값 갱신 ) pqueue 에 넣는다. 
//   다시 넣는 이유는? K 로부터 가는 비용이 갱신되었으므로 그 정점으로부터 가는 비용을 다시 따져 보기 위해

// pq는 항상 현재 비용보다 비용을 절감할 수 있는 간선들이 들어간다. 
// K부터의 비용(cost[])은 가장 큰 값으로 초기화 되므로 각 정점이 최초 고려될 경우는 모두 pq 에 담긴다. 

// 결국! 최초 비용은 크게 잡고, 시작 정점부터 갈 수 있는 정점을 고려하면서 비용을 절감하게 되는 정점이 생기면 다시 pqueue 에 넣고
// 계속 반복적으로 고려. 더 이상 비용을 절감할 정점이 나오지 않으면 종료

static void dijkstra() {
    // 시작 K        
    cost[K] = 0;
    pqueue.offer( new Edge(K, 0) ); // K로부터 갈 수 있는 모든 간선 넣지 X

    while( ! pqueue.isEmpty() ) {
        // 비용이 작은 것을 꺼내서
        Edge e = pqueue.poll();
        
        if (e.c > cost[e.v]) continue; // 일종의 가지치기, 이전에 pqueue 에 들어간 동일한 v(#excel:no 1) 에 대하 Edge가 있을 경우 새로 비용 갱신된 항목(#excel:no 2)에 의해 달라졌을 경우  
        if(visit[e.v]) continue;
        visit[e.v] = true; // 선택 정점 방문 처리, // visit 는 e.v 에 대해서는 하지만, ne.v 에 대해서는 하지 않는다.(다시 queue 로 들어가야 )
        
        // e 로부터 갈 수 있는 간선들 ne 에 대해서
        for ( Edge ne : vertex.get(e.v) ) {
            
            // K 에서 ne.v 로 가는 비용을 따진다.
            // ne.c       : e.v --> ne.v 로 가는 비용
            // cost[e.v]  : K --> e.v 로 가는 최소 비용
            // cost[e.v] + ne.c : K --> e.v --> ne.v 로 가는 비용
            // cost[ne.v] : K --> ne.v 로 가는 최소 비용
            
            // 현재 cost 에 계산된 기존 ne.v 로 가는 비용과 e.v 를 거쳐서 ne.v 로 가는 비용을 비교해서
            // 더 적으면 비용을 갱신하고 pqueue 에 담는다.
            if( !visit[ne.v] && cost[e.v] + ne.c < cost[ne.v] ) { 
                cost[ne.v] = ne.c + cost[e.v];
                
                // 1. 새로운 간선을 추가해도 되고
                pqueue.offer(new Edge(ne.v, cost[ne.v])); // 정점은 같은데 비용이 갱신된 Edge 를 새로 생성해서 추가 #excel:no 2
                
                // 2. ne 의 비용을 갱신해서 ne 를 넣어도 됨
//                    ne.c = cost[ne.v]; // 
//                    pqueue.offer(ne);
                }
            }
        }
    }

    // 틀린 경우
    // pqueue 에 담기 전에 visit check 하는 경우 X


static void dijkstra_wrong() {

    visit[K] = true;
    cost[K] = 0;
    pqueue.offer( new Edge(K, 0) );

    while( ! pqueue.isEmpty() ) {

        Edge e = pqueue.poll();
        
        for ( Edge ne : vertex.get(e.v) ) {
            if( !visit[ne.v] && ne.c + cost[e.v] < cost[ne.v] ) { 
                cost[ne.v] = ne.c + cost[e.v];
                visit[ne.v] = true;
                pqueue.offer(new Edge(ne.v, cost[ne.v])); 
            }
        }            
    }
}

// 방향이 있음.
// Edge 이지만, 실제로 정점을 선택하는 의미
static class Edge{
    int v;
    int c;
    
    public Edge(int v, int c) {
        this.v = v;
        this.c = c;
    }
}
}