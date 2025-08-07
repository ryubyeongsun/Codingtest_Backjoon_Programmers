import java.util.*;
import java.io.*;
class Solution
{  
    static int arr[][];
    static int N;
    static int L;
    static int calsum;
    static int point;
    static int max;
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{	
            StringTokenizer st = new StringTokenizer(br.readLine());
             N = Integer.parseInt(st.nextToken());
             L = Integer.parseInt(st.nextToken());

            arr = new int[N][2];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<2; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = 0;
            point = 0;
            calsum = 0;
            dfs(0, 0, 0);
            bw.write("#" + test_case + " " + max);
            bw.newLine();
		}
        bw.close();
        
	}
    public static void dfs(int dep, int point, int calsum){
        if(calsum>L)  return;
        if(N==dep){
            max = Math.max(max, point);
            return;
        }
        
        dfs(dep+1,point+arr[dep][0] , calsum+arr[dep][1]);

        dfs(dep+1,point,calsum);
            
    }
    
}