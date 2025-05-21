
import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int m [] = {50000, 10000, 5000 , 1000, 500, 100, 50, 10};
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = Integer.parseInt(br.readLine());
			int result = num;
			int count[] = new int[8];

			for(int i=0; i<m.length; i++){
				count[i] = result/m[i];
				result%=m[i];

			}

			System.out.println("#"+test_case);

			for(int n : count){
				System.out.print(n + " ");
			}
			System.out.println();
		
		}
	}
}