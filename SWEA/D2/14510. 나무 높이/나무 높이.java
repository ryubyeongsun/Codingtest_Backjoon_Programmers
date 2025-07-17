import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tree[] = new int[num];

            for(int i=0; i<num; i++){
                tree[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tree);

            int max = tree[num-1];
            int a1 =0;
            int a2 =0;

            for(int i=0; i<tree.length-1; i++){
                int diff = max - tree[i];
                a1 += diff%2;
                a2 += diff/2;
            } 

            int day = 0;  
            int a11 = 0;
            
            while(a1 > 0 || a2 > 0) {
                day++;
                if(day % 2 == 1 ){
                    if(a1>0) a1--;
                    else{
                        a11++;
                        if(a11 == 2 && a2 >0){
                            a2--;
                            a11=0;
                        }
                    }
                }else{
                    if(a2>0) a2--;
                }
              
            }
            System.out.println("#"+ test_case +" "+ day);

		
		}
	}
}