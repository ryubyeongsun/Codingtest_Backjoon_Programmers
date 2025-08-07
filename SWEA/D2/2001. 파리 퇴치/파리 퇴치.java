import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int max = 0;
            int arr[][] = new int[N+1][N+1];
            int sum[][] = new int[N+1][N+1];

            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] + arr[i][j] - sum[i-1][j-1];
                }
            }
            
            for(int i=M; i<=N; i++){
                for(int j=M; j<=N; j++){
                    int total = sum[i][j] - sum[i-M][j] - sum[i][j-M] + sum[i-M][j-M];
                    max = Math.max(max, total);
                }
            }
            
            bw.write("#" + test_case + " " + max);
            bw.newLine();

		}
        bw.close();
        br.close();
	}
}