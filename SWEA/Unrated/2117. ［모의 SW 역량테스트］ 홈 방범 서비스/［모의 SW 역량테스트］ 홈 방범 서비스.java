import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int max = 0;

            int arr[][] = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){

                    for(int K=1; K<=N+1; K++){
                        int cost = K * K + (K - 1) * (K - 1);
                        int count = 0;
                        for(int r=0; r<N; r++){
                            for(int c=0; c<N; c++){
                                if(arr[r][c]==1 && Math.abs(i-r) + Math.abs(j-c) < K){
                                    count++;
                                }

                            }
                        }
                        int homecost = count*M;
                        if(cost<=homecost){
                            max= Math.max(max, count);
                        }

                    }


                }
            }

            System.out.println("#" + test_case + " " + max);

		}

	}
    
}