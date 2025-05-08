
import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		for(int test_case = 1; test_case <= 10; test_case++)
		{	
            int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[] = new int[num];
            int del = 0;
            int sum = 0;
            for(int i=0; i<num; i++){
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=2; i<num-2; i++){
            	int max_L =0;
                int max_R = 0;
                int result = 0;
                max_L = Math.max(arr[i-2], arr[i-1]);
                max_R = Math.max(arr[i+1], arr[i+2]);
                result = Math.max(max_L, max_R);
               	del = arr[i] - result;
                if (del > 0){
                	sum+=del;
                }
                  
            }
            System.out.println("#" + test_case + " " + sum);
		}
	}
}