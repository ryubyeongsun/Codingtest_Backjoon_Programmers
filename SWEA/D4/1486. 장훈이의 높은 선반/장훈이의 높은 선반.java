import java.util.*;
import java.io.*;

class Solution
{
    static int arr[];
    static int N;
    static int B;
    static int min;
	public static void main(String args[]) throws IOException
	{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;
            dfs(0,0);

            System.out.println("#" + test_case + " " + min);

		}
	}
    public static void dfs(int sum,int dep){

        if(sum >=B){
            int diff = sum-B;
            min = Math.min(min, diff);
            return;
        }
        if(dep == N) return;

        dfs(sum+arr[dep], dep+1);
        dfs(sum , dep+1);

        




    }
}