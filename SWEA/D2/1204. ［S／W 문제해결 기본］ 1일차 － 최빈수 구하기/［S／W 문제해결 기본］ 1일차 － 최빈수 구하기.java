
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
            int arr[] = new int[1000];
            int point[] = new int[101];
            int max = 0;
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
           	for(int i=0; i<1000; i++){
            	arr[i] = Integer.parseInt(st.nextToken());
                point[arr[i]]++;
            } 
           	
            for(int i=0; i<=100; i++){
            	if(point[i] > max){
                	max = point[i];
                    result = i;
                }else if(point[i] == max){
                	 if(result < i){
                     	result = i;
                     }
                }
            }
            
            
			System.out.println("#" + test_case + " " + result );
            max = 0;

		}
	}
}