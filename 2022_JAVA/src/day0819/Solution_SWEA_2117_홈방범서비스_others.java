import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_SWEA_2117_홈방범서비스_others {
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M, result;
    static int[][] city;
    static boolean[][] visited;
    static int[] dr = { -1,  0,  1,  0 };
    static int[] dc = {  0,  1,  0, -1 };
     
    public static void main(String[] args) throws IOException {
         
        T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
             
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 도시 크기
            M = Integer.parseInt(st.nextToken()); // 하나의 집이 지불할 수 있는 비용
            city = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    city[i][j] = Integer.parseInt(st.nextToken());
                }
            } /* 입력 끝 */
             
            result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    bfs(i, j);
                }
            }
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
         
    }
     
    static void bfs(int row, int col) {
 
        int cost = 0;
        int cnt = 0;
        int K = 1;
        Queue<Home> q = new LinkedList<Home>();
        q.offer(new Home(row, col));
        visited[row][col] = true;
 
        while (!q.isEmpty()) {
             
            // 현재 큐에 삽입된 좌표들 다 확인해봄
            int s = q.size();
            for (int i = 0; i < s; i++) {
                Home now = q.poll();
                
                if (city[now.row][now.col] == 1) cnt++; // 집 있으면 카운트
                for (int dir = 0; dir < 4; dir++) {
                    int nextR = now.row + dr[dir];
                    int nextC = now.col + dc[dir];
 
                    if (0 <= nextR && nextR < N && 0 <= nextC && nextC < N && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        q.offer(new Home(nextR, nextC));
                    }
                }
            }
 
            cost = K * K + (K - 1) * (K - 1);   // 가격
            // 손해가 아니면 모든 집에 서비스
            if (cnt * M - cost >= 0 && cnt > result) result = cnt;
            K++;
        }
    }
     
    static class Home {
        int row;
        int col;
        public Home(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}