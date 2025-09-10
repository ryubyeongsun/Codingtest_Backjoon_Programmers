import java.io.*;
import java.util.*;

public class Solution {
    static final int INF = 1_000_000_000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());		
		
		for(int test_case = 1; test_case <= T; test_case++) {			
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int dp[][] = new int[N+1][N+1];

            for(int i=1; i<=N; i++){
                Arrays.fill(dp[i], INF);
                dp[i][i] = 0;
            }

            for(int i=0; i<M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                dp[a][b] = 1;

            }



            for(int k=1; k<=N; k++){
                for(int i=1; i<=N; i++){
                    for(int j=1; j<=N; j++){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);

                    }
                }
            }

            int result = 0;

            for(int i=1; i<=N; i++){
                int count = 0;
                for(int j=1; j<=N; j++){
                    if(i==j) continue;
                    if(dp[i][j]!=INF || dp[j][i] != INF){
                        count++;
                    }
                }
                if(count==N-1) result++;
            }

            System.out.println("#" + test_case + " " + result);
		}
    
    }
    
}
