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
			int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];
			int first[][] = new int[n][n];
			int two[][] = new int[n][n];
			int three[][] = new int[n][n];
            
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
            	for(int j=0; j<n; j++){
                	arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
			int a = n-1; int b = n-1;
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					first[i][j] = arr[b][i];
					two[i][j] = arr[a][b];
					three[i][j] = arr[j][a];

					b--;
				}
				b = n-1;
				a--;
			}
			System.out.println("#" + test_case);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(first[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < n; j++) {
					System.out.print(two[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < n; j++) {
					System.out.print(three[i][j]);
				}
				System.out.println();
			}

		}
	}
}