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
            int k =Integer.parseInt(st.nextToken());
            int arr[][] = new int[n][n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
            	for(int j=0; j<n; j++){
                	arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int sum = 0;
            for(int i=0; i<n; i++){
                int cal = 0;
            	int row = 0;
            	for(int j=0; j<n; j++){
                	if(arr[i][j] == 1){
                       cal++; 
                    }else{
                        if(cal == k) sum++;
                    	cal=0;
                    }
                    if(arr[j][i] == 1) {
                    	row++;
                    }else{
                        if(row==k) sum++;
                    	row =0;
                    }
                }
                if(cal == k) sum++;
                if(row == k) sum++;
            }
            System.out.println("#" + test_case + " " + sum);
            
		}
	}
}