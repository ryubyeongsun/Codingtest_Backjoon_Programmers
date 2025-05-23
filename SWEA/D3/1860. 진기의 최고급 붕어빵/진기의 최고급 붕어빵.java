
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
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			boolean chk = false;

			
			st=new StringTokenizer(br.readLine());
			int arr[] = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
			}
			
			Arrays.sort(arr);
			
			for(int i=0; i<n; i++) {
				if( (arr[i]/m )*k >= i +1) {
					chk = true;
				}else {
					chk = false;
					break;
					
				}
			}
			if(chk) {
				System.out.println("#" + test_case + " " + "Possible");
			}else {
				System.out.println("#" + test_case +" " + "Impossible");
			}

		}
	}
}