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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int arr[] = new int[8];
            StringBuilder sb = new StringBuilder();
            String text = "";
            int end = 0;
           	for(int i=0; i<a; i++){
                String word = br.readLine();
            	for(int j=b-1; j>=0; j--){
                	if(word.charAt(j)-'0' == 1){
                    	text =word;
                        end = j;
                        break;
                    }
                }
            }
            int start = end-55;
            for(int i=start; i<=end; i++){
            	sb.append(text.charAt(i) + "");
            }
            int m=0;
            for(int i=0; i<56; i+=7){
                String z = sb.substring(i,i+7);
               if (z.equals("0001101")) arr[m++] = 0;
                else if (z.equals("0011001")) arr[m++] = 1;
                else if (z.equals("0010011")) arr[m++] = 2;
                else if (z.equals("0111101")) arr[m++] = 3;
                else if (z.equals("0100011")) arr[m++] = 4;
                else if (z.equals("0110001")) arr[m++] = 5;
                else if (z.equals("0101111")) arr[m++] = 6;
                else if (z.equals("0111011")) arr[m++] = 7;
                else if (z.equals("0110111")) arr[m++] = 8;
                else if (z.equals("0001011")) arr[m++] = 9;
            }
            int sum_h = arr[0]+arr[2]+arr[4]+arr[6];
            int sum_z = arr[1]+arr[3]+arr[5]+arr[7];
           if (((sum_h * 3) + sum_z) % 10 == 0) {
                System.out.println("#" + test_case + " " + (sum_h + sum_z));
            }else {
                System.out.println("#" + test_case + " " + 0);
            }
		}
	}
}