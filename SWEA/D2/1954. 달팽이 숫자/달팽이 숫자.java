
import java.util.*;
import java.io.*;

class Solution
{	
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];
         	int x = 0; int y = 0; int ch=0;
            
            for(int i=1; i<=n*n; i++){
            	arr[x][y] = i;
                 
                 int cx = x+dx[ch];
                 int cy = y+dy[ch];
                
                if(cx<0 || cy<0 || cx>=n || cy>=n || arr[cx][cy] != 0){
                	ch = (ch+1) %4;
                   cx = x + dx[ch];
                   cy = y + dy[ch];
                }
                x = cx;
                y = cy;
            }
        	System.out.println("#"+test_case);
            for(int i=0; i<arr.length; i++){
            	for(int j=0; j<arr.length; j++){
                    System.out.print(arr[i][j] + " ");
                }
            	System.out.println();
            }
            
		}
	}
}