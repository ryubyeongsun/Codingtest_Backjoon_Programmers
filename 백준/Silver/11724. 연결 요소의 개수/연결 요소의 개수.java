import java.io.*;
import java.util.*;

class Main{
	static ArrayList<Integer> [] list;
	static boolean [] visit;
	static int sum = 0;
	public static void main(String[] argc)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++){
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		visit = new boolean[N+1];

		for(int i=1; i<=N; i++){
			if(!visit[i]){
                dfs(i);
                sum+=1;
            }
		}
			System.out.println(sum);
	}

	static void dfs(int n){
		visit[n] = true;

		for(int num : list[n]){
			if(!visit[num]){
				dfs(num);
			}
		}
	}
}