
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
			StringTokenizer st;
			char arr[][] = new char[num][10];
			StringBuilder sb = new StringBuilder();

			for(int i=0; i<num; i++){
				st= new StringTokenizer(br.readLine());
				String word = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				for(int j=0; j<a; j++){
					sb.append(word);
				}
			
			}
			
			int row = (sb.length()+9) /10;
			int k=0;
			System.out.println("#" + test_case);
			for(int i=0; i<row; i++){
				
				for(int j=0; j<10; j++){
					
					System.out.print(sb.charAt(k));
					k++;
					if(k>=sb.length()) break;
					
				}
			
				System.out.println();
			}
			
			
		}
	}
}