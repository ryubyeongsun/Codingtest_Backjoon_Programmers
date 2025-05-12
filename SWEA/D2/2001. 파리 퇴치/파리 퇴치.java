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
			StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int arr[][] = new int[n][n];
            int sum = 0;
            int max = 0;
            
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
            	for(int j=0; j<n; j++){
                	arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
                	for(int k=i; k<i+m; k++){
                     	for(int z=j; z<j+m; z++){
                            if(i+m>n || j+m>n || i<0 || j<0){ continue;}
                        	 sum+= arr[k][z];
                            max = Math.max(max, sum);
                            
                        }
                    }
                    sum=0;
                }
            }
            System.out.println("#" + test_case + " " + max);
		}
        
	}
}