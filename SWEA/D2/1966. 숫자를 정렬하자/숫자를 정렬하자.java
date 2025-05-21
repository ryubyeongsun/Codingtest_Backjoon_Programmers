
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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[num];

			for(int i=0; i<num; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<num; i++){
				for(int j=i+1; j<num; j++){
					if(arr[i]>arr[j]){
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			System.out.print("#" + test_case +" ");
			for(int n : arr){
				System.out.print(n + " ");
			}
			System.out.println();
			
		}
	}
}