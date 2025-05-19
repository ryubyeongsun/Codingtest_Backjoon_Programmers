
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
			int result = 0;
			int arr[] = new int[n];
			int brr[] = new int[m];
			int max =0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++){
				brr[i] = Integer.parseInt(st.nextToken());
			}

			if(n<m){
				for(int i=0; i<=m-n; i++){
					
					result=0;
					for(int j=0; j<n; j++){
						result+=arr[j]*brr[j+i];
					}
					max=Math.max(max, result);
										
				}
			}
			else{
				for(int i=0; i<=n-m; i++){
				
					result=0;
					for(int j=0; j<m; j++){
						result+=arr[j+i]*brr[j];
					}
					max=Math.max(max, result);
										
				}
			}
			
			System.out.println("#" + test_case + " " + max);

		}
	}
}