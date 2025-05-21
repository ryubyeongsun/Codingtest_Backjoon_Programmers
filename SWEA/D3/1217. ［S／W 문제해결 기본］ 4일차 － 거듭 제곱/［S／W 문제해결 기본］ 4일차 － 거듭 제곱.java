import java.util.Scanner;
;


class Solution
{	
	static int result =1;
	static int m;
	static int n;
	public static void main(String args[]) throws Exception
	{
		Scanner br = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int num = br.nextInt();
		

			n =br.nextInt();
			m =br.nextInt();
			
			dfs(1);

			System.out.println("#" + test_case + " " + result);
			result=1;

		}
	}
	static void dfs(int index){
		if(m==index){
			result*=n;
			return;
		}
		result*=n;
		dfs(index+1);

	}
}