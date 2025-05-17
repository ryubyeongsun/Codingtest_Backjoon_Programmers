
import java.util.*;
import java.io.*;
class Solution
{	
	static int n;
	static int col[];
	static int count = 0;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = Integer.parseInt(br.readLine());
			col = new int[n];
			dfs(0);
			System.out.println("#" + test_case + " " +count);
			count = 0;
			
		}
	}
	static void dfs(int row){
		if(row==n){
			count++;
			return;
		}

		for(int i=0; i<n; i++){
			col[row] = i;
			if(check(row)){
				dfs(row+1);
			}

		}

	}
	static boolean check(int row){

		for(int i=0; i<row; i++){
			if(col[row] == col[i] || Math.abs(col[row] - col[i]) == row - i){
				return false;
			}
		}

		return true;
	}
}