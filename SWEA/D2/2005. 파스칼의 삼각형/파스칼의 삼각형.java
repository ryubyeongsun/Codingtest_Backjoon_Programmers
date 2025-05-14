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
			int num = Integer.parseInt(br.readLine());
           	int arr[][] = new int[num][num];
            
            for(int i=0; i<num; i++){
                  	arr[i][0] = 1;
            }
            for(int i=1; i<num; i++){
            	for(int j=1; j<num; j++){
                	arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                }
            }
           	System.out.println("#"+test_case);
            for(int i=0; i<num; i++){
            	for(int j=0; j<=i; j++){
                	System.out.print(arr[i][j] + " "); 
                }
            	System.out.println();
            }
            
		
		}
	}
}