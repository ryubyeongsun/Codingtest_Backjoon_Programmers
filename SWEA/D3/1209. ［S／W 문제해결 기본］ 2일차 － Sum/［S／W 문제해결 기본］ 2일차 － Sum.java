import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 for (int test_case = 1; test_case <= 10; test_case++)
		{	int T = Integer.parseInt(br.readLine());
			int arr[][] = new int[100][100];
            int line_r = 0;
            int line_l = 0;
            int max_row =0; 
            int max_col = 0;
            int max =0;
            int result=0;
            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
             	for(int j=0; j<100; j++){
                	arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<100; i++){
            	int sum_row =0;
                int sum_col = 0;
                for(int j =0; j<100; j++){
                	sum_row += arr[i][j];
                    sum_col += arr[j][i];
                }
                max_row = Math.max(max_row, sum_row);
                max_col = Math.max(max_col, sum_col);
                line_r += arr[i][i];
                line_l += arr[i][99-i];
            }
            max = Math.max(max_row, max_col);
            result  = Math.max(Math.max(line_r, line_l) , max);
            System.out.println("#" + test_case + " " + result);
            
            }
        	
		}
	}