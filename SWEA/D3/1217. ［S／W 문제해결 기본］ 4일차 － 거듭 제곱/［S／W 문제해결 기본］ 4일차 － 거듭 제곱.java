import java.util.Scanner;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner br = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int num = br.nextInt();
			

			int n = br.nextInt();
			int m = br.nextInt();
			int result = 1;
			for(int i=0; i<m; i++){
				result*=n;
			}
			System.out.println("#" + test_case+ " " + result);

		}
	}
}