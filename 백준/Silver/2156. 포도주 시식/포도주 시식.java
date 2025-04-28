import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] argc)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int max = 0;
        int w[] = new int[10001];
        int dp[] = new int[10001];

        for(int i=1; i<=num; i++){
            w[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = w[1];
        dp[2] = w[1] + w[2];    
        dp[3] = Math.max(Math.max(w[1]+w[2] , w[2]+w[3]), w[1]+w[3]);

        for(int i=4; i<=num; i++){
            dp[i] = Math.max(
                Math.max(
                    dp[i-1],
                    dp[i-2] + w[i]
                ),
                dp[i-3] + w[i-1] + w[i] 
            );
        
        }

        System.out.println(dp[num]);

	}
}