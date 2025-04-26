import java.io.*;
import java.util.*;

class Main{
    static ArrayList<Integer> [] list;
    static boolean[] visit;
    public static void main(String[] argc)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
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
        for(int i=1; i<=N; i++){
            Collections.sort(list[i]);
        }
        visit = new boolean[N+1];
        dfs(V);
        System.out.println();
        visit = new boolean[N + 1];
        bfs(V);

    }
     static void dfs(int n){
        visit[n] = true;
        System.out.print(n+" ");
        
        for(int num : list[n]){
            if(!visit[num]){
                dfs(num);
            }
        }

    }

    static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for(int num : list[node]){
                if(!visit[num]){
                    visit[num] = true;
                    q.add(num);
                }
            }

        }

    }
}