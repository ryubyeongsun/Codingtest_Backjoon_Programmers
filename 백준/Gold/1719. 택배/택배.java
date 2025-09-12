import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int dp[][] = new int[n+1][n+1];
        int result[][] = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0; 
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int move = Integer.parseInt(st.nextToken());

            dp[a][b] = move;
            dp[b][a] = move;

            result[a][b] = b; 
            result[b][a] = a; 
        }


        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                        result[i][j] = result[i][k];
                    }
                }
            }
        }
    
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j) sb.append("- ");
                else sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
