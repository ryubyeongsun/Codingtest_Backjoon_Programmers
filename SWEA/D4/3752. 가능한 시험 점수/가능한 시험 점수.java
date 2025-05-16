import java.util.*;
import java.io.*;

class Solution
{	
    static int arr[];
    static Set<Integer> set;
    static int num;
    static boolean[][] visit;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[num];
            set =new TreeSet<>();
            int total = 0;
            for(int i=0; i<num; i++){
            	arr[i] = Integer.parseInt(st.nextToken());
                total+=arr[i];
            }
            set = new TreeSet<>();
            visit = new boolean[num + 1][total + 1];
           	dfs(0,0);
		
            System.out.println("#" + test_case + " " + set.size());
		}
	}
    static void dfs(int index, int sum){
        if (visit[index][sum]) return; 
        visit[index][sum] = true;
    	if(index == num) {
        	set.add(sum);
            return;
        }
            
           
        dfs(index+1, sum+arr[index]);
        
        dfs(index+1, sum);
            
            
            
    }
}