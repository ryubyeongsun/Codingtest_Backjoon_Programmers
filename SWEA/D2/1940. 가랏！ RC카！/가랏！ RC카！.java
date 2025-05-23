
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
			int s = 0;
			int cnt = 0;
			
			for(int i=0; i<num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				
				if(a == 1) {
					int b = Integer.parseInt(st.nextToken());
					cnt+=b;
				}else if( a== 2) {
					int b = Integer.parseInt(st.nextToken());
					if(cnt-b<0) {
						cnt = 0;
					}else {
						cnt-=b;
					}
				}
				
				s+=cnt;
			}
			
			System.out.println("#" + test_case + " " + s);
			
			

		}
	}
}