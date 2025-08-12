
import java.util.*;
import java.io.*;


class Solution
{
	static int N;
	static int cal[];
    static int num[];
	static int cal_result[];
	static int max;
	static int min;

	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			cal =  new int[4];
            cal_result = new int[N-1];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i=0; i<4; i++){
				cal[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++){
					num[i] = Integer.parseInt(st.nextToken());
				
			}
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            dfs(0);

            int diff = max-min;
            bw.write("#"+ test_case + " " +  diff + "\n");
		}
        bw.close();
        br.close();
	}
	public static void dfs(int dep){	
		if(dep==N-1){
            int result = num[0];
            for(int i=0; i<N-1; i++){
                switch (cal_result[i]) {
                    case 0:
                        result += num[i+1];
                        break;
                    case 1:
                        result -= num[i+1];
                        break;
                    case 2:
                        result *= num[i+1];
                        break;
                    case 3:
                        if(result<0){
                            result = -(Math.abs(result)/num[i+1]);
                        }else{
                            result/=num[i+1];
                        }
                        break;
                }
            }
            max = Math.max(max, result);
            min = Math.min(min, result);

		}

		for(int i=0; i<4; i++){
			if(cal[i]>0){
				cal[i]--;
                cal_result[dep] = i; 
				dfs(dep+1);
				cal[i]++;
			}
			
		}
		

	}
}