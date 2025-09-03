import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int cost[] = new int[4];
            int days[] = new int[13];
            int dp[] = new int[13];
            int total = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=12; i++){
                days[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=12; i++){
                dp[i] = dp[i-1] + Math.min(days[i]*cost[0], cost[1]);

                if(i>=3){
                    dp[i] = Math.min(dp[i], dp[i-3] + cost[2]);
                }
            }

            int result = Math.min(dp[12], cost[3]);
            System.out.println("#" + test_case + " " + result);
            

        }
    }
    
}

