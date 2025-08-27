import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int pNum[];
    static List<Integer> list[];
    static boolean select[];
    static int mindiff;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        pNum = new int[N+1];
        list = new ArrayList[N+1];
        select = new boolean[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            pNum[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for(int j=0; j<num; j++){
                int m = Integer.parseInt(st.nextToken());
                list[i].add(m);
            }

        }
        mindiff = Integer.MAX_VALUE;
        dfs(1);
        System.out.println(mindiff==Integer.MAX_VALUE? -1 : mindiff);
        
    }

    public static void dfs(int dep){
        if(dep>N){
            ArrayList<Integer> ag = new ArrayList<>();
            ArrayList<Integer> bg = new ArrayList<>();

            for(int i=1; i<=N; i++){
                if(select[i]) ag.add(i);
                else bg.add(i);

            }

            if(ag.isEmpty() || bg.isEmpty()) return;

            if(chkBfs(ag) && chkBfs(bg)){
                int a = getPopulation(ag);
                int b = getPopulation(bg);
                mindiff = Math.min(mindiff, Math.abs(a-b));
            }
            return;
        }

        select[dep] = true;
        dfs(dep+1);
        select[dep] = false;
        dfs(dep+1);

    }
    
    public static boolean chkBfs(ArrayList<Integer> g){
        if(g.isEmpty()) return false;

        boolean visit[] = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(g.get(0));
        visit[g.get(0)] = true;
        
        int count = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int nx : list[cur]){
                if(!visit[nx] && g.contains(nx)){
                    visit[nx] = true;
                    count++;
                    q.offer(nx);
                }

            }

        }

        return count == g.size();
    }
    public static int getPopulation(ArrayList<Integer> g){
        int sum = 0;
        for(int group : g){
            sum += pNum[group];
        }
        return sum;
    }

}
