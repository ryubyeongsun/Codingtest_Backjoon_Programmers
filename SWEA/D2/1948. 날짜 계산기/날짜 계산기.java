
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int cal[] = {31,28,31,30,31,30,31,31,30,31,30,31};

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());


			int mon = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			int mon2 = Integer.parseInt(st.nextToken());
			int day2 = Integer.parseInt(st.nextToken());
			int sum=0;
			
			if(mon==mon2){
				sum = day2-day+1;
			}else{
				for(int i=mon; i<mon2; i++){
					sum+=cal[i-1];
				}
				sum-=day-1;
				sum+=day2;
			}
			System.out.println("#" + test_case + " " + sum);

		}
	}
}