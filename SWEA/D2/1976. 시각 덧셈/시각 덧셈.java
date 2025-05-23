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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int hour = Integer.parseInt(st.nextToken());
			int min = Integer.parseInt(st.nextToken());
			int	hour2 = Integer.parseInt(st.nextToken());
			int min2 = Integer.parseInt(st.nextToken());

			int sumh=hour+hour2;
			int summ=min+min2;
			
			if(summ>=60){
				sumh+=summ/60;
				summ = summ%60;
			}
			
			if(sumh>12){
				if(sumh == 24){
					sumh= 12;
				}else{
					sumh%=12;
				}
			}
			 
			System.out.println("#" + test_case + " " + sumh +" " + summ);

		}
	}
}