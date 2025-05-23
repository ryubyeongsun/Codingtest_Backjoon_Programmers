
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String arr[] = {"ZRO", "ONE" , "TWO", "THR", "FOR", "FIV" ,"SIX", "SVN", "EGT", "NIN"};
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String ts = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			String a[] = new String[num];
			int result[] = new int[num];
			for(int i=0; i<num; i++) {
				a[i] = st.nextToken();
			}
			
			for(int i=0; i<num; i++) {
				for(int j=0; j<10; j++) {
					if(a[i].equals(arr[j])) {
						result[i] = j;
					}
				}
				
			}
			
			Arrays.sort(result);
			System.out.println("#" + test_case);
			for(int i=0; i<num; i++) {
				System.out.print(arr[result[i]] + " ");
			}
			System.out.println();
			
		}
	}
}