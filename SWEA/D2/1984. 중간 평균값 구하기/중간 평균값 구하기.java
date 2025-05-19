import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int arr[] = new int[10];
            int max =0;
            int min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i=0; i<10; i++){
					arr[i] = Integer.parseInt(st.nextToken());
                	max=Math.max(max, arr[i]);
                	min=Math.min(min, arr[i]);
                }
            int sum=0;
            for(int i=0; i<10; i++){
            	if(arr[i] == min || arr[i]==max) continue;
                sum+=arr[i];
            }
            
            System.out.println("#" + test_case + " "  + Math.round(sum/8.0));
            
		}
	}
}