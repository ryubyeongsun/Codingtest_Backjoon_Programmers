
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
			int sum=0;
            
            while(true){
                 if (a < b) {
                    a += b;
                } else {
                    b += a;
                }
                sum++;
                if(a>n || b>n){
                	break;
                }
                
            }
            System.out.println(sum);

		}
	}
}