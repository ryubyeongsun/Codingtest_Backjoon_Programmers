import java.io.*;
import java.util.*;

class Main{
    static int num;
    static ArrayList<Integer> list [];
    static boolean[] visit;
    static boolean foundcy = false;
    static boolean[] cycle;
    static int cystart = 0;
    static int dist[];
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        list = new ArrayList[num+1];
        for(int i=1; i<=num; i++){
            list[i] = new ArrayList<>();
        }

        visit = new boolean[num+1];
        cycle = new boolean[num+1];
        dist = new int[num+1];

        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        dfs(1,-1);
        bfs();

        for(int i=1; i<=num; i++){
            System.out.print(dist[i] + " ");
        }

        
    }
    static boolean dfs(int cur, int pre){
        visit[cur] = true;

        for(int next : list[cur]){
            if(!visit[next]){
                if(dfs(next, cur)){
                    if(!foundcy) cycle[cur] = true;
                    if(cur == cystart) foundcy = true;
                    return true;
                }

            }else if(next != pre && !foundcy){
                cycle[next] = true;
                cycle[cur] = true;
                cystart = next;
                return true;
            }

        }
        return false;

    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, -1);

        for(int i=1; i<=num; i++){
            if(cycle[i]){
                q.offer(i);
                dist[i] = 0;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int n : list[cur]){
                if(dist[n] == -1){
                    dist[n] = dist[cur] + 1;
                    q.offer(n);
                }
            }

        }

    }
    
}