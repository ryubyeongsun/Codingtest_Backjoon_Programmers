import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[] = new int[8];
            
            for(int i=0; i<8; i++){
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            int count = 1;
            while(arr[7] != 0){
                int first = 0;
                if( arr[0]-count <0){ 
                	first = 0;
                }else{
           			  first=arr[0]-count;
                }
            	for(int i=0; i<8; i++){
                    if(i==7){
                    	arr[i] = first;
                    }else{
                    	arr[i] = arr[i+1] ;
                    }
                    
                }
                if(count == 5) count = 1;
            	else count++;
            }
            System.out.print("#" + test_case +" ");
			for(int i=0; i<8; i++){
            	System.out.print(arr[i] + " ");
            } 
            System.out.println();
		}
	}
}