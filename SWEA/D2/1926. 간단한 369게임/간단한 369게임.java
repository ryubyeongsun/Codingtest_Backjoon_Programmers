
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine());
            for(int i = 1; i<=num; i++){
            		String num1 = Integer.toString(i);
                	int count = 0;
                	for(int j=0; j<num1.length(); j++){
                        char ch = num1.charAt(j);
                    	if(ch == '3' || ch == '6' || ch == '9'  ){
                        	count++;
                        }
                    }
                if(count > 0){
                	for(int z=0; z<count; z++){
                    	System.out.print("-");
                    }
                }else{ System.out.print(i); }
                System.out.print(" ");
            }
		}
	
}