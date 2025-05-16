import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
			
            int a_sum = p*w;
            int b_sum = 0;
            if( w<=r ){
            	b_sum=q;
            }else{
            	b_sum=q+ ( (w-r)*s);
            }
			int min = 0;
            if(a_sum > b_sum) min=b_sum;
            if(a_sum < b_sum) min=a_sum;
            System.out.println("#" + test_case + " " + min);
		}
	}
}