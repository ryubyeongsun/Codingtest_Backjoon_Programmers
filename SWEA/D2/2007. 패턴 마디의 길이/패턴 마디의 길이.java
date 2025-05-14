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
			String word = br.readLine();
            char arr [] = new char [30];
            for(int i=0; i<30; i++){
            	arr[i] = word.charAt(i);
            }
          	int check=0;
           		for(int j=1; j<30; j++){
                	if(arr[0] == arr[j] ){
                    	if(arr[1] == arr[j+1] ){
                        	check = j;
                            break;
                        }
                    }
                }
    		 System.out.println("#" + test_case + " " + check);      
	
		}
	}
}