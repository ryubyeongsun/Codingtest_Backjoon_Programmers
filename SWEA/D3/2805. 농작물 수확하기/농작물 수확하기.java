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
            int med = num/2;
            int left = med;
            int right = med; 
            for(int i=0; i<num; i++){
                String word = br.readLine();
            	for(int j=0; j<num; j++){
                	arr[i][j] = word.charAt(j) - '0';
                }
            }
            int sum=0;
            for(int i=0; i<=med; i++){
            	for(int j=left; j<=right; j++){
                	sum+=arr[i][j];
                }
            	left--;
                right++;
            }
            left  = 1;
            right = num-2;
            for(int i = med+1; i<num; i++){
            	for(int j=left; j<=right; j++){
                	sum+=arr[i][j];
                }
            	left++;
                right--;
            }
			System.out.println("#" + test_case + " " +sum);
		
		}
	}
}