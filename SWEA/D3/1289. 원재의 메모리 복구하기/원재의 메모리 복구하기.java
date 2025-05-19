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
			String num = br.readLine();
            int arr[] = new int[num.length()];
            int chk[] = new int[num.length()];
            int count = 0;
            for(int i=0; i<num.length(); i++){
            	arr[i] = num.charAt(i) - '0';
            }
            
            for(int i=0; i<arr.length; i++){
            	if(arr[i] != chk[i]){
                	if(arr[i] == 1){
                    	for(int j=i; j<arr.length; j++){
                        	chk[j] = 1;
                        }
                        count ++;
                    }if(arr[i] == 0){
                    	for(int j=i; j<arr.length; j++){
                        	chk[j] = 0;
                        }
                        count++;
                    }
                }
            }
				System.out.println("#" + test_case + " " + count);

		}
	}
}