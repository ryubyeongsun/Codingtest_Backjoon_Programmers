
import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
			int num = Integer.parseInt(br.readLine());
			String find = br.readLine();
			String word = br.readLine();
			int count=0;

			for(int i=0; i<word.length(); i++){
				if(word.charAt(i) == find.charAt(0)){
					boolean chk = false;
					int k=i;
					for(int j=0; j<find.length(); j++){
						if(k==word.length()-1) break;
						if(word.charAt(k) == find.charAt(j)){
							chk=true;
						}else {chk = false; break; }
						k++;
					}
					if(chk) count++;
				}
			}
			System.out.println("#" + test_case + " " + count);

		}
	}
}