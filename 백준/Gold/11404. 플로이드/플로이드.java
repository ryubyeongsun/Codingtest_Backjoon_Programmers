import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int dp[][] = new int[n+1][n+1];


        for(int i=1; i<=n; i++){
            Arrays.fill(dp[i], INF);
        }
        for(int i=1; i<=n; i++){
            dp[i][i] = 0;
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[a][b] = Math.min(dp[a][b], c);
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if (dp[i][j] == INF) System.out.print("0 ");
                else System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }




    }
}
