import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> list[];
    static boolean [] visit;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        visit = new boolean[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);

        }
        if(!list[1].isEmpty()){
            dfs(1,0);

        }else{
            sum=1;
        }
        bw.write(String.valueOf(sum-1));
        bw.flush();
        br.close();
        bw.close();

    }   
    public static void dfs(int a, int dep){

		if(dep>2) return;

		if(!visit[a]){
			visit[a] = true;
			sum++;
		}

        for(int num : list[a]){
            dfs(num, dep+1);

        }

    }
}
