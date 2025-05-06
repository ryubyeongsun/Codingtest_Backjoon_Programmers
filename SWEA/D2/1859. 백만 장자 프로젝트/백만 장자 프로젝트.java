
import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int max = 0;
            long sum = 0;
 			int num = Integer.parseInt(br.readLine());
            int arr[]=new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0; i<num; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
			for(int j=num-1; j>=0; j--){
            	if(max<arr[j]) {
                	max = arr[j];
                }
                if(max-arr[j]>0){
                sum+= max-arr[j];
                }
            }
            System.out.println("#" + test_case + " " + sum);

		}
	}
}