import java.util.*;
import java.io.*;

class Solution {
   
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
         
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	
        	int krr[] = new int[N+1];
        	int point[] = new int[N+1];
        	
        	for(int i=1; i<=N; i++) {
        		st = new StringTokenizer(br.readLine());
        		krr[i] = Integer.parseInt(st.nextToken());
        		point[i] = Integer.parseInt(st.nextToken());
        	}
        			
        	int dp[] = new int[K+1];
        	
        	for(int i=1; i<=N; i++) {
        		
        		for(int j=K; j>=krr[i]; j--) {
        			
        			dp[j] = Math.max(dp[j], dp[j-krr[i]] + point[i]);
        		}
        		
        	}

        	System.out.println("#" + test_case + " " + dp[K]);
          
        }
    }
}
