import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String word = st.nextToken();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<word.length(); i++) {
				sb.append(word.charAt(i));
			}
			
			boolean chk = true;
			while (chk) {
				for(int i=0; i<sb.length()-1; i++) {
					if(sb.charAt(i) == sb.charAt(i+1)) {
						sb.delete(i,i+2);
						chk = true;
						break;
					}else {
						chk = false;
					}
					
				}
				
			}
			System.out.print("#" + test_case + " ");
			for(int i=0; i<sb.length(); i++) {
				System.out.print(sb.charAt(i));
			}
			System.out.println();
			
			
		}
	}
}