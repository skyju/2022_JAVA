import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    
    static int N, L, R;
    static int[][] A;
    static boolean[][] visit;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static ArrayList<Node> list;
    public static class Node {
        int x; 
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        A = new int[N][N];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(go());
    }
    
    public static int go() {
        int result = 0;
        while(true) {
            boolean isMove = false;
            visit = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visit[i][j]) {
                        int sum = bfs(i, j);
                        if(list.size() > 1) {
                            move(sum);
                            isMove = true;
                        }    
                    }
                }
            }
            if(!isMove) return result;;
            result++;
        }
    }
    
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>();
        
        q.offer(new Node(x, y));
        list.add(new Node(x, y));
        visit[x][y] = true;
        
        int sum = A[x][y];
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]) {
                    int diff = Math.abs(A[current.x][current.y] - A[nx][ny]);
                    if(L <= diff && diff <= R) {
                        q.offer(new Node(nx, ny));
                        list.add(new Node(nx, ny));
                        sum += A[nx][ny];
                        visit[nx][ny] = true;
                    }        
                }
            }
        }
        return sum;
    }
    
    public static void move(int sum) {
        int avg = sum / list.size();
        for(Node n : list) {
            A[n.x][n.y] = avg;
        }
    }
}
