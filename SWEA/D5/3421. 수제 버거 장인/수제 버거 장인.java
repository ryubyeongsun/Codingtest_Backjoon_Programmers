
import java.util.*;
import java.io.*;

class Solution
{	
	static boolean[][] banmix;
	static int N;
	static int M;
	static int sum;
	static List<Integer> list;
	public static void main(String args[]) throws IOException
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T= Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			banmix = new boolean[N+1][N+1];

			for(int i=0; i<M; i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				banmix[a][b] = true;
				banmix[b][a] = true;
			}
			list = new ArrayList<>();
			sum=0;
			dfs(1, list);

			bw.write("#" + test_case + " " + sum);
			bw.newLine();
		}
		bw.close();
		br.close();
	}
	public static void dfs(int dep, List<Integer> list){

		if(dep>N){
			sum++;
			return;
		}

		boolean chk = true;
		for(int num : list){
			if(banmix[num][dep]){
				chk = false;
				break;
			}
		}
		if(chk){
			list.add(dep);
			dfs(dep+1,list);
			list.remove(list.size()-1);
		}

		dfs(dep+1,list);

	}
}