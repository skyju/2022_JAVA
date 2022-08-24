import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Solution_SWEA_7465_창용마을무리의개수_D4_141ms {
     
    static int[] root;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
            int N = Integer.parseInt(st.nextToken()); // 사람의 수
            int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
            root = new int[N + 1]; // 0 dummy
             
            // Node 번호 설정
            for (int i = 1; i <= N; i++) root[i] = i;
             
            // 친구 관계 입력받기 및 유니온 진행
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
             
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 1; i <= N; i++) set.add(find(i));
             
            sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
        } // test case for문 끝
        System.out.println(sb.toString());
    } // main method 끝
 
    public static int find(int i) {
        if (root[i] == i) return i;
        else return root[i] = find(root[i]);
    }
 
    public static void union (int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) return;
        root[A] = B;
    }
}