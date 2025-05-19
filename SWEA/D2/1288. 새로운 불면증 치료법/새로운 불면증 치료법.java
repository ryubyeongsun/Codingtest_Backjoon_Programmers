
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
			Set<Character> set = new HashSet<>();

			int a=0;
			int i=1;
			while (true) {
				a=i*num;
				String word = Integer.toString(a);
				
				for(int j=0; j<word.length(); j++){
					set.add(word.charAt(j));
				}

				if(set.size() == 10) break;
				i++;
			}			
			System.out.println("#" + test_case + " " + a);
			
		}
	}
}