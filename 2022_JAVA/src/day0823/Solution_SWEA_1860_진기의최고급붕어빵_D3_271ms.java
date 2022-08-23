package day0823;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1860_진기의최고급붕어빵_D3_271ms {
	
    static int N, K, M;
    static int[] ariv, serve;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 붕어빵 먹을 수 있는 사람 수
            M = Integer.parseInt(st.nextToken()); // M초의 시간을 들여
            K = Integer.parseInt(st.nextToken()); // K개의 붕어빵을 만들 수 있다.
             
            ariv = new int[11112]; // index의 초에 도착한 사람 수를 저장해놓는 배열
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                ariv[Integer.parseInt(st.nextToken())] += 1;
            }
                 
            boolean flag = true;
            if (ariv[0] != 0) flag = false;
            serve = new int[11112]; // 초당 service 가능한 붕어빵 개수를 누적해서 가져갈 배열
            for (int i = 1; i < 11112 && flag; i++) {
                if (i % M == 0) serve[i] = serve[i - 1] + K;
                else serve[i] = serve[i - 1];
                if (serve[i] - ariv[i] < 0)  flag = false;
                else serve[i] -= ariv[i];
            }
             
            sb.append("#").append(tc).append(" ");
            if (flag) sb.append("Possible").append("\n");
            else sb.append("Impossible").append("\n");
         
        } // test case for문 종료
         
        System.out.println(sb.toString());
     
    } // main method 종료
} // class 종료
