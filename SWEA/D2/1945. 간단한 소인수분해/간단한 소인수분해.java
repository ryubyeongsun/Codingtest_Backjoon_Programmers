
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
			int a=0; 
			int b=0;
			int c=0;
			int d=0;
			int e=0;
			int result=num;
			while (true) {
				if(result%2 == 0){
					result/=2;
					a++;
				}else if(result%3==0){
					result/=3;
					b++;
				}else if(result%5==0){
					result/=5;
					c++;
				}else if(result%7==0){
					result/=7;
					d++;
				}else if(result%11==0){
					result/=11;
					e++;
				}else{
					break;
				}

			}
			System.out.println("#" + test_case + " " + a + " "+ b +" " + c + " " + d + " " +e);

		}
	}
}