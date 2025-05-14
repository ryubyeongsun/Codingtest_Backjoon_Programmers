import java.util.*;
import java.io.*;
class Solution
{ 
    static int arr[][];
    static int max = 0;
    static int sum_p=0;
    static int sum_cal=0;
    static int max_cal;
    static int num;
    
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{	
            StringTokenizer st= new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            max_cal = Integer.parseInt(st.nextToken());
            arr = new int[num][2];
            
            for(int i=0; i<num; i++){
                st = new StringTokenizer(br.readLine());
            	for(int j=0; j<2; j++){
                	arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
			dfs(0,0,0);
            System.out.println("#" + test_case + " " + max);
            max = 0;
            sum_p=0;
            sum_cal=0;
            
		}
	}
    static void dfs(int index, int sum_p, int sum_cal){
    	if(sum_cal>max_cal) return;
        if(index==num) {
        	max = Math.max(max, sum_p);
            return;
        }
        dfs(index+1, sum_p+arr[index][0], sum_cal+arr[index][1]);
        
        dfs(index+1, sum_p, sum_cal);
        
    }
}