import java.util.*;
import java.io.*;
class Solution
{	
	public static void main(String args[]) throws Exception
	{	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++)
		{	
            int result = 0;
			int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[] = new int[100];
            for(int i=0; i<100; i++){
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<num; i++){
                int max_i=0; int min_i=0;  
                int max = 0; int min = Integer.MAX_VALUE;
            	for(int j=0; j<100; j++){
                    if(arr[j] > max){
                    	max = arr[j];
                        max_i = j;
                    }
                    if(arr[j] < min){
                    	min = arr[j];
                        min_i = j;
                    }
            }
            arr[max_i]--; arr[min_i]++;
             if(arr[max_i] - arr[min_i] == 1 || arr[max_i] - arr[min_i] == 0){
             	break;
             }
		}
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 100; i++) {
                if (arr[i] > max) max = arr[i];
                if (arr[i] < min) min = arr[i];
            }
            result = max - min;
            System.out.println("#" + test_case + " " + result);
	}
} 
}