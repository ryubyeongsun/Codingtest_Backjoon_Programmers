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
            char arr[][] = new char[8][8];
            int count  = 0;
           for(int i=0; i<8; i++){
           	String word = br.readLine();
             for(int j=0; j<8; j++){
             	arr[i][j] = word.charAt(j);
             }
           }
            for(int i=0; i<8; i++){
            	for(int j=0; j<8; j++){
                    String text = "";
                    String cmp = "";
                    String text_a="";
                    String cmp_a="";
                    if(j+num <= 8){
                	for(int k=j; k<j+num; k++){
                    	text+=arr[i][k];
                        text_a+=arr[k][i];
                    }
                    for(int z=j+num-1; z>=j; z--){
                    	cmp+=arr[i][z];
                        cmp_a+=arr[z][i];
                    }
                	if(text.equals(cmp)) { count++; }
                    if( text_a.equals(cmp_a)) { count++; }
                    }
                }
            	
            }
            System.out.println("#" + test_case + " " + count);
			

		}
	}
}