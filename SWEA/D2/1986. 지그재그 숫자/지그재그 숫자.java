
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
			int sum=0;
			for(int i=1; i<=num; i++){
				if(i%2==0){
					sum-=i;
				}else{
					sum+=i;
				}

			}
		
			System.out.println("#" + test_case + " " + sum);
		}
	}
}