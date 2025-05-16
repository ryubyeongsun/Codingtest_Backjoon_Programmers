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
			String word = br.readLine();
            String rev="";
            int check = 0;
            for(int i=word.length()-1; i>=0; i--){
            	rev+=word.charAt(i);
            }
            if(rev.equals(word)) check =1;
			else check = 0;
            System.out.println("#" + test_case + " " + check);
		}
	}
}